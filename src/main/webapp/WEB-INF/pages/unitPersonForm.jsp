<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personDetail.title"/></title>
    <meta name="menu" content="PersonMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="personForm" action="saveCunPerson" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePerson);">
        <s:hidden key="person.personId"/>
        <input type="hidden" name="belongGroupId" value="${belongGroupId}">
        <div class="control-label">
        	<label class="control-label">人员类型</label>
        	<select name="roleType" class="form-control" onchange="changePersonType(this)">
	        	<option> </option>
	        	<option value="3">村支书</option>
	        	<option value="4">村委主任</option>
	        	<option value="5">第一书记</option>
	        </select>
        </div>
		<div class="control-label" id="statusAndUnitDiv" style="display:none;">
        	<label class="control-label">派驻单位及职务</label>
        	<input name="statusAndUnit" type="text" class="form-control"/>
        </div>
        <s:textfield cssClass="form-control" key="person.name"/>
        <s:textfield cssClass="form-control" key="person.gender"/>
        <s:textfield cssClass="form-control" key="person.phone"/>
        <s:textfield cssClass="form-control" key="person.cardId"/>
        <s:textfield cssClass="form-control" key="person.birthday"/>
        <s:textfield cssClass="form-control" key="person.nation"/>
        <s:textfield cssClass="form-control" key="person.household"/>
        <s:textfield cssClass="form-control" key="person.marriage"/>
        <s:textfield cssClass="form-control" key="person.education"/>
        <s:textfield cssClass="form-control" key="person.educationSchoole"/>
        <s:textfield cssClass="form-control" key="person.educationSpeciality"/>
        <s:textfield cssClass="form-control" key="person.familyAddress"/>
        <s:textfield cssClass="form-control" key="person.qq"/>
        <s:textfield cssClass="form-control" key="person.weixin"/>
        <s:textfield cssClass="form-control" key="person.workDate"/>
        <s:hidden cssClass="form-control" key="person.age"/>
        <s:hidden cssClass="form-control" key="person.partyId"/>
        <s:hidden cssClass="form-control" key="person.personalTitle"/>
        

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty person.personId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#personForm').attr('action','/saveCunPerson?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePerson('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePerson(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#personSearchForm"),$("#personPageNav").find("li[class='active']").find("a").html());
}
function changePersonType(pselect){
	var sv = $(pselect).val();
	if(sv==5){
		$("#statusAndUnitDiv").show();
	}else{
		$("#statusAndUnitDiv").hide();
	}
}
</script>
