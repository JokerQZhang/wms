<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="testQuestionDetail.title" /></title>
<meta name="menu" content="TestQuestionMenu" />
</head>

<div class="col-sm-12">
	<s:form id="testQuestionForm" action="saveTestQuestion" method="post"
		validate="false" cssClass="well"
		onsubmit="return ajaxSubmitFormUpdateAreas(this,undefined,afterSaveTestQuestion);">
		<s:hidden key="testQuestion.questionId" />
		<s:hidden key="testQuestion.rightAnswer" />
		<s:hidden key="testQuestion.questionLevel" />
		<s:hidden key="testQuestion.analysis" />
		<div class="form-group col-sm-12">
			<label><fmt:message key="testQuestion.questionTitle" /></label> 
			<textarea class="form-control" name="testQuestion.questionTitle" rows="1">${testQuestion.questionTitle}</textarea>
		</div>
		<div class="form-group col-sm-12">
			<label class="col-sm-2 control-label">A:&nbsp;&nbsp;<input type="checkbox" name="ranswer" value="A" ${fn:contains(ranswer,'A')?"checked":""}></label> 
			<div class="col-sm-10"><s:hidden key="oaid" />
				<textarea class="form-control" name="optiona" rows="1">${optiona}</textarea>
			</div>
		</div>
		<div class="form-group col-sm-12">
			<label class="col-sm-2 control-label">B:&nbsp;&nbsp;<input type="checkbox" name="ranswer" value="B" ${fn:contains(ranswer,'B')?"checked":""}></label>
			<div class="col-sm-10"><s:hidden key="obid" />
				<textarea class="form-control" name="optionb" rows="1">${optionb}</textarea>
			</div>
		</div>
		<div class="form-group col-sm-12">
			<label class="col-sm-2 control-label">C:&nbsp;&nbsp;<input type="checkbox" name="ranswer" value="C" ${fn:contains(ranswer,'C')?"checked":""}></label> 
			<div class="col-sm-10"><s:hidden key="ocid" />
				<textarea class="form-control" name="optionc" rows="1">${optionc}</textarea>
			</div>
		</div>
		<div class="form-group col-sm-12">
			<label class="col-sm-2 control-label">D:&nbsp;&nbsp;<input type="checkbox" name="ranswer"  value="D" ${fn:contains(ranswer,'D')?"checked":""}></label>
			<div class="col-sm-10"><s:hidden key="odid" />
				<textarea class="form-control" name="optiond" rows="1">${optiond}</textarea>
			</div>
		</div>
		
		<div class="form-group col-sm-12">
			<label><fmt:message key="testQuestion.questionType" /></label> 
			<select class="form-control" name="testQuestion.questionType">
				<%=request.getAttribute("testType") %>
			</select>
		</div>
		<div class="form-group">
			<s:submit type="button" id="save" cssClass="btn btn-primary"
				method="save" key="button.save" theme="simple">
				<i class="icon-ok icon-white"></i>
				<fmt:message key="button.save" />
			</s:submit>
			<c:if test="${not empty testQuestion.questionId}">
				<s:submit type="button" id="delete" cssClass="btn btn-danger"
					method="delete" key="button.delete"
					onclick="$('#testQuestionForm').attr('action','/saveTestQuestion?delete=1'); return confirmMessage('确认删除？')"
					theme="simple">
					<i class="icon-trash icon-white"></i>
					<fmt:message key="button.delete" />
				</s:submit>
			</c:if>
			<a href="#" class="btn btn-default"
				onclick="afterSaveTestQuestion('取消保存')"> <i class="icon-remove"></i>
				<fmt:message key="button.cancel" /></a>
		</div>
	</s:form>
</div>
<script type="text/javascript">
function afterSaveTestQuestion(data){
	alert(data);
	$("#jokerdialogframexixi").dialog("close");
	formPage($("#testQuestionSearchForm"),$("#testQuestionPageNav").find("li[class='active']").find("a").html());
}
</script>
