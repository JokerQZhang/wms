package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.joker.wms.Constants;
import com.joker.wms.model.Enumeration;
import com.joker.wms.model.Geo;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.Person;
import com.joker.wms.model.StatusItem;
import com.joker.wms.model.Uom;
import com.joker.wms.model.User;
import com.joker.wms.service.EnumerationManager;
import com.joker.wms.service.MailEngine;
import com.joker.wms.service.PartyGroupManager;
import com.joker.wms.service.RoleManager;
import com.joker.wms.service.StatusItemManager;
import com.joker.wms.service.UomManager;
import com.joker.wms.service.UserManager;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Implementation of <strong>ActionSupport</strong> that contains
 * convenience methods for subclasses.  For example, getting the current
 * user and saving messages/errors. This class is intended to
 * be a base class for all Action classes.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class BaseAction extends ActionSupport {
    private static final long serialVersionUID = 3525445612504421307L;

    /**
     * Constant for cancel result String
     */
    public static final String CANCEL = "cancel";

    /**
     * Transient log to prevent session synchronization issues - children can use instance for logging.
     */
    protected final transient Log log = LogFactory.getLog(getClass());

    /**
     * The UserManager
     */
    protected UserManager userManager;

    /**
     * The RoleManager
     */
    protected RoleManager roleManager;

    /**
     * Indicator if the user clicked cancel
     */
    protected String cancel;

    /**
     * Indicator for the page the user came from.
     */
    protected String from;

    /**
     * Set to "delete" when a "delete" request parameter is passed in
     */
    protected String delete;

    /**
     * Set to "save" when a "save" request parameter is passed in
     */
    protected String save;

    /**
     * MailEngine for sending e-mail
     */
    protected MailEngine mailEngine;

    /**
     * A message pre-populated with default data
     */
    protected SimpleMailMessage mailMessage;

    /**
     * Velocity template to use for e-mailing
     */
    protected String templateName;
    
    protected Page page;
    
    protected EnumerationManager enumerationManager;
    protected UomManager uomManager;
    protected PartyGroupManager partyGroupManager;
    protected StatusItemManager statusItemManager;
    
    public void setStatusItemManager(StatusItemManager statusItemManager) {
		this.statusItemManager = statusItemManager;
	}

	public void setPartyGroupManager(PartyGroupManager partyGroupManager) {
		this.partyGroupManager = partyGroupManager;
	}

	public void setUomManager(UomManager uomManager) {
        this.uomManager = uomManager;
    }
    
    public void setEnumerationManager(EnumerationManager enumerationManager) {
        this.enumerationManager = enumerationManager;
    }
    
	public Page getPage() {
		if(page == null){
			page = new Page();
			page.setPageIndex(1);
			page.setPageSize(15);
			page.setPageNum(0);
			page.setAllRecordNum(0);
		}else{
			if(page.getPageIndex() == null){
				page.setPageIndex(1);
			}
			if(page.getPageSize() == null){
				page.setPageSize(15);
			}
			if(page.getPageNum() == null){
				page.setPageNum(0);
			}
			if(page.getAllRecordNum() == null){
				page.setAllRecordNum(0);
			}
		}
		
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	protected String jsonResult;
	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
     * Simple method that returns "cancel" result
     *
     * @return "cancel"
     */
    public String cancel() {
        return CANCEL;
    }

    /**
     * Save the message in the session, appending if messages already exist
     *
     * @param msg the message to put in the session
     */
    @SuppressWarnings("unchecked")
    protected void saveMessage(String msg) {
        List messages = (List) getRequest().getSession().getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList();
        }
        messages.add(msg);
        getRequest().getSession().setAttribute("messages", messages);
    }

    /**
     * Convenience method to get the Configuration HashMap
     * from the servlet context.
     *
     * @return the user's populated form from the session
     */
    protected Map getConfiguration() {
        Map config = (HashMap) getSession().getServletContext().getAttribute(Constants.CONFIG);
        // so unit tests don't puke when nothing's been set
        if (config == null) {
            return new HashMap();
        }
        return config;
    }

    /**
     * Convenience method to get the request
     *
     * @return current request
     */
    protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * Convenience method to get the response
     *
     * @return current response
     */
    protected HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     * Convenience method to get the session. This will create a session if one doesn't exist.
     *
     * @return the session from the request (request.getSession()).
     */
    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * Convenience method to send e-mail to users
     *
     * @param user the user to send to
     * @param msg the message to send
     * @param url the URL to the application (or where ever you'd like to send them)
     */
    protected void sendUserMessage(User user, String msg, String url) {
        if (log.isDebugEnabled()) {
            log.debug("sending e-mail to user [" + user.getEmail() + "]...");
        }

        mailMessage.setTo(user.getFullName() + "<" + user.getEmail() + ">");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", user);
        // TODO: figure out how to get bundle specified in struts.xml
        // model.put("bundle", getTexts());
        model.put("message", msg);
        model.put("applicationURL", url);
        mailEngine.sendMessage(mailMessage, templateName, model);
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public void setMailEngine(MailEngine mailEngine) {
        this.mailEngine = mailEngine;
    }

    public void setMailMessage(SimpleMailMessage mailMessage) {
        this.mailMessage = mailMessage;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * Convenience method for setting a "from" parameter to indicate the previous page.
     *
     * @param from indicator for the originating page
     */
    public void setFrom(String from) {
        this.from = from;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public void setSave(String save) {
        this.save = save;
    }
    
    public User getCurrentUser(){
    	SecurityContext ctx = SecurityContextHolder.getContext();
    	Authentication auth = ctx.getAuthentication();
    	User user = (User)auth.getPrincipal();
    	//获取partygroup
    	List<PartyGroup> cpartyGroup = (List<PartyGroup>)getRequest().getSession().getAttribute("currentPartyGroupList");
    	if(cpartyGroup == null || cpartyGroup.size()<1){
    		cpartyGroup = userManager.getPartyGroupByUser(user.getId().toString());
    		getRequest().getSession().setAttribute("currentPartyGroupList", cpartyGroup);
    	}
    	//获取person
    	Person cperson = (Person)getRequest().getSession().getAttribute("currentPerson");
    	if(cperson == null){
    		cperson = userManager.getPersonByUser(user.getId().toString());
    		getRequest().getSession().setAttribute("currentPerson", cperson);
    	}
    	return user;
    }
    public List<PartyGroup> getRelationPartyGroup(){
    	List<PartyGroup> cpartyGroup = (List<PartyGroup>)getRequest().getSession().getAttribute("currentPartyGroupList");
    	if(cpartyGroup == null || cpartyGroup.size()<1){
    		getCurrentUser();
    		cpartyGroup = (List<PartyGroup>)getRequest().getSession().getAttribute("currentPartyGroupList");
    	}
    	return cpartyGroup;
    }
    public Person getCurrentPerson(){
    	Person cperson = (Person)getRequest().getSession().getAttribute("currentPerson");
    	if(cperson == null){
    		getCurrentUser();
    		cperson = (Person)getRequest().getSession().getAttribute("currentPerson");
    	}
    	return cperson;
    }
    /**
     * 根据类型ID获取选项。
     * @param enumTypeId
     * @return
     */
    public String getEnumerationSelector(Long enumTypeId, Long selectedEnumId){
    	String options = "";
    	Map condition = new HashMap();
    	condition.put("enumTypeId", enumTypeId);
    	List selectEnum = enumerationManager.searchByCondition(condition, null);
    	if(selectEnum!=null && selectEnum.size()>0){
    		for(Enumeration sEnumeration : (List<Enumeration>)selectEnum){
    			if(selectedEnumId!=null && selectedEnumId==sEnumeration.getEnumId()){
    				options += "<option value='" + sEnumeration.getEnumId() + "' selected='selected'>" + sEnumeration.getDescription() + "</option>";
    			}else{
    				options += "<option value='" + sEnumeration.getEnumId() + "'>" + sEnumeration.getDescription() + "</option>";
    			}
    		}
    	}
    	return options;
    }
    /**
     * 获取指定数据字典类型下的所有选项，以map的方式返回，map的key为数据字典选项的ID，一般用于表格展示的时候显示对应数据字典ID的文字描述，这种方式用于较少的选项的时候，
     * 较多的时候这种方式太占内存，可以用另一种方式：查询某条记录的时候同时带出对应描述信息的对象，然后放到前台去展示
     * @param enumTypeId
     * @return
     */
    public Map<Object,Enumeration> getEnumerationMap(Long enumTypeId, String type){
    	Map<Object,Enumeration> result = new HashMap<Object,Enumeration>();
    	Map condition = new HashMap();
    	condition.put("enumTypeId", enumTypeId);
    	List selectEnum = enumerationManager.searchByCondition(condition, null);
    	if(selectEnum!=null && selectEnum.size()>0){
    		for(Enumeration sEnumeration : (List<Enumeration>)selectEnum){
    			if(type!=null && type.equals("Long")){
    				result.put(sEnumeration.getEnumId(), sEnumeration);
    			}else{
    				result.put(sEnumeration.getEnumId().toString(), sEnumeration);
    			}
    		}
    	}
    	return result;
    }
    public Map<Object,StatusItem> getStatusMap(Long statusTypeId, String type){
    	Map<Object,StatusItem> result = new HashMap<Object,StatusItem>();
    	Map condition = new HashMap();
    	condition.put("statusTypeId", statusTypeId);
    	List selectStat = statusItemManager.searchByCondition(condition);
    	if(selectStat!=null && selectStat.size()>0){
    		for(StatusItem statusItem : (List<StatusItem>)selectStat){
    			if(type!=null && type.equals("Long")){
    				result.put(statusItem.getStatusId(), statusItem);
    			}else{
    				result.put(statusItem.getStatusId().toString(), statusItem);
    			}
    		}
    	}
    	return result;
    }
    public String getUomSelector(Long uomTypeId, Long selectedUomId){
    	String options = "";
    	Map condition = new HashMap();
    	condition.put("uomTypeId", uomTypeId);
    	List selectUom = uomManager.searchByCondition(condition, null);
    	if(selectUom!=null && selectUom.size()>0){
    		for(Uom sUom : (List<Uom>)selectUom){
    			if(selectedUomId!=null && selectedUomId==sUom.getUomId()){
    				options += "<option value='" + sUom.getUomId() + "' selected='selected'>" + sUom.getDescription() + "</option>";
    			}else{
    				options += "<option value='" + sUom.getUomId() + "'>" + sUom.getDescription() + "</option>";
    			}
    		}
    	}
    	return options;
    }
    public String getEnumerationPYSelector(Long enumTypeId, Long selectedEnumId){
    	String options = "";
    	Map condition = new HashMap();
    	condition.put("enumTypeId", enumTypeId);
    	List selectEnum = enumerationManager.searchByCondition(condition, null);
    	if(selectEnum!=null && selectEnum.size()>0){
    		for(Enumeration sEnumeration : (List<Enumeration>)selectEnum){
    			if(selectedEnumId!=null && selectedEnumId==sEnumeration.getEnumId()){
    				options += "<option value='" + sEnumeration.getEnumId() + "' selected='selected'>" + sEnumeration.getDescription() + "[" + sEnumeration.getPinyinName() + "]</option>";
    			}else{
    				options += "<option value='" + sEnumeration.getEnumId() + "'>" + sEnumeration.getDescription() + "[" + sEnumeration.getPinyinName() + "]</option>";
    			}
    		}
    	}
    	return options;
    }
    public String getGeoSelector(Long parentGeoId, Long selectedGeoId){
    	String options = "";
    	Map condition = new HashMap();
    	condition.put("parentGeoId", parentGeoId);
    	List selectGeo = enumerationManager.getGeoLists(parentGeoId);
    	if(selectGeo!=null && selectGeo.size()>0){
    		for(Geo geo : (List<Geo>)selectGeo){
    			if(selectedGeoId!=null && selectedGeoId==geo.getGeoId()){
    				options += "<option value='" + geo.getGeoId() + "' selected='selected'>" + geo.getGeoName() + "</option>";
    			}else{
    				options += "<option value='" + geo.getGeoId() + "'>" + geo.getGeoName() + "</option>";
    			}
    		}
    	}
    	return options;
    }
    public String getUomPYSelector(Long uomTypeId, Long selectedUomId){
    	String options = "";
    	Map condition = new HashMap();
    	condition.put("uomTypeId", uomTypeId);
    	List selectUom = uomManager.searchByCondition(condition, null);
    	if(selectUom!=null && selectUom.size()>0){
    		for(Uom sUom : (List<Uom>)selectUom){
    			if(selectedUomId!=null && selectedUomId==sUom.getUomId()){
    				options += "<option value='" + sUom.getUomId() + "' selected='selected'>" + sUom.getDescription() + "[" + sUom.getPinyinName() + "]</option>";
    			}else{
    				options += "<option value='" + sUom.getUomId() + "'>" + sUom.getDescription() + "[" + sUom.getPinyinName() + "]</option>";
    			}
    		}
    	}
    	return options;
    }
    public PartyGroup getSuperPartyGroup(){
    	List<PartyGroup> pgl = getRelationPartyGroup();
    	if(pgl!=null && pgl.size()>0){
    		PartyGroup pg = pgl.get(0);
    		return pg;
    	}else{
    		return null;
    	}
    }
    public PartyGroup getNowZhibu(){
    	PartyGroup nowZhibu = partyGroupManager.getZhiBuByPersonId(getCurrentPerson().getPartyId());
    	//如果nowZhibu为空说名操作员可能不是党员，那么就取操作员归属上级机构的党支部
    	if(nowZhibu == null){
    		List pglist = getRelationPartyGroup();
    		if(pglist!=null && pglist.size()>0){
    			PartyGroup personpg = (PartyGroup)pglist.get(0);
    			nowZhibu = partyGroupManager.getZhiBuByCun(personpg.getPartyId());
    		}
    	}
    	return nowZhibu;
    }
}
