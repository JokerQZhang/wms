<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="testPaperDetail.title"/></title>
    <meta name="menu" content="TestPaperMenu"/>
</head>

<div class="col-sm-12">
    <s:form id="testPaperForm" action="saveTestPaper" method="post" validate="false" cssClass="well" onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTestPaper);">
        <s:hidden key="testPaper.paperId"/>
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="testPaper.generateTime"/></label>
				        	  <input class="form-control" type="text" name="testPaper.generateTime" value="${testPaper.generateTime}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="testPaper.generateTime"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="testPaper.memo"/></label>
				        	  <input class="form-control" type="text" name="testPaper.memo" value="${testPaper.memo}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="testPaper.memo"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="testPaper.paperName"/></label>
				        	  <input class="form-control" type="text" name="testPaper.paperName" value="${testPaper.paperName}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="testPaper.paperName"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="testPaper.paperType"/></label>
				        	  <input class="form-control" type="text" name="testPaper.paperType" value="${testPaper.paperType}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="testPaper.paperType"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="testPaper.purposeType"/></label>
				        	  <input class="form-control" type="text" name="testPaper.purposeType" value="${testPaper.purposeType}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="testPaper.purposeType"/> -->
        <div class="form-group col-sm-12">
				        	  <label><fmt:message key="testPaper.score"/></label>
				        	  <input class="form-control" type="text" name="testPaper.score" value="${testPaper.score}"/>
				          </div>
            			<!--  <s:textfield cssClass="form-control" key="testPaper.score"/> -->

        <div class="form-group">
            <s:submit type="button" id="save" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty testPaper.paperId}">
                <s:submit type="button" id="delete" cssClass="btn btn-danger" method="delete" key="button.delete"
                    onclick="$('#testPaperForm').attr('action','/saveTestPaper?delete=1'); return confirmMessage('确认删除？')" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <a href="#" class="btn btn-default" onclick="afterSaveTestPaper('取消保存')">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/></a>
        </div>
    </s:form>
</div>
<script type="text/javascript">
function afterSaveTestPaper(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#testPaperSearchForm"),$("#testPaperPageNav").find("li[class='active']").find("a").html());
}
</script>
