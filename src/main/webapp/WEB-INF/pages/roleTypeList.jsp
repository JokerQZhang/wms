<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="roleTypeList.title"/></title>
    <meta name="menu" content="RoleTypeMenu"/>
    <meta name="title.name" content="<fmt:message key="roleTypeList.heading"/>"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <form method="post" action="${ctx}/roleTypes" id="roleTypeSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#roleTypeSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
	    <div id="" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editRoleType'/>',title:'<fmt:message key="roleTypeDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeRoleTypeFormOpen,afterDialogOpen:afterRoleTypeFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectRoleType) == "undefined"){
			afterSelectRoleType = function(data){return true;};
		}
		if(typeof(beforeRoleTypeFormOpen) == "undefined"){
			beforeRoleTypeFormOpen = function(data){return true;};
		}
		if(typeof(afterRoleTypeFormOpen) == "undefined"){
			afterRoleTypeFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="roleTypeList.message"/></p>
    <div id="roleTypeSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="roleType.roleTypeId"/></th>
				<th><fmt:message key="roleType.createdByUser"/></th>
				<th><fmt:message key="roleType.createdTime"/></th>
				<th><fmt:message key="roleType.description"/></th>
				<th><fmt:message key="roleType.hasTable"/></th>
				<th><fmt:message key="roleType.lastUpdatedByUser"/></th>
				<th><fmt:message key="roleType.lastUpdatedTime"/></th>
				<th><fmt:message key="roleType.parentId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${roleTypes}" var="roleType">
				<tr onclick="commonTableListSelect(this,afterSelectRoleType)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editRoleType'/>',title:'<fmt:message key="roleTypeDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeRoleTypeFormOpen,afterDialogOpen:afterRoleTypeFormOpen,data:{roleTypeId:'${roleType.roleTypeId}',from:'list'}})">${roleType.roleTypeId}</a></td>
					
					<td>${roleType.createdByUser}</td>
					<td>${roleType.createdTime}</td>
					<td>${roleType.description}</td>
					<td>${roleType.hasTable}</td>
					<td>${roleType.lastUpdatedByUser}</td>
					<td>${roleType.lastUpdatedTime}</td>
					<td>${roleType.parentId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="roleTypePageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#roleTypeSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#roleTypeSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#roleTypeSearchForm'),'${page.pageIndex+1}')">
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
