<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="tzDhbzList.title"/></title>
	    <meta name="menu" content="TzDhbzMenu"/>
	</head>
    <form method="post" action="${ctx}/tzDhbzs" id="tzDhbzSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#tzDhbzSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzDhbz'/>',title:'<fmt:message key="tzDhbzDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzDhbzFormOpen,afterDialogOpen:afterTzDhbzFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTzDhbz) == "undefined"){
			afterSelectTzDhbz = function(data){return true;};
		}
		if(typeof(beforeTzDhbzFormOpen) == "undefined"){
			beforeTzDhbzFormOpen = function(data){return true;};
		}
		if(typeof(afterTzDhbzFormOpen) == "undefined"){
			afterTzDhbzFormOpen = function(data){return true;};
		}
	</script>
    <div id="tzDhbzSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="tzDhbz.dhbzId"/></th>
				<th><fmt:message key="tzDhbz.bdfs"/></th>
				<th><fmt:message key="tzDhbz.createdByUser"/></th>
				<th><fmt:message key="tzDhbz.createdTime"/></th>
				<th><fmt:message key="tzDhbz.groupPartyId"/></th>
				<th><fmt:message key="tzDhbz.hbgbNum"/></th>
				<th><fmt:message key="tzDhbz.lastUpdatedByUser"/></th>
				<th><fmt:message key="tzDhbz.lastUpdatedTime"/></th>
				<th><fmt:message key="tzDhbz.pyjjfzName"/></th>
				<th><fmt:message key="tzDhbz.pyjjfzNum"/></th>
				<th><fmt:message key="tzDhbz.tzDate"/></th>
				<th><fmt:message key="tzDhbz.zdzzhyName"/></th>
				<th><fmt:message key="tzDhbz.zdzzshTime"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tzDhbzs}" var="tzDhbz">
				<tr onclick="commonTableListSelect(this,afterSelectTzDhbz)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzDhbz'/>',title:'<fmt:message key="tzDhbzDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzDhbzFormOpen,afterDialogOpen:afterTzDhbzFormOpen,data:{dhbzId:'${tzDhbz.dhbzId}',from:'list'}})">${tzDhbz.dhbzId}</a></td>
					
					<td>${tzDhbz.bdfs}</td>
					<td>${tzDhbz.createdByUser}</td>
					<td>${tzDhbz.createdTime}</td>
					<td>${tzDhbz.groupPartyId}</td>
					<td>${tzDhbz.hbgbNum}</td>
					<td>${tzDhbz.lastUpdatedByUser}</td>
					<td>${tzDhbz.lastUpdatedTime}</td>
					<td>${tzDhbz.pyjjfzName}</td>
					<td>${tzDhbz.pyjjfzNum}</td>
					<td>${tzDhbz.tzDate}</td>
					<td>${tzDhbz.zdzzhyName}</td>
					<td>${tzDhbz.zdzzshTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="tzDhbzPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#tzDhbzSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#tzDhbzSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#tzDhbzSearchForm'),'${page.pageIndex+1}')">
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
