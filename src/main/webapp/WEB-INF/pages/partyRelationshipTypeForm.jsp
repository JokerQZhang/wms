<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="partyRelationshipTypeDetail.title"/></title>
    <meta name="menu" content="PartyRelationshipTypeMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="partyRelationshipTypeForm" action="savePartyRelationshipType" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePartyRelationshipType);">
        <s:hidden key="partyRelationshipType.partyRelationshipTypeId"/>
        <s:textfield cssClass="form-control" key="partyRelationshipType.description"/>
        <s:textfield cssClass="form-control" key="partyRelationshipType.hasTable"/>
        <s:textfield cssClass="form-control" key="partyRelationshipType.parentId"/>
        <s:textfield cssClass="form-control" key="partyRelationshipType.partyRelationshipName"/>
        <s:textfield cssClass="form-control" key="partyRelationshipType.roleTypeValidFrom"/>
        <s:textfield cssClass="form-control" key="partyRelationshipType.roleTypeValidTo"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty partyRelationshipType.partyRelationshipTypeId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#partyRelationshipTypeForm').attr('action','/savePartyRelationshipType?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePartyRelationshipType('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePartyRelationshipType(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#partyRelationshipTypeSearchForm"),$("#partyRelationshipTypePageNav").find("li[class='active']").find("a").html());
}
</script>
