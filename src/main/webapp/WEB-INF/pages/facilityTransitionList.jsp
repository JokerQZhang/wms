<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="facilityTransitionList.title"/></title>
    <meta name="menu" content="FacilityTransitionMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <h2><fmt:message key="facilityTransitionList.heading"/></h2>

    <form method="post" action="${ctx}/facilityTransitions" id="facilityTransitionSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#facilityTransitionSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editFacilityTransition'/>',title:'<fmt:message key="facilityTransitionDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeFacilityTransitionFormOpen,afterDialogOpen:afterFacilityTransitionFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectFacilityTransition) == "undefined"){
			afterSelectFacilityTransition = function(data){return true;};
		}
		if(typeof(beforeFacilityTransitionFormOpen) == "undefined"){
			beforeFacilityTransitionFormOpen = function(data){return true;};
		}
		if(typeof(afterFacilityTransitionFormOpen) == "undefined"){
			afterFacilityTransitionFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="facilityTransitionList.message"/></p>
    <div id="facilityTransitionSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="facilityTransition.facilityTransitionId"/></th>
				<th><fmt:message key="facilityTransition.bizId"/></th>
				<th><fmt:message key="facilityTransition.bizType"/></th>
				<th><fmt:message key="facilityTransition.facilityId"/></th>
				<th><fmt:message key="facilityTransition.inOutType"/></th>
				<th><fmt:message key="facilityTransition.num"/></th>
				<th><fmt:message key="facilityTransition.productId"/></th>
				<th><fmt:message key="facilityTransition.tranDate"/></th>
				<th><fmt:message key="facilityTransition.uomId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${facilityTransitions}" var="facilityTransition">
				<tr onclick="commonTableListSelect(this,afterSelectFacilityTransition)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editFacilityTransition'/>',title:'<fmt:message key="facilityTransitionDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeFacilityTransitionFormOpen,afterDialogOpen:afterFacilityTransitionFormOpen,data:{facilityTransitionId:'${facilityTransition.facilityTransitionId}',from:'list'}})">${facilityTransition.facilityTransitionId}</a></td>
					
					<td>${facilityTransition.bizId}</td>
					<td>${facilityTransition.bizType}</td>
					<td>${facilityTransition.facilityId}</td>
					<td>${facilityTransition.inOutType}</td>
					<td>${facilityTransition.num}</td>
					<td>${facilityTransition.productId}</td>
					<td>${facilityTransition.tranDate}</td>
					<td>${facilityTransition.uomId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="facilityTransitionPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#facilityTransitionSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#facilityTransitionSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#facilityTransitionSearchForm'),'${page.pageIndex+1}')">
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
