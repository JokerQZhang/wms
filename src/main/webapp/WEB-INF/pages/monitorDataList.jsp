<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="monitorDataList.title"/></title>
	    <meta name="menu" content="MonitorDataMenu"/>
	    <meta name="title.name" content="<fmt:message key="monitorDataList.heading"/>"/>
	</head>
    <form method="post" action="${ctx}/monitorDatas" id="monitorDataSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#monitorDataSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editMonitorData'/>',title:'<fmt:message key="monitorDataDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeMonitorDataFormOpen,afterDialogOpen:afterMonitorDataFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectMonitorData) == "undefined"){
			afterSelectMonitorData = function(data){return true;};
		}
		if(typeof(beforeMonitorDataFormOpen) == "undefined"){
			beforeMonitorDataFormOpen = function(data){return true;};
		}
		if(typeof(afterMonitorDataFormOpen) == "undefined"){
			afterMonitorDataFormOpen = function(data){return true;};
		}
	</script>
    <div id="monitorDataSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="monitorData.monitorId"/></th>
				<th><fmt:message key="monitorData.k1"/></th>
				<th><fmt:message key="monitorData.k10"/></th>
				<th><fmt:message key="monitorData.k11"/></th>
				<th><fmt:message key="monitorData.k12"/></th>
				<th><fmt:message key="monitorData.k13"/></th>
				<th><fmt:message key="monitorData.k14"/></th>
				<th><fmt:message key="monitorData.k15"/></th>
				<th><fmt:message key="monitorData.k16"/></th>
				<th><fmt:message key="monitorData.k17"/></th>
				<th><fmt:message key="monitorData.k18"/></th>
				<th><fmt:message key="monitorData.k19"/></th>
				<th><fmt:message key="monitorData.k2"/></th>
				<th><fmt:message key="monitorData.k20"/></th>
				<th><fmt:message key="monitorData.k3"/></th>
				<th><fmt:message key="monitorData.k4"/></th>
				<th><fmt:message key="monitorData.k5"/></th>
				<th><fmt:message key="monitorData.k6"/></th>
				<th><fmt:message key="monitorData.k7"/></th>
				<th><fmt:message key="monitorData.k8"/></th>
				<th><fmt:message key="monitorData.k9"/></th>
				<th><fmt:message key="monitorData.siteId"/></th>
				<th><fmt:message key="monitorData.monitorTime"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${monitorDatas}" var="monitorData">
				<tr onclick="commonTableListSelect(this,afterSelectMonitorData)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editMonitorData'/>',title:'<fmt:message key="monitorDataDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeMonitorDataFormOpen,afterDialogOpen:afterMonitorDataFormOpen,data:{monitorId:'${monitorData.monitorId}',from:'list'}})">${monitorData.monitorId}</a></td>
					
					<td>${monitorData.k1}</td>
					<td>${monitorData.k10}</td>
					<td>${monitorData.k11}</td>
					<td>${monitorData.k12}</td>
					<td>${monitorData.k13}</td>
					<td>${monitorData.k14}</td>
					<td>${monitorData.k15}</td>
					<td>${monitorData.k16}</td>
					<td>${monitorData.k17}</td>
					<td>${monitorData.k18}</td>
					<td>${monitorData.k19}</td>
					<td>${monitorData.k2}</td>
					<td>${monitorData.k20}</td>
					<td>${monitorData.k3}</td>
					<td>${monitorData.k4}</td>
					<td>${monitorData.k5}</td>
					<td>${monitorData.k6}</td>
					<td>${monitorData.k7}</td>
					<td>${monitorData.k8}</td>
					<td>${monitorData.k9}</td>
					<td>${monitorData.siteId}</td>
					<td>${monitorData.monitorTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="monitorDataPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#monitorDataSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#monitorDataSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#monitorDataSearchForm'),'${page.pageIndex+1}')">
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
