<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="partyRelationshipTypeList.title"/></title>
    <meta name="menu" content="PartyRelationshipTypeMenu"/>
    <meta name="title.name" content="<fmt:message key="partyRelationshipTypeList.heading"/>"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>

    <form method="post" action="${ctx}/partyRelationshipTypes" id="partyRelationshipTypeSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#partyRelationshipTypeSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPartyRelationshipType'/>',title:'<fmt:message key="partyRelationshipTypeDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePartyRelationshipTypeFormOpen,afterDialogOpen:afterPartyRelationshipTypeFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectPartyRelationshipType) == "undefined"){
			afterSelectPartyRelationshipType = function(data){return true;};
		}
		if(typeof(beforePartyRelationshipTypeFormOpen) == "undefined"){
			beforePartyRelationshipTypeFormOpen = function(data){return true;};
		}
		if(typeof(afterPartyRelationshipTypeFormOpen) == "undefined"){
			afterPartyRelationshipTypeFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="partyRelationshipTypeList.message"/></p>
    <div id="partyRelationshipTypeSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="partyRelationshipType.partyRelationshipTypeId"/></th>
				<th><fmt:message key="partyRelationshipType.description"/></th>
				<th><fmt:message key="partyRelationshipType.hasTable"/></th>
				<th><fmt:message key="partyRelationshipType.parentId"/></th>
				<th><fmt:message key="partyRelationshipType.partyRelationshipName"/></th>
				<th><fmt:message key="partyRelationshipType.roleTypeValidFrom"/></th>
				<th><fmt:message key="partyRelationshipType.roleTypeValidTo"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${partyRelationshipTypes}" var="partyRelationshipType">
				<tr onclick="commonTableListSelect(this,afterSelectPartyRelationshipType)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPartyRelationshipType'/>',title:'<fmt:message key="partyRelationshipTypeDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePartyRelationshipTypeFormOpen,afterDialogOpen:afterPartyRelationshipTypeFormOpen,data:{partyRelationshipTypeId:'${partyRelationshipType.partyRelationshipTypeId}',from:'list'}})">${partyRelationshipType.partyRelationshipTypeId}</a></td>
					
					<td>${partyRelationshipType.description}</td>
					<td>${partyRelationshipType.hasTable}</td>
					<td>${partyRelationshipType.parentId}</td>
					<td>${partyRelationshipType.partyRelationshipName}</td>
					<td>${partyRelationshipType.roleTypeValidFrom}</td>
					<td>${partyRelationshipType.roleTypeValidTo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="partyRelationshipTypePageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#partyRelationshipTypeSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#partyRelationshipTypeSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#partyRelationshipTypeSearchForm'),'${page.pageIndex+1}')">
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
