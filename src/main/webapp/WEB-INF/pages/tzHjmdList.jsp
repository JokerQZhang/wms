<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="tzHjmdList.title"/></title>
	    <meta name="menu" content="TzHjmdMenu"/>
	</head>
    <form method="post" action="${ctx}/tzHjmds" id="tzHjmdSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#tzHjmdSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzHjmd'/>',title:'<fmt:message key="tzHjmdDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzHjmdFormOpen,afterDialogOpen:afterTzHjmdFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTzHjmd) == "undefined"){
			afterSelectTzHjmd = function(data){return true;};
		}
		if(typeof(beforeTzHjmdFormOpen) == "undefined"){
			beforeTzHjmdFormOpen = function(data){return true;};
		}
		if(typeof(afterTzHjmdFormOpen) == "undefined"){
			afterTzHjmdFormOpen = function(data){return true;};
		}
	</script>
    <div id="tzHjmdSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="tzHjmd.hjmdId"/></th>
				<th><fmt:message key="tzHjmd.createdByUser"/></th>
				<th><fmt:message key="tzHjmd.createdTime"/></th>
				<th><fmt:message key="tzHjmd.groupPartyId"/></th>
				<th><fmt:message key="tzHjmd.hjmdjfDtl"/></th>
				<th><fmt:message key="tzHjmd.hjmdjfNum"/></th>
				<th><fmt:message key="tzHjmd.jjlsylwtDtl"/></th>
				<th><fmt:message key="tzHjmd.jjlsylwtNum"/></th>
				<th><fmt:message key="tzHjmd.lastUpdatedByUser"/></th>
				<th><fmt:message key="tzHjmd.lastUpdatedTime"/></th>
				<th><fmt:message key="tzHjmd.tzDate"/></th>
				<th><fmt:message key="tzHjmd.zfqzPersonNum"/></th>
				<th><fmt:message key="tzHjmd.zfqzTimes"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tzHjmds}" var="tzHjmd">
				<tr onclick="commonTableListSelect(this,afterSelectTzHjmd)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzHjmd'/>',title:'<fmt:message key="tzHjmdDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzHjmdFormOpen,afterDialogOpen:afterTzHjmdFormOpen,data:{hjmdId:'${tzHjmd.hjmdId}',from:'list'}})">${tzHjmd.hjmdId}</a></td>
					
					<td>${tzHjmd.createdByUser}</td>
					<td>${tzHjmd.createdTime}</td>
					<td>${tzHjmd.groupPartyId}</td>
					<td>${tzHjmd.hjmdjfDtl}</td>
					<td>${tzHjmd.hjmdjfNum}</td>
					<td>${tzHjmd.jjlsylwtDtl}</td>
					<td>${tzHjmd.jjlsylwtNum}</td>
					<td>${tzHjmd.lastUpdatedByUser}</td>
					<td>${tzHjmd.lastUpdatedTime}</td>
					<td>${tzHjmd.tzDate}</td>
					<td>${tzHjmd.zfqzPersonNum}</td>
					<td>${tzHjmd.zfqzTimes}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="tzHjmdPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#tzHjmdSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#tzHjmdSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#tzHjmdSearchForm'),'${page.pageIndex+1}')">
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
