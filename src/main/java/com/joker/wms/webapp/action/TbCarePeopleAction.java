package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.EnumerationManager;
import com.joker.wms.service.PartyGroupManager;
import com.joker.wms.service.TbCarePeopleManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.TbCarePeople;
import com.joker.wms.model.TbPeopleCare;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TbCarePeopleAction extends BaseAction implements Preparable {
    private TbCarePeopleManager tbCarePeopleManager;
    private List tbCarePeoples;
    private TbCarePeople tbCarePeople;
    private Long peopleId;
    private String query;
    private PartyGroupManager partyGroupManager;
    private EnumerationManager enumerationManager;
    private String selectedPeopleId;

    public String getSelectedPeopleId() {
		return selectedPeopleId;
	}

	public void setSelectedPeopleId(String selectedPeopleId) {
		this.selectedPeopleId = selectedPeopleId;
	}

	public void setEnumerationManager(EnumerationManager enumerationManager) {
		this.enumerationManager = enumerationManager;
	}

	public void setPartyGroupManager(PartyGroupManager partyGroupManager) {
		this.partyGroupManager = partyGroupManager;
	}

	public void setTbCarePeopleManager(TbCarePeopleManager tbCarePeopleManager) {
        this.tbCarePeopleManager = tbCarePeopleManager;
    }

    public List getTbCarePeoples() {
        return tbCarePeoples;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tbCarePeopleId = getRequest().getParameter("tbCarePeople.peopleId");
            if (tbCarePeopleId != null && !tbCarePeopleId.equals("")) {
                tbCarePeople = tbCarePeopleManager.get(new Long(tbCarePeopleId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            tbCarePeoples = tbCarePeopleManager.search(condition, TbCarePeople.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tbCarePeoples = tbCarePeopleManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public TbCarePeople getTbCarePeople() {
        return tbCarePeople;
    }

    public void setTbCarePeople(TbCarePeople tbCarePeople) {
        this.tbCarePeople = tbCarePeople;
    }

    public String delete() {
        tbCarePeopleManager.remove(tbCarePeople.getPeopleId());
        saveMessage(getText("tbCarePeople.deleted"));

        return SUCCESS;
    }

    public String edit() {
    	Map<String,String> conditon = new HashMap<String,String>();
    	conditon.put("searchType", "partyGroupTree");//查询树形结构
    	conditon.put("parentId", "1");
		conditon.put("partyRelationshipTypeId", "1");
		
    	List pgList = partyGroupManager.searchByCondition(conditon);
        if (peopleId != null) {
            tbCarePeople = tbCarePeopleManager.get(peopleId);
        } else {
            tbCarePeople = new TbCarePeople();
        }
        getRequest().setAttribute("pgList", pgList);
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            tbCarePeopleManager.remove(tbCarePeople.getPeopleId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (tbCarePeople.getPeopleId() == null);

        tbCarePeople = tbCarePeopleManager.save(tbCarePeople);

        String key = (isNew) ? "tbCarePeople.added" : "tbCarePeople.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    /**
     * 设置前端的 民政优抚select类型
     */
    public void setYFTypes(){
    	List yftypes = enumerationManager.getYFTypes();
    	super.getRequest().setAttribute("yftypes", yftypes);
    }
    public String mzyfset(){
    	//setYFTypes();
    	return SUCCESS;
    }
    public String addPeopleYFType(){
    	setYFTypes();
    	String selectedPeopleName = getRequest().getParameter("selectedPeopleName");
    	getRequest().setAttribute("selectedPeopleName", selectedPeopleName);
    	return SUCCESS;
    }
    public String peopleYFTypes(){
    	//查找给定的人员的优抚类型
    	if(selectedPeopleId!=null && !"".equals(selectedPeopleId)){
    		List peopleYFTypeList = tbCarePeopleManager.getYFTypeByPeopleId(selectedPeopleId);
    		getRequest().setAttribute("peopleYFTypeList", peopleYFTypeList);
    	}
    	return SUCCESS;
    }
    public String savePeopleYFType(){
    	String careId = getRequest().getParameter("careId");
    	if(delete!=null && careId!=null && !"".equals(careId)){
    		//执行删除操作
    		TbPeopleCare tbPeopleCare = new TbPeopleCare();
    		tbPeopleCare.setCareId(Long.valueOf(careId));
    		tbCarePeopleManager.deleteObject(tbPeopleCare);
    	}
    	//保存成操作
    	String yfTypeId = getRequest().getParameter("yfTypeId");
    	if(selectedPeopleId!=null && !"".equals(selectedPeopleId) && yfTypeId!=null && !"".equals(yfTypeId)){
    		TbPeopleCare tbPeopleCare = new TbPeopleCare();
    		tbPeopleCare.setEnumId(Long.valueOf(yfTypeId));
    		tbPeopleCare.setPeopleId(Long.valueOf(selectedPeopleId));
    		tbPeopleCare.setCreatedTime(new Date());
    		tbPeopleCare.setCreatedByUser(getCurrentUser().getId());
    		try{
    			tbCarePeopleManager.saveObject(tbPeopleCare);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
}