<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="answererDetail.title"/></title>
    <meta name="menu" content="AnswererMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="answererForm" action="saveAnswerer" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveAnswerer);">
        <s:hidden key="answerer.answererId"/>
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="answerer.answerIdentifyId"/></label>
				        	  <input class="form-control" type="text" name="answerer.answerIdentifyId" value="${answerer.answerIdentifyId}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="answerer.answerIdentifyId"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="answerer.answerPerson"/></label>
				        	  <input class="form-control" type="text" name="answerer.answerPerson" value="${answerer.answerPerson}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="answerer.answerPerson"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="answerer.answerPhone"/></label>
				        	  <input class="form-control" type="text" name="answerer.answerPhone" value="${answerer.answerPhone}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="answerer.answerPhone"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="answerer.answerPid"/></label>
				        	  <input class="form-control" type="text" name="answerer.answerPid" value="${answerer.answerPid}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="answerer.answerPid"/> -->

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty answerer.answererId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#answererForm').attr('action','/saveAnswerer?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveAnswerer('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveAnswerer(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#answererSearchForm"),$("#answererPageNav").find("li[class='active']").find("a").html());
}
</script>
