<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="answererList.title"/></title>
	    <meta name="menu" content="AnswererMenu"/>
	</head>
    <form method="post" action="${ctx}/answerers" id="answererSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#answererSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editAnswerer'/>',title:'<fmt:message key="answererDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeAnswererFormOpen,afterDialogOpen:afterAnswererFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectAnswerer) == "undefined"){
			afterSelectAnswerer = function(data){return true;};
		}
		if(typeof(beforeAnswererFormOpen) == "undefined"){
			beforeAnswererFormOpen = function(data){return true;};
		}
		if(typeof(afterAnswererFormOpen) == "undefined"){
			afterAnswererFormOpen = function(data){return true;};
		}
	</script>
    <div id="answererSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="answerer.answererId"/></th>
				<th><fmt:message key="answerer.answerIdentifyId"/></th>
				<th><fmt:message key="answerer.answerPerson"/></th>
				<th><fmt:message key="answerer.answerPhone"/></th>
				<th><fmt:message key="answerer.answerPid"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${answerers}" var="answerer">
				<tr onclick="commonTableListSelect(this,afterSelectAnswerer)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editAnswerer'/>',title:'<fmt:message key="answererDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeAnswererFormOpen,afterDialogOpen:afterAnswererFormOpen,data:{answererId:'${answerer.answererId}',from:'list'}})">${answerer.answererId}</a></td>
					
					<td>${answerer.answerIdentifyId}</td>
					<td>${answerer.answerPerson}</td>
					<td>${answerer.answerPhone}</td>
					<td>${answerer.answerPid}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="answererPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#answererSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#answererSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#answererSearchForm'),'${page.pageIndex+1}')">
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
