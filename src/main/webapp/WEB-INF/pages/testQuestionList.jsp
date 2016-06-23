<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="testQuestionList.title"/></title>
	    <meta name="menu" content="TestQuestionMenu"/>
	</head>
    <form method="post" action="${ctx}/testQuestions" id="testQuestionSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#testQuestionSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTestQuestion'/>',title:'<fmt:message key="testQuestionDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTestQuestionFormOpen,afterDialogOpen:afterTestQuestionFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTestQuestion) == "undefined"){
			afterSelectTestQuestion = function(data){return true;};
		}
		if(typeof(beforeTestQuestionFormOpen) == "undefined"){
			beforeTestQuestionFormOpen = function(data){return true;};
		}
		if(typeof(afterTestQuestionFormOpen) == "undefined"){
			afterTestQuestionFormOpen = function(data){return true;};
		}
	</script>
    <div id="testQuestionSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="testQuestion.questionId"/></th>
				<th><fmt:message key="testQuestion.questionType"/></th>
				<th><fmt:message key="testQuestion.questionTitle"/></th>
				<th><fmt:message key="testQuestion.rightAnswer"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${testQuestions}" var="testQuestion">
				<tr onclick="commonTableListSelect(this,afterSelectTestQuestion)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTestQuestion'/>',title:'<fmt:message key="testQuestionDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTestQuestionFormOpen,afterDialogOpen:afterTestQuestionFormOpen,data:{questionId:'${testQuestion.questionId}',from:'list'}})">${testQuestion.questionId}</a></td>
					<td>${testQuestion.questionType}</td>
					<td>${testQuestion.questionTitle}</td>
					<td>${testQuestion.rightAnswer}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="testQuestionPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#testQuestionSearchForm'),'${page.pageIndex-1}')">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    
			<c:set var="minpage" scope="page" value="${page.pageIndex-2}"></c:set>
			<c:if test="${minpage<1 || page.pageNum<=5}">
				<c:set var="minpage" scope="page" value="1"></c:set>
			</c:if>
			<c:set var="maxpage" scope="page" value="${minpage+4}"></c:set>
			<c:if test="${maxpage>page.pageNum}">
				<c:set var="maxpage" scope="page" value="${page.pageNum}"></c:set>
				<c:if test="${maxpage>5}">
					<c:set var="minpage" scope="page" value="${maxpage-4}"></c:set>
				</c:if>
			</c:if>
			<c:forEach begin="${minpage}" end="${maxpage}" var="i">
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#testQuestionSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#testQuestionSearchForm'),'${page.pageIndex+1}')">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    <li><span><fmt:message key="page.pagetitle"><fmt:param value="${page.pageNum}"/><fmt:param value="${page.allRecordNum}"/></fmt:message></span></li>
		  </ul>
		</nav>
	</c:if>
<%
}
%>
