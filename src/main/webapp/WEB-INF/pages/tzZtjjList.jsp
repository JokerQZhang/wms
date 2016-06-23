<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="tzZtjjList.title"/></title>
	    <meta name="menu" content="TzZtjjMenu"/>
	</head>
    <form method="post" action="${ctx}/tzZtjjs" id="tzZtjjSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#tzZtjjSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzZtjj'/>',title:'<fmt:message key="tzZtjjDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzZtjjFormOpen,afterDialogOpen:afterTzZtjjFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTzZtjj) == "undefined"){
			afterSelectTzZtjj = function(data){return true;};
		}
		if(typeof(beforeTzZtjjFormOpen) == "undefined"){
			beforeTzZtjjFormOpen = function(data){return true;};
		}
		if(typeof(afterTzZtjjFormOpen) == "undefined"){
			afterTzZtjjFormOpen = function(data){return true;};
		}
	</script>
    <div id="tzZtjjSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="tzZtjj.ztjjId"/></th>
				<th><fmt:message key="tzZtjj.createdByUser"/></th>
				<th><fmt:message key="tzZtjj.createdTime"/></th>
				<th><fmt:message key="tzZtjj.groupPartyId"/></th>
				<th><fmt:message key="tzZtjj.lastUpdatedByUser"/></th>
				<th><fmt:message key="tzZtjj.lastUpdatedTime"/></th>
				<th><fmt:message key="tzZtjj.pyzfnsName"/></th>
				<th><fmt:message key="tzZtjj.pyzfnsSkill"/></th>
				<th><fmt:message key="tzZtjj.tzDate"/></th>
				<th><fmt:message key="tzZtjj.xtzjxmPurpose"/></th>
				<th><fmt:message key="tzZtjj.xtzjxmType"/></th>
				<th><fmt:message key="tzZtjj.zdcjfzghName"/></th>
				<th><fmt:message key="tzZtjj.zdcjfzghStatus"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tzZtjjs}" var="tzZtjj">
				<tr onclick="commonTableListSelect(this,afterSelectTzZtjj)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzZtjj'/>',title:'<fmt:message key="tzZtjjDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzZtjjFormOpen,afterDialogOpen:afterTzZtjjFormOpen,data:{ztjjId:'${tzZtjj.ztjjId}',from:'list'}})">${tzZtjj.ztjjId}</a></td>
					
					<td>${tzZtjj.createdByUser}</td>
					<td>${tzZtjj.createdTime}</td>
					<td>${tzZtjj.groupPartyId}</td>
					<td>${tzZtjj.lastUpdatedByUser}</td>
					<td>${tzZtjj.lastUpdatedTime}</td>
					<td>${tzZtjj.pyzfnsName}</td>
					<td>${tzZtjj.pyzfnsSkill}</td>
					<td>${tzZtjj.tzDate}</td>
					<td>${tzZtjj.xtzjxmPurpose}</td>
					<td>${tzZtjj.xtzjxmType}</td>
					<td>${tzZtjj.zdcjfzghName}</td>
					<td>${tzZtjj.zdcjfzghStatus}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="tzZtjjPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#tzZtjjSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#tzZtjjSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#tzZtjjSearchForm'),'${page.pageIndex+1}')">
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
