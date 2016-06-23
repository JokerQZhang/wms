<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="alarmSetList.title"/></title>
	    <meta name="menu" content="AlarmSetMenu"/>
	    <meta name="title.name" content="<fmt:message key="alarmSetList.heading"/>"/>
	</head>
    <form method="post" action="${ctx}/alarmSets" id="alarmSetSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#alarmSetSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editAlarmSet'/>',title:'<fmt:message key="alarmSetDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeAlarmSetFormOpen,afterDialogOpen:afterAlarmSetFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectAlarmSet) == "undefined"){
			afterSelectAlarmSet = function(data){return true;};
		}
		if(typeof(beforeAlarmSetFormOpen) == "undefined"){
			beforeAlarmSetFormOpen = function(data){return true;};
		}
		if(typeof(afterAlarmSetFormOpen) == "undefined"){
			afterAlarmSetFormOpen = function(data){return true;};
		}
	</script>
    <div id="alarmSetSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="alarmSet.alarmSetId"/></th>
				<th><fmt:message key="alarmSet.alarmLevel"/></th>
				<th><fmt:message key="alarmSet.kpiId"/></th>
				<th><fmt:message key="alarmSet.kpiName"/></th>
				<th><fmt:message key="alarmSet.maxValue"/></th>
				<th><fmt:message key="alarmSet.memo"/></th>
				<th><fmt:message key="alarmSet.minValue"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${alarmSets}" var="alarmSet">
				<tr onclick="commonTableListSelect(this,afterSelectAlarmSet)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editAlarmSet'/>',title:'<fmt:message key="alarmSetDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeAlarmSetFormOpen,afterDialogOpen:afterAlarmSetFormOpen,data:{alarmSetId:'${alarmSet.alarmSetId}',from:'list'}})">${alarmSet.alarmSetId}</a></td>
					
					<td>${alarmSet.alarmLevel}</td>
					<td>${alarmSet.kpiId}</td>
					<td>${alarmSet.kpiName}</td>
					<td>${alarmSet.maxValue}</td>
					<td>${alarmSet.memo}</td>
					<td>${alarmSet.minValue}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="alarmSetPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#alarmSetSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#alarmSetSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#alarmSetSearchForm'),'${page.pageIndex+1}')">
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
