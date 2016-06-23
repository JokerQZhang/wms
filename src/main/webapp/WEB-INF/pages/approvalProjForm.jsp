<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="approvalProjDetail.title"/></title>
    <meta name="menu" content="ApprovalProjMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="approvalProjForm" action="saveApprovalProj" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveApprovalProj);">
        <s:hidden key="approvalProj.approvalProjId"/>
        <s:hidden key="approvalProj.partyId"/>
        <s:hidden key="approvalProj.statisId"/>
        <div class="form-group col-sm-6">
        	<label><fmt:message key="approvalProj.projName"/></label>
        	<input class="form-control" type="text" name="approvalProj.projName" value="${approvalProj.projName}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="approvalProj.chargeStandard"/></label>
        	<input class="form-control" type="text" name="approvalProj.chargeStandard" value="${approvalProj.chargeStandard}"/>
        </div>
        <div class="form-group col-sm-3">
        	<label><fmt:message key="approvalProj.timeLimit"/></label>
        	<input class="form-control" type="text" name="approvalProj.timeLimit" value="${approvalProj.timeLimit}"/>
        </div>
        
        <div class="form-group col-sm-2">
        	<label><fmt:message key="approvalProj.connectPerson"/></label>
        	<input class="form-control" type="text" name="approvalProj.connectPerson" value="${approvalProj.connectPerson}"/>
        </div>
        <div class="form-group col-sm-2">
        	<label><fmt:message key="approvalProj.connectPhone"/></label>
        	<input class="form-control" type="text" name="approvalProj.connectPhone" value="${approvalProj.connectPhone}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="approvalProj.officeHour"/></label>
        	<input class="form-control" type="text" name="approvalProj.officeHour" value="${approvalProj.officeHour}"/>
        </div>
        <div class="form-group col-sm-4">
        	<label><fmt:message key="approvalProj.placeName"/></label>
        	<input class="form-control" type="text" name="approvalProj.placeName" value="${approvalProj.placeName}"/>
        </div>
        
        <div class="form-group col-sm-6">
        	<label><fmt:message key="approvalProj.placeAddress"/></label>
        	<input class="form-control" type="text" name="approvalProj.placeAddress" value="${approvalProj.placeAddress}"/>
        </div>
        <div class="form-group col-sm-6">
        	<label><fmt:message key="approvalProj.trafficWay"/></label>
        	<input class="form-control" type="text" name="approvalProj.trafficWay" value="${approvalProj.trafficWay}"/>
        </div>
        
        <div class="form-group col-sm-12">
        	<label><fmt:message key="approvalProj.projMaterial"/></label>
        	<input class="form-control" type="text" name="approvalProj.projMaterial" value="${approvalProj.projMaterial}"/>
        </div>
        <div class="form-group col-sm-12">
        	<label><fmt:message key="approvalProj.projProcedure"/></label>
        	<textarea class="form-control" name="approvalProj.projProcedure" rows="5" cols="">${approvalProj.projProcedure}</textarea>
        </div>

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty approvalProj.approvalProjId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#approvalProjForm').attr('action','/saveApprovalProj?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveApprovalProj('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveApprovalProj(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#approvalProjSearchForm"),$("#approvalProjPageNav").find("li[class='active']").find("a").html());
}
</script>
