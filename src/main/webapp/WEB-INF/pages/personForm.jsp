<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personDetail.title"/></title>
    <meta name="menu" content="PersonMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="personForm" action="savePerson" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePerson);">
        <s:hidden key="person.personId"/>
        <input type="hidden" name="belongGroupId">
        <s:textfield cssClass="form-control" key="person.name"/>
        <div class="form-group">
        	<label class="control-label"><fmt:message key="person.gender"/></label>
        	<select class="form-control" name="person.gender">
        		<option value="男" ${person.gender eq "男"?"selected":"" }>男</option>
        		<option value="女" ${person.gender eq "女"?"selected":"" }>女</option>
        	</select>
        </div>
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
        <s:textfield cssClass="form-control" key="person.age"/>
        <s:hidden cssClass="form-control" key="person.partyId"/>
        <s:hidden cssClass="form-control" key="person.personalTitle"/>
        

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty person.personId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#personForm').attr('action','/savePerson?delete=1'); return confirmMessage('确认删除？')" theme="simple">
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
$(function(){
	getDatePicker($("input[name='person.birthday']"));
	getDatePicker($("input[name='person.workDate']"));
})
</script>
