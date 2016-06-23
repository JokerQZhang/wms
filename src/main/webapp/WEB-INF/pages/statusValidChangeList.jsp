<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="statusValidChangeList.title"/></title>
    <meta name="menu" content="StatusValidChangeMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <form method="post" action="${ctx}/statusValidChanges" id="statusValidChangeSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#statusValidChangeSearchFormDiv'),null,beforeVCSearchSubmit);">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input name="selectedStatusTypeId" type="hidden"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editStatusValidChange'/>',title:'<fmt:message key="statusValidChangeDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeStatusValidChangeFormOpen,afterDialogOpen:afterStatusValidChangeFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectStatusValidChange) == "undefined"){
			afterSelectStatusValidChange = function(data){return true;};
		}
		if(typeof(beforeStatusValidChangeFormOpen) == "undefined"){
			beforeStatusValidChangeFormOpen = function(data){return true;};
		}
		if(typeof(afterStatusValidChangeFormOpen) == "undefined"){
			afterStatusValidChangeFormOpen = function(data){return true;};
		}
		if(typeof(beforeVCSearchSubmit) == "undefined"){
			beforeVCSearchSubmit = function(){return true;};
		}
	</script>
    <p><fmt:message key="statusValidChangeList.message"/></p>
    <div id="statusValidChangeSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="statusValidChange.svcId"/></th>
				<th><fmt:message key="statusValidChange.conditionExpression"/></th>
				<th><fmt:message key="statusValidChange.statusIdFrom"/></th>
				<th><fmt:message key="statusValidChange.statusIdTo"/></th>
				<th><fmt:message key="statusValidChange.transitionName"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${statusValidChanges}" var="statusValidChange">
				<tr onclick="commonTableListSelect(this,afterSelectStatusValidChange)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editStatusValidChange'/>',title:'<fmt:message key="statusValidChangeDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeStatusValidChangeFormOpen,afterDialogOpen:afterStatusValidChangeFormOpen,data:{svcId:'${statusValidChange.svcId}',from:'list'}})">${statusValidChange.svcId}</a></td>
					
					<td>${statusValidChange.conditionExpression}</td>
					<td>${statusValidChange.statusIdFrom}</td>
					<td>${statusValidChange.statusIdTo}</td>
					<td>${statusValidChange.transitionName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="statusValidChangePageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#statusValidChangeSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#statusValidChangeSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#statusValidChangeSearchForm'),'${page.pageIndex+1}')">
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
