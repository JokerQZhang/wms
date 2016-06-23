<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="petitionFlowDetail.title"/></title>
    <meta name="menu" content="PetitionFlowMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="petitionFlowForm" action="savePetitionFlow" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSavePetitionFlow);">
        <s:hidden key="petitionFlow.petitionFlowId"/>
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="petitionFlow.createdByUser"/></label>
				        	  <input class="form-control" type="text" name="petitionFlow.createdByUser" value="${petitionFlow.createdByUser}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="petitionFlow.createdByUser"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="petitionFlow.createdTime"/></label>
				        	  <input class="form-control" type="text" name="petitionFlow.createdTime" value="${petitionFlow.createdTime}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="petitionFlow.createdTime"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="petitionFlow.memo"/></label>
				        	  <input class="form-control" type="text" name="petitionFlow.memo" value="${petitionFlow.memo}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="petitionFlow.memo"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="petitionFlow.partyId"/></label>
				        	  <input class="form-control" type="text" name="petitionFlow.partyId" value="${petitionFlow.partyId}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="petitionFlow.partyId"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="petitionFlow.petitionId"/></label>
				        	  <input class="form-control" type="text" name="petitionFlow.petitionId" value="${petitionFlow.petitionId}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="petitionFlow.petitionId"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="petitionFlow.svcId"/></label>
				        	  <input class="form-control" type="text" name="petitionFlow.svcId" value="${petitionFlow.svcId}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="petitionFlow.svcId"/> -->

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty petitionFlow.petitionFlowId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#petitionFlowForm').attr('action','/savePetitionFlow?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSavePetitionFlow('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSavePetitionFlow(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#petitionFlowSearchForm"),$("#petitionFlowPageNav").find("li[class='active']").find("a").html());
}
</script>
