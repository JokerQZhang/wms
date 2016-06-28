package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.CpChargeManager;
import com.joker.wms.service.PartyGroupManager;
import com.joker.wms.service.PartyRelationshipManager;
import com.joker.wms.service.TzDhbzManager;
import com.joker.wms.service.TzDyzthManager;
import com.joker.wms.service.TzFwqzManager;
import com.joker.wms.service.TzGfmzManager;
import com.joker.wms.service.TzHjmdManager;
import com.joker.wms.service.TzZtjjManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.util.PinYinUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Party;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.PartyRelationship;
import com.joker.wms.model.PartyRole;
import com.joker.wms.model.Person;
import com.joker.wms.model.TzDhbz;
import com.joker.wms.model.TzDyzth;
import com.joker.wms.model.TzFwqz;
import com.joker.wms.model.TzGfmz;
import com.joker.wms.model.TzHjmd;
import com.joker.wms.model.TzZtjj;
import com.joker.wms.model.VillageInfo;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartyGroupAction extends BaseAction implements Preparable {
    private List partyGroups;
    private PartyGroup partyGroup;
    private Long pgId;
    private String query;
    private String parentId;
    private PartyRelationshipManager partyRelationshipManager;
    private String vendorId;
    private String partyId;
    private VillageInfo villageInfo;
    private String belongXingZhengPartyId;
    private TzDhbzManager tzDhbzManager;
    private TzDyzthManager tzDyzthManager;
    private TzFwqzManager tzFwqzManager;
    private TzGfmzManager tzGfmzManager;
    private TzHjmdManager tzHjmdManager;
    private TzZtjjManager tzZtjjManager;
    private CpChargeManager cpChargeManager;
    
    public void setCpChargeManager(CpChargeManager cpChargeManager) {
		this.cpChargeManager = cpChargeManager;
	}

	public void setTzDhbzManager(TzDhbzManager tzDhbzManager) {
		this.tzDhbzManager = tzDhbzManager;
	}

	public void setTzDyzthManager(TzDyzthManager tzDyzthManager) {
		this.tzDyzthManager = tzDyzthManager;
	}

	public void setTzFwqzManager(TzFwqzManager tzFwqzManager) {
		this.tzFwqzManager = tzFwqzManager;
	}

	public void setTzGfmzManager(TzGfmzManager tzGfmzManager) {
		this.tzGfmzManager = tzGfmzManager;
	}

	public void setTzHjmdManager(TzHjmdManager tzHjmdManager) {
		this.tzHjmdManager = tzHjmdManager;
	}

	public void setTzZtjjManager(TzZtjjManager tzZtjjManager) {
		this.tzZtjjManager = tzZtjjManager;
	}

    public String getBelongXingZhengPartyId() {
		return belongXingZhengPartyId;
	}

	public void setBelongXingZhengPartyId(String belongXingZhengPartyId) {
		this.belongXingZhengPartyId = belongXingZhengPartyId;
	}

	public VillageInfo getVillageInfo() {
		return villageInfo;
	}

	public void setVillageInfo(VillageInfo villageInfo) {
		this.villageInfo = villageInfo;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public void setPartyRelationshipManager(
			PartyRelationshipManager partyRelationshipManager) {
		this.partyRelationshipManager = partyRelationshipManager;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

    public List getPartyGroups() {
        return partyGroups;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String partyGroupId = getRequest().getParameter("partyGroup.pgId");
            if (partyGroupId != null && !partyGroupId.equals("")) {
                partyGroup = partyGroupManager.get(new Long(partyGroupId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map<String,String> conditon = new HashMap<String,String>();
        	conditon.put("roleTypeId", "1");
        	String roleTypeId = super.getRequest().getParameter("roleTypeId");
        	if(roleTypeId!=null && !"".equals(roleTypeId)){
        		conditon.put("roleTypeId", roleTypeId);
        	}
            partyGroups = partyGroupManager.search(conditon, PartyGroup.class, getPage());
        } catch (Exception se) {
        	se.printStackTrace();
            addActionError(se.getMessage());
            partyGroups = partyGroupManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setPgId(Long pgId) {
        this.pgId = pgId;
    }

    public PartyGroup getPartyGroup() {
        return partyGroup;
    }

    public void setPartyGroup(PartyGroup partyGroup) {
        this.partyGroup = partyGroup;
    }

    public String delete() {
        partyGroupManager.remove(partyGroup.getPgId());
        saveMessage(getText("partyGroup.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (pgId != null) {
            partyGroup = partyGroupManager.get(pgId);
        } else {
            partyGroup = new PartyGroup();
        }
        String geoOptions = super.getGeoSelector(null, partyGroup.getGeoid());
        super.getRequest().setAttribute("geoOptions", geoOptions);
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            partyGroupManager.remove(partyGroup.getPgId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (partyGroup.getPgId() == null);
        if(isNew){
        	//先保存party然后再保存partygroup
        	Party party = new Party();
        	party.setCreatedByUser(getCurrentUser().getId());
        	party.setCreatedTime(new Date());
        	party.setDescription(partyGroup.getGroupName());
        	party.setPartyTypeId("party_group");
        	party.setStatusId(0l);//状态正常
        	party = partyGroupManager.saveParty(party);
        	partyGroup.setPartyId(party.getPartyId());
        	
        	//保存完partygroup之后紧接着保存partygroup的relationship//新增肯定是按照关系来新增的不是独立新增的
        	PartyRole partyRole = new PartyRole();
        	partyRole.setCreatedByUser(getCurrentUser().getId());
        	partyRole.setCreatedTime(new Date());
        	partyRole.setRoleTypeId(1l);
        	//如果是company roletypeid为2
        	String isCompany = super.getRequest().getParameter("isCompany");
        	if(isCompany!=null&&"yes".equals(isCompany)){
        		partyRole.setRoleTypeId(2l);
        	}
        	partyRole.setPartyId(party.getPartyId());
        	partyRole = partyGroupManager.savePartyRole(partyRole);
        	//有父id的父id来出来保存relationship
        	if(parentId!=null && !"".equals(parentId)){
        		PartyRelationship partyRelationship = new PartyRelationship();
        		partyRelationship.setCreatedByUser(getCurrentUser().getId());
        		partyRelationship.setCreatedTime(new Date());
        		partyRelationship.setFromDate(new Date());
        		partyRelationship.setPartyIdFrom(Long.valueOf(parentId));
        		partyRelationship.setPartyIdTo(party.getPartyId());
        		partyRelationship.setPartyRelationshipTypeId(1l);
        		partyRelationship.setRoleTypeIdFrom(1l);
        		partyRelationship.setRoleTypeIdTo(1l);
        		partyRelationship.setStatusId(0l);
        		partyRelationshipManager.save(partyRelationship);
        	}
        }else{
        	partyGroup.setLastUpdatedByUser(getCurrentUser().getId());
        	partyGroup.setLastUpdatedTime(new Date());
        }
        if(getRequest().getParameter("partyGroup.pinyinName")==null || "".equals(getRequest().getParameter("partyGroup.pinyinName"))){
        	partyGroup.setPinyinName(PinYinUtil.getPinYinHeadChar(partyGroup.getGroupName()));
        }
        partyGroup = partyGroupManager.save(partyGroup);
        String key = (isNew) ? "partyGroup.added" : "partyGroup.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String partyGroupCustoms(){
    	Map condition = new HashMap();
    	condition.put("vendorId", vendorId);
    	condition.put("partyRelationshipTypeId", "2");//关系类型为供货商客户
    	partyGroups = partyGroupManager.searchRelationToPartyGroup(condition, getPage());
    	if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
    	return SUCCESS;
    }
    public String addcustom(){
    	String partyGroupOptions = partyGroupManager.getPartyGroupOptions();
    	getRequest().setAttribute("partyGroupOptions", partyGroupOptions);
    	return SUCCESS;
    }
    public String partyGroupsTree(){
    	String parentId = getRequest().getParameter("parentGroupId");
    	//当前操作员的归属PartyGroupId
    	if(parentId==null || parentId.equals("")){
    		List gplist = super.getRelationPartyGroup();
    		if(gplist!=null && gplist.size()>0){
    			PartyGroup pg = (PartyGroup)gplist.get(0);
    			getRequest().setAttribute("rootPg", pg);
    			parentId = pg.getPartyId().toString();
    		}
    		//用户的归属组织id为根节点
    		getRequest().setAttribute("isRoot", "isRoot");
    	}
    	
    	Map<String,String> conditon = new HashMap<String,String>();
    	//条件查询不考虑树形结构
    	if(query!=null && !"".equals(query)){
    		conditon.put("roleTypeId", "1");
    		conditon.put("groupName", query);
    		partyGroups = partyGroupManager.searchByCondition(conditon);
    		getRequest().setAttribute("showForm", "showData");
    		return SUCCESS;
    	}
    	conditon.put("searchType", "partyGroupTree");//查询树形结构
    	if(parentId!=null && !"".equals(parentId)){
    		//如果是根，则展现根的下一层
    		if("1".equals(parentId)){
    			getRequest().setAttribute("isRoot", "isRoot");
    		}
    		conditon.put("parentId", parentId);
    		conditon.put("partyRelationshipTypeId", "1");
    	}
    	partyGroups = partyGroupManager.searchByCondition(conditon);
    	
    	getRequest().setAttribute("showForm", "showData");
    	return SUCCESS;
    }
    public String zhibuTree(){
    	String parentId = getRequest().getParameter("parentGroupId");
    	if(parentId==null || "".equals(parentId)){
    		PartyGroup zhibuRoot = super.getNowZhibu();
    		if(zhibuRoot!=null){
    			parentId = zhibuRoot.getPartyId().toString();
    			getRequest().setAttribute("isRoot", "isRoot");
    			getRequest().setAttribute("zhibuRoot", zhibuRoot);
    		}
    	}
    	Map<String,String> conditon = new HashMap<String,String>();
    	//条件查询不考虑树形结构
    	if(query!=null && !"".equals(query)){
    		conditon.put("roleTypeId", "2");
    		conditon.put("groupName", query);
    		partyGroups = partyGroupManager.searchByCondition(conditon);
    		getRequest().setAttribute("showForm", "showData");
    		return SUCCESS;
    	}
    	conditon.put("searchType", "partyGroupTree");//查询树形结构
    	if(parentId!=null && !"".equals(parentId)){
    		//如果是根，则展现根的下一层
    		if("2".equals(parentId)){
    			getRequest().setAttribute("isRoot", "isRoot");
    		}
    		conditon.put("parentId", parentId);
    		conditon.put("partyRelationshipTypeId", "4");
    	}
    	partyGroups = partyGroupManager.searchByCondition(conditon);
    	
    	getRequest().setAttribute("showForm", "showData");
    	return SUCCESS;
    }
    //新增修改村信息
    public String editPartyGroupCun(){
    	//如果存在则修改
    	if(partyId!=null && !"".equals(partyId)){
    		Map<String,String> conditon = new HashMap<String,String>();
    		conditon.put("partyId", partyId);
    		List cunList = partyGroupManager.searchCun(conditon);
    		if(cunList!=null && cunList.size()>0){
    			Object[] obs = (Object[])cunList.get(0);
    			partyGroup = (PartyGroup)obs[0];
    			villageInfo = (VillageInfo)obs[1];
    		}
    	}
    	String isNowXiang = getRequest().getParameter("isNowXiang");
    	String method = getRequest().getParameter("method");
    	if(isNowXiang!=null && "xiang".equals(isNowXiang) && method!=null && "Add".equals(method)){
    		getRequest().setAttribute("aboutVillage", "yes");
    	}
    	if(isNowXiang!=null && "".equals(isNowXiang) && method!=null && "Modify".equals(method)){
    		getRequest().setAttribute("aboutVillage", "yes");
    	}
    	return SUCCESS;
    }
    public String savePartyGroupCun() throws Exception{
    	if(delete!=null && "1".equals(delete)){
    		//删除操作
    		Party party = new Party();
    		party.setPartyId(partyGroup.getPartyId());
    		party.setStatusId(-1L);
    		party = partyGroupManager.saveParty(party);
    		return SUCCESS;
    	}
    	if(partyGroup.getPartyId()==null){
    		//新增
    		Party party = new Party();
        	party.setCreatedByUser(getCurrentUser().getId());
        	party.setCreatedTime(new Date());
        	party.setDescription(partyGroup.getGroupName());
        	party.setPartyTypeId("party_group");
        	party.setStatusId(0l);//状态正常
        	party = partyGroupManager.saveParty(party);
        	partyGroup.setPartyId(party.getPartyId());
        	PartyRole partyRole = new PartyRole();
        	partyRole.setCreatedByUser(getCurrentUser().getId());
        	partyRole.setCreatedTime(new Date());
        	partyRole.setRoleTypeId(1l);
        	partyRole.setPartyId(party.getPartyId());
        	partyRole = partyGroupManager.savePartyRole(partyRole);
        	//有父id的父id来出来保存relationship
        	if(parentId!=null && !"".equals(parentId)){
        		PartyRelationship partyRelationship = new PartyRelationship();
        		partyRelationship.setCreatedByUser(getCurrentUser().getId());
        		partyRelationship.setCreatedTime(new Date());
        		partyRelationship.setFromDate(new Date());
        		partyRelationship.setPartyIdFrom(Long.valueOf(parentId));
        		partyRelationship.setPartyIdTo(party.getPartyId());
        		partyRelationship.setPartyRelationshipTypeId(1l);
        		partyRelationship.setRoleTypeIdFrom(1l);
        		partyRelationship.setRoleTypeIdTo(1l);
        		partyRelationship.setStatusId(0l);
        		partyRelationshipManager.save(partyRelationship);
        	}
    	}
    	partyGroup = partyGroupManager.save(partyGroup);
    	villageInfo.setPartyId(partyGroup.getPartyId());
    	villageInfo = partyGroupManager.saveVillageInfo(villageInfo);
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
    //村详情系想你
    public String cunInfoDtl(){
    	getRequest().setAttribute("belongGroupId", partyId);
    	//村基本信息
    	if(partyId!=null && !"".equals(partyId)){
    		Map<String,String> conditon = new HashMap<String,String>();
    		conditon.put("partyId", partyId);
    		List cunList = partyGroupManager.searchCun(conditon);
    		if(cunList!=null && cunList.size()>0){
    			Object[] obs = (Object[])cunList.get(0);
    			partyGroup = (PartyGroup)obs[0];
    			villageInfo = (VillageInfo)obs[1];
    		}
    	}
    	//村支书、村委主任、第一书记
    	List mPersonList = partyGroupManager.getMPersons(partyId);
    	if(mPersonList!=null && mPersonList.size()>0){
    		for(int i=0; i<mPersonList.size(); i++){
    			Object[] obs = (Object[])mPersonList.get(i);
    			Person person = (Person)obs[0];
    			PartyRole partyRole = (PartyRole)obs[1];
    			if(partyRole.getRoleTypeId() == 3L){
    				getRequest().setAttribute("person3", person);
    			}
    			if(partyRole.getRoleTypeId() == 4L){
    				getRequest().setAttribute("person4", person);
    			}
    			if(partyRole.getRoleTypeId() == 5L){
    				getRequest().setAttribute("person5", person);
    				getRequest().setAttribute("partyRole5", partyRole);
    			}
    		}
    	}
    	//人员信息列表
    	return SUCCESS;
    }
    public String zhibuInfoDtl(){
    	getRequest().setAttribute("belongGroupId", partyId);
    	String isNowDangwei = getRequest().getParameter("isNowDangwei");
    	getRequest().setAttribute("isNowDangwei", isNowDangwei);
    	return SUCCESS;
    }
    public String editPartyGroupDangwei(){
    	if(partyId!=null && !"".equals(partyId)){
    		List partyGroupList = partyGroupManager.getPartyGroupByPartyId(partyId);
    		if(partyGroupList!=null && partyGroupList.size()>0){
    			partyGroup = (PartyGroup)partyGroupList.get(0);
    		}
    		//根据partyId获取器归属行政机构
    		List localOfDw = partyGroupManager.getLocalOfDw(partyId);
    		if(localOfDw!=null && localOfDw.size()>0){
    			PartyGroup localOfDwD = (PartyGroup)localOfDw.get(0);
    			belongXingZhengPartyId = localOfDwD.getPartyId().toString();
    		}
    	}
    	//查询行政机构
    	List partyGroupList = null;
    	if(parentId!=null && !"".equals(parentId)){
    		partyGroupList = partyGroupManager.getPgByDwId(parentId);
    	}else{
    		partyGroupList = partyGroupManager.getXZGroupList();
    	}
    	getRequest().setAttribute("xzpgList", partyGroupList);
    	return SUCCESS;
    }
    public String savePartyGroupDangwei(){
    	//要保存party
    	//保存partyGroup
    	//保存party_role
    	//保存party_relationship：1.党支部上下级关系；2.党支部与行政机构归属关系
    	if(delete!=null && "1".equals(delete)){
    		//删除操作
    		Party party = new Party();
    		party.setPartyId(partyGroup.getPartyId());
    		party.setStatusId(-1L);
    		party = partyGroupManager.saveParty(party);
    		return SUCCESS;
    	}
    	if(partyGroup.getPartyId()==null){
    		//新增
    		Party party = new Party();
        	party.setCreatedByUser(getCurrentUser().getId());
        	party.setCreatedTime(new Date());
        	party.setDescription(partyGroup.getGroupName());
        	party.setPartyTypeId("party_group");
        	party.setStatusId(0l);//状态正常
        	party = partyGroupManager.saveParty(party);
        	partyGroup.setPartyId(party.getPartyId());
        	PartyRole partyRole = new PartyRole();
        	partyRole.setCreatedByUser(getCurrentUser().getId());
        	partyRole.setCreatedTime(new Date());
        	partyRole.setRoleTypeId(2l);//角色为党委或支部
        	partyRole.setPartyId(party.getPartyId());
        	partyRole = partyGroupManager.savePartyRole(partyRole);
        	//有父id的父id来出来保存relationship
        	if(parentId!=null && !"".equals(parentId)){
        		PartyRelationship partyRelationship = new PartyRelationship();
        		partyRelationship.setCreatedByUser(getCurrentUser().getId());
        		partyRelationship.setCreatedTime(new Date());
        		partyRelationship.setFromDate(new Date());
        		partyRelationship.setPartyIdFrom(Long.valueOf(parentId));
        		partyRelationship.setPartyIdTo(party.getPartyId());
        		partyRelationship.setPartyRelationshipTypeId(4l);
        		partyRelationship.setRoleTypeIdFrom(2l);
        		partyRelationship.setRoleTypeIdTo(2l);
        		partyRelationship.setStatusId(0l);
        		partyRelationshipManager.save(partyRelationship);
        		//保存党委支部与行政机构的关系
        		if(belongXingZhengPartyId!=null && !"".equals(belongXingZhengPartyId)){
        			PartyRelationship partyRelationship2 = new PartyRelationship();
        			partyRelationship2.setCreatedByUser(getCurrentUser().getId());
        			partyRelationship2.setCreatedTime(new Date());
        			partyRelationship2.setFromDate(new Date());
        			partyRelationship2.setPartyIdFrom(Long.valueOf(belongXingZhengPartyId));
        			partyRelationship2.setPartyIdTo(party.getPartyId());
        			partyRelationship2.setPartyRelationshipTypeId(3l);
        			partyRelationship2.setRoleTypeIdFrom(1l);
        			partyRelationship2.setRoleTypeIdTo(2l);
        			partyRelationship2.setStatusId(0l);
            		partyRelationshipManager.save(partyRelationship2);
        		}
        	}
    	}
    	partyGroup = partyGroupManager.save(partyGroup);
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String editPartyGroupUnit(){
    	if (pgId != null) {
            partyGroup = partyGroupManager.get(pgId);
        } else if(partyId !=null && !"".equals(partyId)){
        	List pglist = partyGroupManager.getPartyGroupByPartyId(partyId);
        	if(pglist!=null && pglist.size()>0){
        		partyGroup = (PartyGroup)pglist.get(0);
        	}
        } else{
            partyGroup = new PartyGroup();
        }

        return SUCCESS;
    }
    public String savePartyGroupUnit(){

    	//要保存party
    	//保存partyGroup
    	//保存party_role
    	//保存party_relationship：1.党支部上下级关系；2.党支部与行政机构归属关系
    	if(delete!=null && "1".equals(delete)){
    		//删除操作
    		Party party = new Party();
    		party.setPartyId(partyGroup.getPartyId());
    		party.setStatusId(-1L);
    		party = partyGroupManager.saveParty(party);
    		return SUCCESS;
    	}
    	if(partyGroup.getPartyId()==null){
    		//新增
    		Party party = new Party();
        	party.setCreatedByUser(getCurrentUser().getId());
        	party.setCreatedTime(new Date());
        	party.setDescription(partyGroup.getGroupName());
        	party.setPartyTypeId("party_group");
        	party.setStatusId(0l);//状态正常
        	party = partyGroupManager.saveParty(party);
        	partyGroup.setPartyId(party.getPartyId());
        	PartyRole partyRole = new PartyRole();
        	partyRole.setCreatedByUser(getCurrentUser().getId());
        	partyRole.setCreatedTime(new Date());
        	partyRole.setRoleTypeId(6l);//角色为行政单位
        	partyRole.setPartyId(party.getPartyId());
        	partyRole = partyGroupManager.savePartyRole(partyRole);
        	//有父id的父id来出来保存relationship
        	if(parentId!=null && !"".equals(parentId)){
        		PartyRelationship partyRelationship = new PartyRelationship();
        		partyRelationship.setCreatedByUser(getCurrentUser().getId());
        		partyRelationship.setCreatedTime(new Date());
        		partyRelationship.setFromDate(new Date());
        		partyRelationship.setPartyIdFrom(Long.valueOf(parentId));
        		partyRelationship.setPartyIdTo(party.getPartyId());
        		if("1".equals(parentId)){
        			//县级则关系为5：行政单位和行政区划归属关系
        			partyRelationship.setPartyRelationshipTypeId(5l);
            		partyRelationship.setRoleTypeIdFrom(1l);
            		partyRelationship.setRoleTypeIdTo(6l);
        		}else{
        			//否则为6：行政单位上下级关系
        			partyRelationship.setPartyRelationshipTypeId(6l);
            		partyRelationship.setRoleTypeIdFrom(6l);
            		partyRelationship.setRoleTypeIdTo(6l);
        		}
        		
        		partyRelationship.setStatusId(0l);
        		partyRelationshipManager.save(partyRelationship);
        	}
        	partyGroup.setCreatedByUser(getCurrentUser().getId());
        	partyGroup.setCreatedTime(new Date());
    	}else{
    		partyGroup.setLastUpdatedByUser(getCurrentUser().getId());
        	partyGroup.setLastUpdatedTime(new Date());
    	}
    	partyGroup = partyGroupManager.save(partyGroup);
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String unitInfoDtl(){
    	return SUCCESS;
    }
    public String unitTree(){
    	String parentId = getRequest().getParameter("parentGroupId");
    	Map<String,String> conditon = new HashMap<String,String>();
    	//条件查询不考虑树形结构
    	if(query!=null && !"".equals(query)){
    		conditon.put("roleTypeId", "1");
    		conditon.put("groupName", query);
    		partyGroups = partyGroupManager.searchByCondition(conditon);
    		getRequest().setAttribute("showForm", "showData");
    		return SUCCESS;
    	}
    	conditon.put("searchType", "partyGroupTree");//查询树形结构
    	if(parentId!=null && !"".equals(parentId)){
    		//如果是根，则展现根的下一层
    		if("1".equals(parentId)){
    			getRequest().setAttribute("isRoot", "isRoot");
    		}
    		conditon.put("parentId", parentId);
    		conditon.put("partyRelationshipTypeId", "1");
    	}
    	partyGroups = partyGroupManager.searchByCondition(conditon);
    	
    	getRequest().setAttribute("showForm", "showData");
    	return SUCCESS;
    }
    public String tzdtl(){
    	getRequest().setAttribute("belongGroupId", partyId);
    	getRequest().setAttribute("partyId", partyId);
    	//村支书、村委主任、第一书记
    	List mPersonList = partyGroupManager.getMPersons(partyId);
    	if(mPersonList!=null && mPersonList.size()>0){
    		for(int i=0; i<mPersonList.size(); i++){
    			Object[] obs = (Object[])mPersonList.get(i);
    			Person person = (Person)obs[0];
    			PartyRole partyRole = (PartyRole)obs[1];
    			if(partyRole.getRoleTypeId() == 3L){
    				getRequest().setAttribute("person3", person);
    			}
    			if(partyRole.getRoleTypeId() == 4L){
    				getRequest().setAttribute("person4", person);
    			}
    			if(partyRole.getRoleTypeId() == 5L){
    				getRequest().setAttribute("person5", person);
    				getRequest().setAttribute("partyRole5", partyRole);
    			}
    		}
    	}
    	//台帐信息
    	String tzDate = getRequest().getParameter("tzDate");
    	getRequest().setAttribute("tzDate", MyDateUtil.getCurrDate("yyyy-MM"));
    	Map condition = new HashMap();
    	condition.put("tzDate", tzDate);
    	condition.put("groupPartyId", partyId);
    	List tzDhbzs = tzDhbzManager.searchByCondition(condition);
    	List tzDyzths = tzDyzthManager.searchByCondition(condition);
    	List tzFwqzs = tzFwqzManager.searchByCondition(condition);
    	List tzGfmzs = tzGfmzManager.searchByCondition(condition);
    	List tzHjmds = tzHjmdManager.searchByCondition(condition);
    	List tzZtjjs = tzZtjjManager.searchByCondition(condition);
    	if(tzDhbzs!=null && tzDhbzs.size()>0){
    		TzDhbz tzDhbz = (TzDhbz)tzDhbzs.get(0);
    		getRequest().setAttribute("tzDhbz", tzDhbz);
    	}
    	if(tzDyzths!=null && tzDyzths.size()>0){
    		TzDyzth tzDyzth = (TzDyzth)tzDyzths.get(0);
    		getRequest().setAttribute("tzDyzth", tzDyzth);
    	}
    	if(tzFwqzs!=null && tzFwqzs.size()>0){
    		TzFwqz tzFwqz = (TzFwqz)tzFwqzs.get(0);
    		getRequest().setAttribute("tzFwqz", tzFwqz);
    	}
    	if(tzGfmzs!=null && tzGfmzs.size()>0){
    		TzGfmz tzGfmz = (TzGfmz)tzGfmzs.get(0);
    		getRequest().setAttribute("tzGfmz", tzGfmz);
    	}
    	if(tzHjmds!=null && tzHjmds.size()>0){
    		TzHjmd tzHjmd = (TzHjmd)tzHjmds.get(0);
    		getRequest().setAttribute("tzHjmd", tzHjmd);
    	}
    	if(tzZtjjs!=null && tzZtjjs.size()>0){
    		TzZtjj tzZtjj = (TzZtjj)tzZtjjs.get(0);
    		getRequest().setAttribute("tzZtjj", tzZtjj);
    	}
    	return SUCCESS;
    }
    public String cpChargeDtl(){
    	PartyGroup nowZhibu = getNowZhibu();
        if(nowZhibu!=null){
        	List chargeSumList = cpChargeManager.getChargeSumList(nowZhibu.getPartyId());
        	getRequest().setAttribute("chargeSumList", chargeSumList);
        }
    	return SUCCESS;
    }
    public String zhibuuser(){
    	String partyId = getRequest().getParameter("partyId");
    	getRequest().setAttribute("belongGroupId", partyId);
    	return SUCCESS;
    }
}