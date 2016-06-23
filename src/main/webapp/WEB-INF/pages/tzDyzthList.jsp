<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="tzDyzthList.title"/></title>
	    <meta name="menu" content="TzDyzthMenu"/>
	</head>
    <form method="post" action="${ctx}/tzDyzths" id="tzDyzthSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#tzDyzthSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzDyzth'/>',title:'<fmt:message key="tzDyzthDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzDyzthFormOpen,afterDialogOpen:afterTzDyzthFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTzDyzth) == "undefined"){
			afterSelectTzDyzth = function(data){return true;};
		}
		if(typeof(beforeTzDyzthFormOpen) == "undefined"){
			beforeTzDyzthFormOpen = function(data){return true;};
		}
		if(typeof(afterTzDyzthFormOpen) == "undefined"){
			afterTzDyzthFormOpen = function(data){return true;};
		}
	</script>
    <div id="tzDyzthSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="tzDyzth.dyzthId"/></th>
				<th><fmt:message key="tzDyzth.address"/></th>
				<th><fmt:message key="tzDyzth.content"/></th>
				<th><fmt:message key="tzDyzth.createdByUser"/></th>
				<th><fmt:message key="tzDyzth.createdTime"/></th>
				<th><fmt:message key="tzDyzth.groupPartyId"/></th>
				<th><fmt:message key="tzDyzth.lastUpdatedByUser"/></th>
				<th><fmt:message key="tzDyzth.lastUpdatedTime"/></th>
				<th><fmt:message key="tzDyzth.tzDate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tzDyzths}" var="tzDyzth">
				<tr onclick="commonTableListSelect(this,afterSelectTzDyzth)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzDyzth'/>',title:'<fmt:message key="tzDyzthDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzDyzthFormOpen,afterDialogOpen:afterTzDyzthFormOpen,data:{dyzthId:'${tzDyzth.dyzthId}',from:'list'}})">${tzDyzth.dyzthId}</a></td>
					
					<td>${tzDyzth.address}</td>
					<td>${tzDyzth.content}</td>
					<td>${tzDyzth.createdByUser}</td>
					<td>${tzDyzth.createdTime}</td>
					<td>${tzDyzth.groupPartyId}</td>
					<td>${tzDyzth.lastUpdatedByUser}</td>
					<td>${tzDyzth.lastUpdatedTime}</td>
					<td>${tzDyzth.tzDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="tzDyzthPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#tzDyzthSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#tzDyzthSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#tzDyzthSearchForm'),'${page.pageIndex+1}')">
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
