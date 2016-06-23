package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.PetitionFlowManager;
import com.joker.wms.service.PetitionManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.Petition;
import com.joker.wms.model.PetitionFlow;
import com.joker.wms.webapp.action.BaseAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PetitionAction extends BaseAction implements Preparable {
    private PetitionManager petitionManager;
    private List petitions;
    private Petition petition;
    private Long petitionId;
    private String query;
    private PetitionFlowManager petitionFlowManager;

    public void setPetitionFlowManager(PetitionFlowManager petitionFlowManager) {
		this.petitionFlowManager = petitionFlowManager;
	}

	public void setPetitionManager(PetitionManager petitionManager) {
        this.petitionManager = petitionManager;
    }

    public List getPetitions() {
        return petitions;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String petitionId = getRequest().getParameter("petition.petitionId");
            if (petitionId != null && !petitionId.equals("")) {
                petition = petitionManager.get(new Long(petitionId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
    	//type a信访受理 b领导意见 c信访处理 d信访结案 e信访查询
    	String type = getRequest().getParameter("type");
    	getRequest().setAttribute("type", type);
    	PartyGroup nowZhiBu = super.getNowZhibu();
        try {
        	Map condition = new HashMap();
        	condition.put("nowZhibuId", nowZhiBu.getPartyId());
        	condition.put("type", type);
        	List searchResult = new ArrayList();
        	searchResult = petitionManager.searchByCondition(condition, getPage());
        	Map groupMap = new HashMap();
        	if(searchResult!=null && searchResult.size()>0){
        		if(petitions==null){
        			petitions = new ArrayList();
        		}
        		for(int i=0; i<searchResult.size(); i++){
        			Object[] obs = (Object[])searchResult.get(i);
        			Petition petition = (Petition)obs[0];
        			PartyGroup partyGroup = (PartyGroup)obs[1];
        			petitions.add(petition);
        			groupMap.put(petition.getProcessPartyId(), partyGroup);
        		}
        	}
        	getRequest().setAttribute("groupMap", groupMap);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            petitions = petitionManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        getRequest().setAttribute("statusMap", super.getStatusMap(2l, "Long"));
        getRequest().setAttribute("problemTypeMap", super.getEnumerationMap(14l, null));
        getRequest().setAttribute("methodMap", super.getEnumerationMap(15l,""));
        return SUCCESS;
    }

    public void setPetitionId(Long petitionId) {
        this.petitionId = petitionId;
    }

    public Petition getPetition() {
        return petition;
    }

    public void setPetition(Petition petition) {
        this.petition = petition;
    }

    public String delete() {
        petitionManager.remove(petition.getPetitionId());
        saveMessage(getText("petition.deleted"));

        return SUCCESS;
    }

    public String edit() {
        String type = getRequest().getParameter("type");
        //type a信访受理 b领导意见 c信访处理 d信访结案 e信访查询
    	if (petitionId != null) {
            petition = petitionManager.get(petitionId);
        } else {
            petition = new Petition();
        }
        String reportMethodOptions = super.getEnumerationSelector(15l, (petition.getReportMethod()==null||"".equals(petition.getReportMethod())?null:Long.valueOf(petition.getReportMethod())));
        String reportTypeOptions = super.getEnumerationSelector(14l, (petition.getReportType()==null||"".equals(petition.getReportType())?null:Long.valueOf(petition.getReportType())));
        getRequest().setAttribute("reportMethodOptions", reportMethodOptions);
        getRequest().setAttribute("reportTypeOptions", reportTypeOptions);
        List zhibuList = partyGroupManager.getZhiBuByCondition(null);
        String zhibuOptions = "";
        if(zhibuList!=null && zhibuList.size()>0){
        	for(int i=0;i<zhibuList.size();i++){
        		PartyGroup zhibu = (PartyGroup)zhibuList.get(i);
        		if(petition.getProcessPartyId()!=null && petition.getProcessPartyId()==zhibu.getPartyId()){
        			zhibuOptions += "<option value='"+ zhibu.getPartyId() +"' selected='selected'>" + zhibu.getGroupName() + "</option>";
        		}else{
        			zhibuOptions += "<option value='"+ zhibu.getPartyId() +"'>" + zhibu.getGroupName() + "</option>";
        		}
        	}
        }
        getRequest().setAttribute("zhibuOptions", zhibuOptions);
        PetitionFlow petitionFlow = petitionFlowManager.getNowPetitionFlow(petition.getPetitionId());
        PartyGroup nowpg = super.getNowZhibu();
        if(!"a".equals(type) && !petitionFlow.getPartyId().equals(nowpg.getPartyId())){
        	super.setJsonResult("该案件当前不在您的部门，已转交其他部门处理，所以您不能进行操作，如果需要跟进进度，请联系负责部门。");
            return "jsonResult";
        }
        if("a".equals(type)){
        	return SUCCESS;
        }else if("b".equals(type)){
        	//输入领导一间的页面
        	return "approval";
        }else if("c".equals(type)){
        	//输入处理结果意见的页面
        	List petitionFlowList = petitionFlowManager.getAllPetitionFlow(petition.getPetitionId());
        	getRequest().setAttribute("petitionFlowList", petitionFlowList);
        	return "resolve";
        }else if("d".equals(type)){
        	//处理结案操作
        	List petitionFlowList = petitionFlowManager.getAllPetitionFlow(petition.getPetitionId());
        	getRequest().setAttribute("petitionFlowList", petitionFlowList);
        	return "finish";
        }else if("e".equals(type)){
        	//nothing
        	return "jsonResult";
        }else{
        	return SUCCESS;
        }
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            petitionManager.remove(petition.getPetitionId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (petition.getPetitionId() == null);

        if(isNew){
        	petition.setCreatedByUser(super.getCurrentUser().getId());
        	petition.setCreatedTime(new Date());
        	petition.setStatusId(3l);
        }else{
        	petition.setLastUpdatedByUser(super.getCurrentUser().getId());
        	petition.setLastUpdatedTime(new Date());
        }
        petition = petitionManager.save(petition);
        //新增流程信息，受理过程部分
        if(isNew){
        	PetitionFlow petitionFlow = new PetitionFlow();
        	petitionFlow.setCreatedByUser(super.getCurrentUser().getId());
        	petitionFlow.setCreatedTime(new Date());
        	petitionFlow.setMemo("接收受理");
        	PartyGroup nowZhiBu = super.getNowZhibu();
        	petitionFlow.setPartyId(nowZhiBu.getPartyId());//这里是流程操作后下一个流程归属的部门ID
        	petitionFlow.setPetitionId(petition.getPetitionId());
        	petitionFlow.setSvcId(3l);//信访受理
        	petitionFlowManager.save(petitionFlow);
        }
        String key = (isNew) ? "petition.added" : "petition.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String saveApprovalPetition(){
    	Petition getPetition = petitionManager.get(petition.getPetitionId());
    	getPetition.setLeaderContent(petition.getLeaderContent());
    	getPetition.setStatusId(4l);
    	getPetition.setLastUpdatedByUser(super.getCurrentUser().getId());
    	getPetition.setLastUpdatedTime(new Date());
    	petitionManager.save(getPetition);
    	PetitionFlow petitionFlow = new PetitionFlow();
    	petitionFlow.setCreatedByUser(super.getCurrentUser().getId());
    	petitionFlow.setCreatedTime(new Date());
    	petitionFlow.setMemo(petition.getLeaderContent());
    	PartyGroup nowZhiBu = super.getNowZhibu();
    	petitionFlow.setPartyId(getPetition.getProcessPartyId());//这里是流程操作后下一个流程归属的部门ID
    	petitionFlow.setPetitionId(petition.getPetitionId());
    	petitionFlow.setSvcId(4l);//信访审核
    	petitionFlowManager.save(petitionFlow);
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String saveFinishPetition(){
    	Petition getPetition = petitionManager.get(petition.getPetitionId());
    	getPetition.setStatusId(6l);
    	getPetition.setLastUpdatedByUser(super.getCurrentUser().getId());
    	getPetition.setLastUpdatedTime(new Date());
    	petitionManager.save(getPetition);
    	PetitionFlow petitionFlow = new PetitionFlow();
    	petitionFlow.setCreatedByUser(super.getCurrentUser().getId());
    	petitionFlow.setCreatedTime(new Date());
    	petitionFlow.setMemo("结案");
    	PartyGroup nowZhiBu = super.getNowZhibu();
    	petitionFlow.setPartyId(nowZhiBu.getPartyId());//这里是流程操作后下一个流程归属的部门ID
    	petitionFlow.setPetitionId(petition.getPetitionId());
    	petitionFlow.setSvcId(6l);//信访结案
    	petitionFlowManager.save(petitionFlow);
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String saveResolvePetition(){
    	Petition getPetition = petitionManager.get(petition.getPetitionId());
    	getPetition.setStatusId(5l);
    	getPetition.setLastUpdatedByUser(super.getCurrentUser().getId());
    	getPetition.setLastUpdatedTime(new Date());
    	petitionManager.save(getPetition);
    	PetitionFlow petitionFlow = new PetitionFlow();
    	petitionFlow.setCreatedByUser(super.getCurrentUser().getId());
    	petitionFlow.setCreatedTime(new Date());
    	petitionFlow.setMemo(getRequest().getParameter("resolveresult"));
    	PartyGroup nowZhiBu = super.getNowZhibu();
    	petitionFlow.setPartyId(nowZhiBu.getPartyId());//这里是流程操作后下一个流程归属的部门ID
    	petitionFlow.setPetitionId(petition.getPetitionId());
    	petitionFlow.setSvcId(5l);//信访结案
    	petitionFlowManager.save(petitionFlow);
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
}