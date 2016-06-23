<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="petitionDetail.title"/></title>
    <meta name="menu" content="PetitionMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="petitionForm" action="saveApprovalPetition" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePetition);">
        <s:hidden key="petition.petitionId"/>
        <s:hidden key="petition.createdByUser"/>
        <s:hidden key="petition.createdTime"/>
        <s:hidden key="petition.lastUpdatedByUser"/>
        <s:hidden key="petition.lastUpdatedTime"/>
        <s:hidden key="petition.statusId"/>
        <s:hidden key="petition.realEndTime"/>
        <table class="table table-condensed table-striped table-hover table-bordered">
        	<tr>
        		<th><fmt:message key="petition.reportedPeople"/></th>
        		<td>${petition.reportedPeople}</td>
        		<th><fmt:message key="petition.reportedDep"/></th>
        		<td>${petition.reportedDep}</td>
        		<th><fmt:message key="petition.reportedStatus"/></th>
        		<td>${petition.reportedStatus}</td>
        		<th><fmt:message key="petition.reportedMemo"/></th>
        		<td>${petition.reportedMemo}</td>
        	</tr>
        	<tr>
        		<th><fmt:message key="petition.reportPeople"/></th>
        		<td>${petition.reportPeople}</td>
        		<th><fmt:message key="petition.reportDep"/></th>
        		<td>${petition.reportDep}</td>
        		<th><fmt:message key="petition.reportStatus"/></th>
        		<td>${petition.reportStatus}</td>
        		<th><fmt:message key="petition.reportPConnect"/></th>
        		<td>${petition.reportPConnect}</td>
        	</tr>
        	<tr>
        		<th><fmt:message key="petition.reportPNum"/></th>
        		<td>${petition.reportPNum}</td>
        		<th><fmt:message key="petition.reportType"/></th>
        		<td>${petition.reportType}</td>
        		<th><fmt:message key="petition.reportMethod"/></th>
        		<td>${petition.reportMethod}</td>
        		<th><fmt:message key="petition.reportMemo"/></th>
        		<td>${petition.reportMemo}</td>
        	</tr>
        	<tr>
        		<th><fmt:message key="petition.acceptName"/></th>
        		<td>${petition.acceptName}</td>
        		<th><fmt:message key="petition.acceptTime"/></th>
        		<td>${petition.acceptTime}</td>
        		<th><fmt:message key="petition.expectEndTime"/></th>
        		<td>${petition.expectEndTime}</td>
        		<th><fmt:message key="petition.processPartyId"/></th>
        		<td>${petition.processPartyId}</td>
        	</tr>
        	<tr>
        		<th><fmt:message key="petition.acceptContent"/></th>
        		<td colspan="7">${petition.acceptContent}</td>
        	</tr>
        	<tr>
        		<th><fmt:message key="petition.reportContent"/></th>
        		<td colspan="7">${petition.reportContent}</td>
        	</tr>
        </table>
		<div class="form-group col-sm-12">
       	  <label><fmt:message key="petition.leaderContent"/></label>
       	  <textarea class="form-control" name="petition.leaderContent" rows="5" cols="">${petition.leaderContent}</textarea>
        </div>
        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty petition.petitionId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#petitionForm').attr('action','/savePetition?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePetition('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePetition(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#petitionSearchForm"),$("#petitionPageNav").find("li[class='active']").find("a").html());
}
$(function(){
	getDatePicker($("input[name='petition.acceptTime']"));
	getDatePicker($("input[name='petition.expectEndTime']"));
	$("select[name='petition.processPartyId']").combobox();
})
</script>
