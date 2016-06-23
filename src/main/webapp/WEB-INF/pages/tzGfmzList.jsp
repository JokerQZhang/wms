<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="tzGfmzList.title"/></title>
	    <meta name="menu" content="TzGfmzMenu"/>
	</head>
    <form method="post" action="${ctx}/tzGfmzs" id="tzGfmzSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#tzGfmzSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzGfmz'/>',title:'<fmt:message key="tzGfmzDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzGfmzFormOpen,afterDialogOpen:afterTzGfmzFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTzGfmz) == "undefined"){
			afterSelectTzGfmz = function(data){return true;};
		}
		if(typeof(beforeTzGfmzFormOpen) == "undefined"){
			beforeTzGfmzFormOpen = function(data){return true;};
		}
		if(typeof(afterTzGfmzFormOpen) == "undefined"){
			afterTzGfmzFormOpen = function(data){return true;};
		}
	</script>
    <div id="tzGfmzSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="tzGfmz.gfmzId"/></th>
				<th><fmt:message key="tzGfmz.createdByUser"/></th>
				<th><fmt:message key="tzGfmz.createdTime"/></th>
				<th><fmt:message key="tzGfmz.dyzhfwzDtl"/></th>
				<th><fmt:message key="tzGfmz.dyzhfwzTimes"/></th>
				<th><fmt:message key="tzGfmz.groupPartyId"/></th>
				<th><fmt:message key="tzGfmz.lastUpdatedByUser"/></th>
				<th><fmt:message key="tzGfmz.lastUpdatedTime"/></th>
				<th><fmt:message key="tzGfmz.sylhgkDtl"/></th>
				<th><fmt:message key="tzGfmz.sylhgkTimes"/></th>
				<th><fmt:message key="tzGfmz.szgsNum"/></th>
				<th><fmt:message key="tzGfmz.szgsTime"/></th>
				<th><fmt:message key="tzGfmz.tzDate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tzGfmzs}" var="tzGfmz">
				<tr onclick="commonTableListSelect(this,afterSelectTzGfmz)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzGfmz'/>',title:'<fmt:message key="tzGfmzDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzGfmzFormOpen,afterDialogOpen:afterTzGfmzFormOpen,data:{gfmzId:'${tzGfmz.gfmzId}',from:'list'}})">${tzGfmz.gfmzId}</a></td>
					
					<td>${tzGfmz.createdByUser}</td>
					<td>${tzGfmz.createdTime}</td>
					<td>${tzGfmz.dyzhfwzDtl}</td>
					<td>${tzGfmz.dyzhfwzTimes}</td>
					<td>${tzGfmz.groupPartyId}</td>
					<td>${tzGfmz.lastUpdatedByUser}</td>
					<td>${tzGfmz.lastUpdatedTime}</td>
					<td>${tzGfmz.sylhgkDtl}</td>
					<td>${tzGfmz.sylhgkTimes}</td>
					<td>${tzGfmz.szgsNum}</td>
					<td>${tzGfmz.szgsTime}</td>
					<td>${tzGfmz.tzDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="tzGfmzPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#tzGfmzSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#tzGfmzSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#tzGfmzSearchForm'),'${page.pageIndex+1}')">
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
