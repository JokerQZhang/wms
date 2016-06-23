<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="salePlanDetail.title"/></title>
    <meta name="menu" content="SalePlanMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="salePlanForm" action="saveSalePlan" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveSalePlan);">
        <s:hidden key="salePlan.salePlanId"/>
        <s:textfield cssClass="form-control date" key="salePlan.date" size="11" title="date" datepicker="true"/>
        <s:hidden cssClass="form-control" key="salePlan.planName"/>
        <div class="form-group">
        	<label class="control-label"><fmt:message key="salePlan.facilityId"/></label>
        	<select class="form-control" name="salePlan.facilityId">
	        	<%=(String)request.getAttribute("facilityOptions") %>
	        </select>
        </div>
        
        <s:textfield cssClass="form-control" key="salePlan.memo"/>
        <s:hidden cssClass="form-control" key="salePlan.statusId"/>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty salePlan.salePlanId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#salePlanForm').attr('action','/saveSalePlan?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveSalePlan('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveSalePlan(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#salePlanSearchForm"),$("#salePlanPageNav").find("li[class='active']").find("a").html());
}
</script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.min.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.min.js'/>"></script>
<c:if test="${pageContext.request.locale.language != 'en'}">
<script type="text/javascript" src="<c:url value='/scripts/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js'/>"></script>
</c:if>
<script type="text/javascript">
    $(document).ready(function() {
        $('.date').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: 'zh-CN'});
    });
</script>
