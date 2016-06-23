<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="partyRelationshipList.title"/></title>
    <meta name="menu" content="PartyRelationshipMenu"/>
    <meta name="title.name" content="<fmt:message key="partyRelationshipList.heading"/>"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>

    <form method="post" action="${ctx}/partyRelationships" id="partyRelationshipSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#partyRelationshipSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPartyRelationship'/>',title:'<fmt:message key="partyRelationshipDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePartyRelationshipFormOpen,afterDialogOpen:afterPartyRelationshipFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectPartyRelationship) == "undefined"){
			afterSelectPartyRelationship = function(data){return true;};
		}
		if(typeof(beforePartyRelationshipFormOpen) == "undefined"){
			beforePartyRelationshipFormOpen = function(data){return true;};
		}
		if(typeof(afterPartyRelationshipFormOpen) == "undefined"){
			afterPartyRelationshipFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="partyRelationshipList.message"/></p>
    <div id="partyRelationshipSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="partyRelationship.partyRelationshipId"/></th>
				<th><fmt:message key="partyRelationship.createdByUser"/></th>
				<th><fmt:message key="partyRelationship.createdTime"/></th>
				<th><fmt:message key="partyRelationship.fromDate"/></th>
				<th><fmt:message key="partyRelationship.lastUpdatedByUser"/></th>
				<th><fmt:message key="partyRelationship.lastUpdatedTime"/></th>
				<th><fmt:message key="partyRelationship.partyIdFrom"/></th>
				<th><fmt:message key="partyRelationship.partyIdTo"/></th>
				<th><fmt:message key="partyRelationship.partyRelationshipTypeId"/></th>
				<th><fmt:message key="partyRelationship.roleTypeIdFrom"/></th>
				<th><fmt:message key="partyRelationship.roleTypeIdTo"/></th>
				<th><fmt:message key="partyRelationship.statusId"/></th>
				<th><fmt:message key="partyRelationship.thruDate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${partyRelationships}" var="partyRelationship">
				<tr onclick="commonTableListSelect(this,afterSelectPartyRelationship)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPartyRelationship'/>',title:'<fmt:message key="partyRelationshipDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePartyRelationshipFormOpen,afterDialogOpen:afterPartyRelationshipFormOpen,data:{partyRelationshipId:'${partyRelationship.partyRelationshipId}',from:'list'}})">${partyRelationship.partyRelationshipId}</a></td>
					
					<td>${partyRelationship.createdByUser}</td>
					<td>${partyRelationship.createdTime}</td>
					<td>${partyRelationship.fromDate}</td>
					<td>${partyRelationship.lastUpdatedByUser}</td>
					<td>${partyRelationship.lastUpdatedTime}</td>
					<td>${partyRelationship.partyIdFrom}</td>
					<td>${partyRelationship.partyIdTo}</td>
					<td>${partyRelationship.partyRelationshipTypeId}</td>
					<td>${partyRelationship.roleTypeIdFrom}</td>
					<td>${partyRelationship.roleTypeIdTo}</td>
					<td>${partyRelationship.statusId}</td>
					<td>${partyRelationship.thruDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="partyRelationshipPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#partyRelationshipSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#partyRelationshipSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#partyRelationshipSearchForm'),'${page.pageIndex+1}')">
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
