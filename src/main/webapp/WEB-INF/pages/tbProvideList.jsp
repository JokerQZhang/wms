<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="tbProvideList.title"/></title>
	    <meta name="menu" content="TbProvideMenu"/>
	</head>

    <form method="post" action="${ctx}/tbProvides" id="tbProvideSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#tbProvideSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-6">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="glyphicon glyphicon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTbProvide'/>',title:'<fmt:message key="tbProvideDetail.heading"/>',width:600,height:400,beforeDialogOpen:beforeTbProvideFormOpen,afterDialogOpen:afterTbProvideFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="glyphicon glyphicon-plus"></i> <fmt:message key="button.add"/>
		        </a>
		        <a class="btn btn-warning btn-sm" href="#" onclick="sendMoney(this)">
		            <i class="glyphicon glyphicon-share"></i>发放
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTbProvide) == "undefined"){
			afterSelectTbProvide = function(data){return true;};
		}
		if(typeof(beforeTbProvideFormOpen) == "undefined"){
			beforeTbProvideFormOpen = function(data){return true;};
		}
		if(typeof(afterTbProvideFormOpen) == "undefined"){
			afterTbProvideFormOpen = function(data){return true;};
		}
	</script>
    <div id="tbProvideSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="tbProvide.provideId"/></th>
				<th><fmt:message key="tbProvide.departmentId"/></th>
				<th><fmt:message key="tbProvide.provideDate"/></th>
				<th><fmt:message key="tbProvide.provideName"/></th>
				<th><fmt:message key="tbProvide.provideSum"/></th>
				<th><fmt:message key="tbProvide.validFlag"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tbProvides}" var="tbProvide">
				<tr onclick="commonTableListSelect(this,afterSelectTbProvide)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTbProvide'/>',title:'<fmt:message key="tbProvideDetail.heading"/>',width:600,height:400,beforeDialogOpen:beforeTbProvideFormOpen,afterDialogOpen:afterTbProvideFormOpen,data:{provideId:'${tbProvide.provideId}',from:'list'}})">${tbProvide.provideId}</a></td>
					<td>${tbProvide.departmentId}</td>
					<td>${tbProvide.provideDate}</td>
					<td>${tbProvide.provideName}</td>
					<td>${tbProvide.provideSum}</td>
					<td>${tbProvide.validFlag}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="tbProvidePageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#tbProvideSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#tbProvideSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#tbProvideSearchForm'),'${page.pageIndex+1}')">
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
