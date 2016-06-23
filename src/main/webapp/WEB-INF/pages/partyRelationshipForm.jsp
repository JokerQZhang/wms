<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="partyRelationshipDetail.title"/></title>
    <meta name="menu" content="PartyRelationshipMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="partyRelationshipForm" action="savePartyRelationship" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePartyRelationship);">
        <s:hidden key="partyRelationship.partyRelationshipId"/>
        <s:textfield cssClass="form-control date" key="partyRelationship.fromDate" size="11" title="date" datepicker="true"/>
        <s:textfield cssClass="form-control" key="partyRelationship.partyIdFrom"/>
        <s:textfield cssClass="form-control" key="partyRelationship.partyIdTo"/>
        <s:textfield cssClass="form-control" key="partyRelationship.partyRelationshipTypeId"/>
        <s:textfield cssClass="form-control" key="partyRelationship.roleTypeIdFrom"/>
        <s:textfield cssClass="form-control" key="partyRelationship.roleTypeIdTo"/>
        <s:textfield cssClass="form-control" key="partyRelationship.statusId"/>
        <s:textfield cssClass="form-control date" key="partyRelationship.thruDate" size="11" title="date" datepicker="true"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty partyRelationship.partyRelationshipId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#partyRelationshipForm').attr('action','/savePartyRelationship?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePartyRelationship('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePartyRelationship(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#partyRelationshipSearchForm"),$("#partyRelationshipPageNav").find("li[class='active']").find("a").html());
}
</script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.min.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.min.js'/>"></script>
<c:if test="${pageContext.request.locale.language != 'en'}">
<script type="text/javascript" src="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js'/>"></script>
</c:if>
<script type="text/javascript">
    $(document).ready(function() {
        $('.date').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
    });
</script>
