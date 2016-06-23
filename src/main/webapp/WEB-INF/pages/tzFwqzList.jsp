<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="tzFwqzList.title"/></title>
	    <meta name="menu" content="TzFwqzMenu"/>
	</head>
    <form method="post" action="${ctx}/tzFwqzs" id="tzFwqzSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#tzFwqzSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzFwqz'/>',title:'<fmt:message key="tzFwqzDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzFwqzFormOpen,afterDialogOpen:afterTzFwqzFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTzFwqz) == "undefined"){
			afterSelectTzFwqz = function(data){return true;};
		}
		if(typeof(beforeTzFwqzFormOpen) == "undefined"){
			beforeTzFwqzFormOpen = function(data){return true;};
		}
		if(typeof(afterTzFwqzFormOpen) == "undefined"){
			afterTzFwqzFormOpen = function(data){return true;};
		}
	</script>
    <div id="tzFwqzSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="tzFwqz.fwqzId"/></th>
				<th><fmt:message key="tzFwqz.bmfuxxIsShow"/></th>
				<th><fmt:message key="tzFwqz.bmfuxxShowType"/></th>
				<th><fmt:message key="tzFwqz.createdByUser"/></th>
				<th><fmt:message key="tzFwqz.createdTime"/></th>
				<th><fmt:message key="tzFwqz.groupPartyId"/></th>
				<th><fmt:message key="tzFwqz.jjsjknNum"/></th>
				<th><fmt:message key="tzFwqz.jjsjknProblem"/></th>
				<th><fmt:message key="tzFwqz.jsjcssDtl"/></th>
				<th><fmt:message key="tzFwqz.jsjcssNum"/></th>
				<th><fmt:message key="tzFwqz.lastUpdatedByUser"/></th>
				<th><fmt:message key="tzFwqz.lastUpdatedTime"/></th>
				<th><fmt:message key="tzFwqz.tzDate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tzFwqzs}" var="tzFwqz">
				<tr onclick="commonTableListSelect(this,afterSelectTzFwqz)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTzFwqz'/>',title:'<fmt:message key="tzFwqzDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTzFwqzFormOpen,afterDialogOpen:afterTzFwqzFormOpen,data:{fwqzId:'${tzFwqz.fwqzId}',from:'list'}})">${tzFwqz.fwqzId}</a></td>
					
					<td>${tzFwqz.bmfuxxIsShow}</td>
					<td>${tzFwqz.bmfuxxShowType}</td>
					<td>${tzFwqz.createdByUser}</td>
					<td>${tzFwqz.createdTime}</td>
					<td>${tzFwqz.groupPartyId}</td>
					<td>${tzFwqz.jjsjknNum}</td>
					<td>${tzFwqz.jjsjknProblem}</td>
					<td>${tzFwqz.jsjcssDtl}</td>
					<td>${tzFwqz.jsjcssNum}</td>
					<td>${tzFwqz.lastUpdatedByUser}</td>
					<td>${tzFwqz.lastUpdatedTime}</td>
					<td>${tzFwqz.tzDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="tzFwqzPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#tzFwqzSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#tzFwqzSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#tzFwqzSearchForm'),'${page.pageIndex+1}')">
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
