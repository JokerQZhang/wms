<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="salePlanList.title"/></title>
    <meta name="menu" content="SalePlanMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>

    <form method="post" action="${ctx}/salePlans" id="salePlanSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#salePlanSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
	    <div id="search" class="text-right" style="margin-top:0px;">
	        <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
                <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editSalePlan'/>',title:'<fmt:message key="salePlanDetail.heading"/>',width:594,height:406,beforeDialogOpen:beforeSalePlanFormOpen,afterDialogOpen:afterSalePlanFormOpen,data:{method:'Add',from:'list'}})" >
	           	 <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectSalePlan) == "undefined"){
			afterSelectSalePlan = function(data){return true;};
		}
		if(typeof(beforeSalePlanFormOpen) == "undefined"){
			beforeSalePlanFormOpen = function(data){return true;};
		}
		if(typeof(afterSalePlanFormOpen) == "undefined"){
			afterSalePlanFormOpen = function(data){return true;};
		}
	</script>
	<hr>
    <div id="salePlanSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="salePlan.salePlanId"/></th>
				<th><fmt:message key="salePlan.date"/></th>
				<th><fmt:message key="salePlan.statusId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${salePlans}" var="salePlan">
				<tr onclick="commonTableListSelect(this,afterSelectSalePlan)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editSalePlan'/>',title:'<fmt:message key="salePlanDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeSalePlanFormOpen,afterDialogOpen:afterSalePlanFormOpen,data:{salePlanId:'${salePlan.salePlanId}',from:'list'}})">${salePlan.salePlanId}</a></td>
					
					<td>${salePlan.date}</td>
					<td>${salePlan.statusId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="salePlanPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#salePlanSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#salePlanSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#salePlanSearchForm'),'${page.pageIndex+1}')">
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
