<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="facilityDetail.title"/></title>
    <meta name="menu" content="FacilityMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="facilityForm" action="saveFacility" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveFacility);">
        <s:hidden key="facility.facilityId"/>
        <s:hidden key="groupId"/>
        <s:textfield cssClass="form-control" key="facility.facilityName"/>
        <s:textfield cssClass="form-control" key="facility.facilityTypeId"/>
        <s:textfield cssClass="form-control" key="facility.geoPointId"/>
        <s:hidden cssClass="form-control" key="facility.ownerPartyId"/>
        <s:textfield cssClass="form-control" key="facility.parentId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty facility.facilityId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#facilityForm').attr('action','/saveFacility?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveFacility('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveFacility(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#facilitySearchForm"),$("#facilityPageNav").find("li[class='active']").find("a").html());
}
</script>
