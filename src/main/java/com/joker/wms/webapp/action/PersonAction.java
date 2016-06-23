package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.PartyGroupManager;
import com.joker.wms.service.PartyRelationshipManager;
import com.joker.wms.service.PersonManager;
import com.joker.wms.util.PinYinUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.CpDtl;
import com.joker.wms.model.CpPositive;
import com.joker.wms.model.Party;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.PartyRelationship;
import com.joker.wms.model.PartyRole;
import com.joker.wms.model.Person;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonAction extends BaseAction implements Preparable {
    private PersonManager personManager;
    private List persons;
    private Person person;
    private Long personId;
    private String query;
    private String belongGroupId;
    private PartyGroupManager partyGroupManager;
    private PartyRelationshipManager partyRelationshipManager;
    private String statusAndUnit;
    private String roleType;
    private CpDtl cpDtl;
    private CpPositive cpPositive;

    public CpPositive getCpPositive() {
		return cpPositive;
	}

	public void setCpPositive(CpPositive cpPositive) {
		this.cpPositive = cpPositive;
	}

	public CpDtl getCpDtl() {
		return cpDtl;
	}

	public void setCpDtl(CpDtl cpDtl) {
		this.cpDtl = cpDtl;
	}

	public String getStatusAndUnit() {
		return statusAndUnit;
	}

	public void setStatusAndUnit(String statusAndUnit) {
		this.statusAndUnit = statusAndUnit;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public void setPartyRelationshipManager(
			PartyRelationshipManager partyRelationshipManager) {
		this.partyRelationshipManager = partyRelationshipManager;
	}
    
    public void setPartyGroupManager(PartyGroupManager partyGroupManager) {
        this.partyGroupManager = partyGroupManager;
    }

    public String getBelongGroupId() {
		return belongGroupId;
	}

	public void setBelongGroupId(String belongGroupId) {
		this.belongGroupId = belongGroupId;
	}

	public void setPersonManager(PersonManager personManager) {
        this.personManager = personManager;
    }

    public List getPersons() {
        return persons;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String personId = getRequest().getParameter("person.personId");
            if (personId != null && !personId.equals("")) {
                person = personManager.get(new Long(personId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	String dang = getRequest().getParameter("dang");
        	if(belongGroupId!=null && !"".equals(belongGroupId)){
        		
        		String bypgid = getRequest().getParameter("bypgid");
        		if(bypgid!=null && "yes".equals(bypgid)){
        			//说明传到后台来的参数：belongGroupId，其实是party_group_id，要把它转化成party_id再进行正常搜索
        			PartyGroup belongPartyGroup = partyGroupManager.get(Long.valueOf(belongGroupId));
            		belongGroupId = belongPartyGroup.getPartyId().toString();
        		}
        		if(dang!=null && "dang".equals(dang)){
        			String isNowDangwei = getRequest().getParameter("isNowDangwei");
        			persons = personManager.getDangPerson(belongGroupId, isNowDangwei);
        		}else{
        			persons = personManager.searchByGroupId(Person.class, getPage(), belongGroupId);
        		}
        	}else{
        		if(dang!=null && "dang".equals(dang)){
        			String isNowDangwei = "";
        			persons = personManager.getDangPerson(belongGroupId, isNowDangwei);
        		}else{
        			persons = personManager.search(query, Person.class, getPage());
        		}
        	}
        } catch (SearchException se) {
            addActionError(se.getMessage());
            persons = personManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }
    public String dangpersons(){
        try {
        	String dang = getRequest().getParameter("dang");
        	//受否添加
        	if(belongGroupId!=null && !"".equals(belongGroupId)){
        		if(dang!=null && "dang".equals(dang)){
        			String isNowDangwei = getRequest().getParameter("isNowDangwei");
        			persons = personManager.getDangPerson(belongGroupId, isNowDangwei);
        		}else{
        			persons = personManager.searchByGroupId(Person.class, getPage(), belongGroupId);
        		}
        	}else{
        		if(dang!=null && "dang".equals(dang)){
        			String isNowDangwei = "";
        			persons = personManager.getDangPerson(belongGroupId, isNowDangwei);
        		}else{
        			persons = personManager.search(query, Person.class, getPage());
        		}
        		
        	}
        } catch (SearchException se) {
            addActionError(se.getMessage());
            persons = personManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }
    public String positivepersons(){
    	try {
        	String dang = getRequest().getParameter("dang");
        	if(belongGroupId!=null && !"".equals(belongGroupId)){
        		if(dang!=null && "dang".equals(dang)){
        			String isNowDangwei = getRequest().getParameter("isNowDangwei");
        			persons = personManager.getPositivePerson(belongGroupId, isNowDangwei);
        		}else{
        			persons = personManager.searchByGroupId(Person.class, getPage(), belongGroupId);
        		}
        	}
        } catch (SearchException se) {
            addActionError(se.getMessage());
            persons = personManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        if(persons!=null && persons.size()>0){
        	Map cpDtlMap = new HashMap();
        	for(int i=0; i<persons.size(); i++){
        		Person onePerson = (Person)persons.get(i);
        		CpDtl oneCpDtl = personManager.getCpDtlByPartyId(onePerson.getPartyId());
        		cpDtlMap.put(onePerson.getPartyId(), oneCpDtl);
        	}
        	getRequest().setAttribute("cpDtlMap", cpDtlMap);
        }
        return SUCCESS;
    }
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String delete() {
        personManager.remove(person.getPersonId());
        saveMessage(getText("person.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (personId != null) {
            person = personManager.get(personId);
        } else {
            person = new Person();
        }
        String merriageSelector = super.getEnumerationSelector(11l, (person.getMarriage()==null||person.getMarriage().equals(""))?null:Long.valueOf(person.getMarriage()));
    	String nationSelector = super.getEnumerationSelector(10l, (person.getNation()==null||person.getNation().equals(""))?null:Long.valueOf(person.getNation()));
    	String educationSelector = super.getEnumerationSelector(12l, (person.getEducation()==null||person.getEducation().equals(""))?null:Long.valueOf(person.getEducation()));
    	getRequest().setAttribute("merriageSelector", merriageSelector);
    	getRequest().setAttribute("nationSelector", nationSelector);
    	getRequest().setAttribute("educationSelector", educationSelector);
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            personManager.remove(person.getPersonId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (person.getPersonId() == null);
        
        if(isNew){
        	//先保存party然后再保存partygroup
        	Party party = new Party();
        	party.setCreatedByUser(getCurrentUser().getId());
        	party.setCreatedTime(new Date());
        	party.setDescription(person.getName());
        	party.setPartyTypeId("person");
        	party.setStatusId(0l);//状态正常
        	party = partyGroupManager.saveParty(party);
        	person.setPartyId(party.getPartyId());
        	
        	//保存完partygroup之后紧接着保存partygroup的relationship//新增肯定是按照关系来新增的不是独立新增的
        	PartyRole partyRole = new PartyRole();
        	partyRole.setCreatedByUser(getCurrentUser().getId());
        	partyRole.setCreatedTime(new Date());
        	partyRole.setRoleTypeId(1l);
        	partyRole.setPartyId(party.getPartyId());
        	partyRole = partyGroupManager.savePartyRole(partyRole);
        	//有父id的父id来出来保存relationship
        	if(belongGroupId!=null && !"".equals(belongGroupId)){
        		PartyRelationship partyRelationship = new PartyRelationship();
        		partyRelationship.setCreatedByUser(getCurrentUser().getId());
        		partyRelationship.setCreatedTime(new Date());
        		partyRelationship.setFromDate(new Date());
        		PartyGroup belongPartyGroup = partyGroupManager.get(Long.valueOf(belongGroupId));
        		partyRelationship.setPartyIdFrom(belongPartyGroup.getPartyId());
        		partyRelationship.setPartyIdTo(party.getPartyId());
        		partyRelationship.setPartyRelationshipTypeId(1l);
        		partyRelationship.setRoleTypeIdFrom(1l);
        		partyRelationship.setRoleTypeIdTo(1l);
        		partyRelationship.setStatusId(0l);
        		partyRelationshipManager.save(partyRelationship);
        	}
        }else{
        	person.setLastUpdatedByUser(getCurrentUser().getId());
        	person.setLastUpdatedTime(new Date());
        }
        if(getRequest().getParameter("person.pinyinName")==null || "".equals(getRequest().getParameter("person.pinyinName"))){
        	person.setPinyinName(PinYinUtil.getPinYinHeadChar(person.getName()));
        }
        personManager.save(person);

        String key = (isNew) ? "person.added" : "person.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String editCunPerson(){
    	//新增或修改村下面的人员
    	if (personId != null) {
            person = personManager.get(personId);
        } else {
            person = new Person();
        }
    	String isNowXiang = getRequest().getParameter("isNowXiang");
    	
    	if(isNowXiang!=null && "".equals(isNowXiang)){
    		//当前操作的是村，所以要加上这个查询person的role，3，4，5：村支书，村委主任，第一书记
    		if(person.getPartyId()!=null){
    			List roles = personManager.getPersonRoles(person.getPartyId());
    			//设置一下哈
    		}
    	}
    	String merriageSelector = super.getEnumerationSelector(11l, (person.getMarriage()==null||person.getMarriage().equals(""))?null:Long.valueOf(person.getMarriage()));
    	String nationSelector = super.getEnumerationSelector(10l, (person.getNation()==null||person.getNation().equals(""))?null:Long.valueOf(person.getNation()));
    	String educationSelector = super.getEnumerationSelector(12l, (person.getEducation()==null||person.getEducation().equals(""))?null:Long.valueOf(person.getEducation()));
    	getRequest().setAttribute("merriageSelector", merriageSelector);
    	getRequest().setAttribute("nationSelector", nationSelector);
    	getRequest().setAttribute("educationSelector", educationSelector);
    	getRequest().setAttribute("isNowXiang", isNowXiang);
    	return SUCCESS;
    }
    public String saveCunPerson(){
        if (delete != null) {
            personManager.remove(person.getPersonId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (person.getPersonId() == null);
        
        if(isNew){
        	//先保存party然后再保存partygroup
        	Party party = new Party();
        	party.setCreatedByUser(getCurrentUser().getId());
        	party.setCreatedTime(new Date());
        	party.setDescription(person.getName());
        	party.setPartyTypeId("person");
        	party.setStatusId(0l);//状态正常
        	party = partyGroupManager.saveParty(party);
        	person.setPartyId(party.getPartyId());
        	
        	//保存完partygroup之后紧接着保存partygroup的relationship//新增肯定是按照关系来新增的不是独立新增的
        	PartyRole partyRole = new PartyRole();
        	partyRole.setCreatedByUser(getCurrentUser().getId());
        	partyRole.setCreatedTime(new Date());
        	if(roleType!=null && !"".equals(roleType)){
        		partyRole.setRoleTypeId(Long.valueOf(roleType));
        		if("5".equals(roleType)){
        			partyRole.setRoleAttached1(statusAndUnit);
        		}
        	}else{
        		partyRole.setRoleTypeId(1l);
        	}
        	
        	partyRole.setPartyId(party.getPartyId());
        	partyRole = partyGroupManager.savePartyRole(partyRole);
        	//有父id的父id来出来保存relationship
        	if(belongGroupId!=null && !"".equals(belongGroupId)){
        		PartyRelationship partyRelationship = new PartyRelationship();
        		partyRelationship.setCreatedByUser(getCurrentUser().getId());
        		partyRelationship.setCreatedTime(new Date());
        		partyRelationship.setFromDate(new Date());
        		partyRelationship.setPartyIdFrom(Long.valueOf(belongGroupId));
        		partyRelationship.setPartyIdTo(party.getPartyId());
        		partyRelationship.setPartyRelationshipTypeId(1l);
        		partyRelationship.setRoleTypeIdFrom(1l);
        		partyRelationship.setRoleTypeIdTo(1l);
        		partyRelationship.setStatusId(0l);
        		partyRelationshipManager.save(partyRelationship);
        	}
        }else{
        	person.setLastUpdatedByUser(getCurrentUser().getId());
        	person.setLastUpdatedTime(new Date());
        }
        if(getRequest().getParameter("person.pinyinName")==null || "".equals(getRequest().getParameter("person.pinyinName"))){
        	person.setPinyinName(PinYinUtil.getPinYinHeadChar(person.getName()));
        }
        personManager.save(person);

        String key = (isNew) ? "person.added" : "person.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    
    }
    public String editDangPerson(){
    	if(personId!=null){
    		person = personManager.get(personId);
        	Long partyId = person.getPartyId();
        	cpDtl = personManager.getCpDtlByPartyId(partyId);
    	}else{
    		person = new Person();
    		cpDtl = new CpDtl();
    	}
    	String merriageSelector = super.getEnumerationSelector(11l, (person.getMarriage()==null||person.getMarriage().equals(""))?null:Long.valueOf(person.getMarriage()));
    	String nationSelector = super.getEnumerationSelector(10l, (person.getNation()==null||person.getNation().equals(""))?null:Long.valueOf(person.getNation()));
    	String educationSelector = super.getEnumerationSelector(12l, (person.getEducation()==null||person.getEducation().equals(""))?null:Long.valueOf(person.getEducation()));
    	String occupationSelector = super.getEnumerationSelector(13l, (cpDtl.getOccupation()==null||cpDtl.getOccupation().equals(""))?null:Long.valueOf(cpDtl.getOccupation()));
    	getRequest().setAttribute("merriageSelector", merriageSelector);
    	getRequest().setAttribute("nationSelector", nationSelector);
    	getRequest().setAttribute("educationSelector", educationSelector);
    	getRequest().setAttribute("occupationSelector", occupationSelector);
    	return SUCCESS;
    }
    public String saveDangPerson(){

        if (delete != null) {
            //暂时不做删除
        	//personManager.remove(person.getPersonId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (person.getPersonId() == null);
        
        if(isNew){
        	//先保存party然后再保存partygroup
        	Party party = new Party();
        	party.setCreatedByUser(getCurrentUser().getId());
        	party.setCreatedTime(new Date());
        	party.setDescription(person.getName());
        	party.setPartyTypeId("person");
        	party.setStatusId(0l);//状态正常
        	party = partyGroupManager.saveParty(party);
        	person.setPartyId(party.getPartyId());
        	
        	//保存完partygroup之后紧接着保存partygroup的relationship//新增肯定是按照关系来新增的不是独立新增的
        	PartyRole partyRole = new PartyRole();
        	partyRole.setCreatedByUser(getCurrentUser().getId());
        	partyRole.setCreatedTime(new Date());
        	partyRole.setRoleTypeId(2l);//党员,用在partygroup上是党委或支部，如果用在人身上则是党员
        	
        	partyRole.setPartyId(party.getPartyId());
        	partyRole = partyGroupManager.savePartyRole(partyRole);
        	//有父id的父id来出来保存relationship,党员或者党员与支部之间的归属关系。
        	if(belongGroupId!=null && !"".equals(belongGroupId)){
        		PartyRelationship partyRelationship = new PartyRelationship();
        		partyRelationship.setCreatedByUser(getCurrentUser().getId());
        		partyRelationship.setCreatedTime(new Date());
        		partyRelationship.setFromDate(new Date());
        		partyRelationship.setPartyIdFrom(Long.valueOf(belongGroupId));
        		partyRelationship.setPartyIdTo(party.getPartyId());
        		partyRelationship.setPartyRelationshipTypeId(4l);
        		partyRelationship.setRoleTypeIdFrom(2l);
        		partyRelationship.setRoleTypeIdTo(2l);
        		partyRelationship.setStatusId(0l);
        		partyRelationshipManager.save(partyRelationship);
        	}
        	cpDtl.setStatusId(1L);
        	cpDtl.setPartyId(party.getPartyId());
        	cpDtl.setCreatedByUser(getCurrentUser().getId());
        	cpDtl.setCreatedTime(new Date());
        	//同时也保存党员的归属村么？？？？//待定,暂时不嫁了，因为找村下面的党员可以村关联党委支部 然后关联党员
        }else{
        	person.setLastUpdatedByUser(getCurrentUser().getId());
        	person.setLastUpdatedTime(new Date());
        	cpDtl.setLastUpdatedByUser(getCurrentUser().getId());
        	cpDtl.setLastUpdatedTime(new Date());
        }
        if(getRequest().getParameter("person.pinyinName")==null || "".equals(getRequest().getParameter("person.pinyinName"))){
        	person.setPinyinName(PinYinUtil.getPinYinHeadChar(person.getName()));
        }
        personManager.save(person);
        personManager.saveObject(cpDtl);
        String key = (isNew) ? "person.added" : "person.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String editUnitPerson(){
    	return SUCCESS;
    	
    }
    public String saveUnitPerson(){
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String cpDtlInfo(){
    	person = personManager.get(personId);
    	Long partyId = person.getPartyId();
    	cpDtl = personManager.getCpDtlByPartyId(partyId);
    	return SUCCESS;
    }
    public String editPositivePerson(){
    	if(personId!=null){
    		person = personManager.get(personId);
        	Long partyId = person.getPartyId();
        	cpDtl = personManager.getCpDtlByPartyId(partyId);
        	cpPositive = personManager.getCpPositiveByPartyId(partyId);
    	}else{
    		person = new Person();
    		cpDtl = new CpDtl();
    	}
    	
    	String merriageSelector = super.getEnumerationSelector(11l, (person.getMarriage()==null||person.getMarriage().equals(""))?null:Long.valueOf(person.getMarriage()));
    	String nationSelector = super.getEnumerationSelector(10l, (person.getNation()==null||person.getNation().equals(""))?null:Long.valueOf(person.getNation()));
    	String educationSelector = super.getEnumerationSelector(12l, (person.getEducation()==null||person.getEducation().equals(""))?null:Long.valueOf(person.getEducation()));
    	String occupationSelector = super.getEnumerationSelector(13l, (cpDtl.getOccupation()==null||cpDtl.getOccupation().equals(""))?null:Long.valueOf(cpDtl.getOccupation()));
    	getRequest().setAttribute("merriageSelector", merriageSelector);
    	getRequest().setAttribute("nationSelector", nationSelector);
    	getRequest().setAttribute("educationSelector", educationSelector);
    	getRequest().setAttribute("occupationSelector", occupationSelector);
    	return SUCCESS;
    }
    public String savePositivePerson(){
    	if (delete != null) {
            //暂时不做删除
        	//personManager.remove(person.getPersonId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (person.getPersonId() == null);
        
        if(isNew){
        	//先保存party然后再保存partygroup
        	Party party = new Party();
        	party.setCreatedByUser(getCurrentUser().getId());
        	party.setCreatedTime(new Date());
        	party.setDescription(person.getName());
        	party.setPartyTypeId("person");
        	party.setStatusId(0l);//状态正常
        	party = partyGroupManager.saveParty(party);
        	person.setPartyId(party.getPartyId());
        	
        	//保存完partygroup之后紧接着保存partygroup的relationship//新增肯定是按照关系来新增的不是独立新增的
        	PartyRole partyRole = new PartyRole();
        	partyRole.setCreatedByUser(getCurrentUser().getId());
        	partyRole.setCreatedTime(new Date());
        	partyRole.setRoleTypeId(2l);//党员,用在partygroup上是党委或支部，如果用在人身上则是党员
        	
        	partyRole.setPartyId(party.getPartyId());
        	partyRole = partyGroupManager.savePartyRole(partyRole);
        	//有父id的父id来出来保存relationship,党员或者党员与支部之间的归属关系。
        	if(belongGroupId!=null && !"".equals(belongGroupId)){
        		PartyRelationship partyRelationship = new PartyRelationship();
        		partyRelationship.setCreatedByUser(getCurrentUser().getId());
        		partyRelationship.setCreatedTime(new Date());
        		partyRelationship.setFromDate(new Date());
        		partyRelationship.setPartyIdFrom(Long.valueOf(belongGroupId));
        		partyRelationship.setPartyIdTo(party.getPartyId());
        		partyRelationship.setPartyRelationshipTypeId(4l);
        		partyRelationship.setRoleTypeIdFrom(2l);
        		partyRelationship.setRoleTypeIdTo(2l);
        		partyRelationship.setStatusId(0l);
        		partyRelationshipManager.save(partyRelationship);
        	}
        	cpDtl.setPartyId(party.getPartyId());
        	cpDtl.setCreatedByUser(getCurrentUser().getId());
        	cpDtl.setCreatedTime(new Date());
        	cpDtl.setStatusId(4L);//预备党员
        	
        	cpPositive.setPartyId(party.getPartyId());
        	cpPositive.setCreatedByUser(getCurrentUser().getId());
        	cpPositive.setCreatedTime(new Date());
        	//同时也保存党员的归属村么？？？？//待定,暂时不嫁了，因为找村下面的党员可以村关联党委支部 然后关联党员
        }else{
        	person.setLastUpdatedByUser(getCurrentUser().getId());
        	person.setLastUpdatedTime(new Date());
        	cpDtl.setLastUpdatedByUser(getCurrentUser().getId());
        	cpDtl.setLastUpdatedTime(new Date());
        	cpPositive.setLastUpdatedByUser(getCurrentUser().getId());
        	cpPositive.setLastUpdatedTime(new Date());
        }
        if(getRequest().getParameter("person.pinyinName")==null || "".equals(getRequest().getParameter("person.pinyinName"))){
        	person.setPinyinName(PinYinUtil.getPinYinHeadChar(person.getName()));
        }
        personManager.save(person);
        personManager.saveObject(cpDtl);
        personManager.saveObject(cpPositive);
        String key = (isNew) ? "person.added" : "person.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String approvalDangPerson(){
    	person = personManager.get(personId);
    	Long partyId = person.getPartyId();
    	cpDtl = personManager.getCpDtlByPartyId(partyId);
    	return SUCCESS;
    }
    public String approvalDangPersonSave(){
    	String partyId = getRequest().getParameter("partyId");
    	String totalNum = getRequest().getParameter("totalNum");
    	String approvalNum = getRequest().getParameter("approvalNum");
    	String approvalResult = getRequest().getParameter("approvalResult");
    	String resultStatus = getRequest().getParameter("resultStatus");
    	if(approvalResult!=null && "1".equals(approvalResult) && resultStatus!=null){
    		Integer nowStatus = Integer.valueOf(resultStatus) - 1;
    		resultStatus = nowStatus.toString();
    	}
    	personManager.approvalDangPerson(partyId,totalNum,approvalNum,approvalResult,resultStatus);
    	super.setJsonResult("保存成功");
        return "jsonResult";
    }
}