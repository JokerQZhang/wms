<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="facilityList.title"/></title>
    <meta name="menu" content="FacilityMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <h2><fmt:message key="facilityList.heading"/></h2>

    <form method="post" action="${ctx}/facilities" id="facilitySearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#facilitySearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="groupId">
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editFacility'/>',title:'<fmt:message key="facilityDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeFacilityFormOpen,afterDialogOpen:afterFacilityFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectFacility) == "undefined"){
			afterSelectFacility = function(data){return true;};
		}
		if(typeof(beforeFacilityFormOpen) == "undefined"){
			beforeFacilityFormOpen = function(data){return true;};
		}
		if(typeof(afterFacilityFormOpen) == "undefined"){
			afterFacilityFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="facilityList.message"/></p>
    <div id="facilitySearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="facility.facilityId"/></th>
				<th><fmt:message key="facility.facilityName"/></th>
				<th><fmt:message key="facility.facilityTypeId"/></th>
				<th><fmt:message key="facility.geoPointId"/></th>
				<th><fmt:message key="facility.ownerPartyId"/></th>
				<th><fmt:message key="facility.parentId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${facilities}" var="facility">
				<tr onclick="commonTableListSelect(this,afterSelectFacility)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editFacility'/>',title:'<fmt:message key="facilityDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeFacilityFormOpen,afterDialogOpen:afterFacilityFormOpen,data:{facilityId:'${facility.facilityId}',from:'list'}})">${facility.facilityId}</a></td>
					<td>${facility.facilityName}</td>
					<td>${facility.facilityTypeId}</td>
					<td>${facility.geoPointId}</td>
					<td>${facility.ownerPartyId}</td>
					<td>${facility.parentId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="facilityPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#facilitySearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#facilitySearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#facilitySearchForm'),'${page.pageIndex+1}')">
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
