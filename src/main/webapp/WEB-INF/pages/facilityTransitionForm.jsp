<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="facilityTransitionDetail.title"/></title>
    <meta name="menu" content="FacilityTransitionMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="facilityTransitionForm" action="saveFacilityTransition" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveFacilityTransition);">
        <s:hidden key="facilityTransition.facilityTransitionId"/>
        <input type="hidden" name="directlyModify" value="${directlyModify}">
        
        <s:hidden cssClass="form-control" key="facilityTransition.bizId"/>
        <s:hidden cssClass="form-control" key="facilityTransition.bizType"/>
        <s:hidden cssClass="form-control" key="facilityTransition.facilityId"/>
        <s:hidden cssClass="form-control" key="facilityTransition.inOutType"/>
        <s:textfield cssClass="form-control" key="facilityTransition.num"/>
        <s:hidden cssClass="form-control" key="facilityTransition.productId"/>
        <s:hidden cssClass="form-control date" key="facilityTransition.tranDate" size="11" title="date" datepicker="true"/>
        <s:hidden cssClass="form-control" key="facilityTransition.uomId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty facilityTransition.facilityTransitionId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#facilityTransitionForm').attr('action','/saveFacilityTransition?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveFacilityTransition('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveFacilityTransition(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#facilityTransitionSearchForm"),$("#facilityTransitionPageNav").find("li[class='active']").find("a").html());
	$("#invertorySearchForm").submit();
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
