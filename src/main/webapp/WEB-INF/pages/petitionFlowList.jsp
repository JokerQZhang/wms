<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="petitionFlowList.title"/></title>
	    <meta name="menu" content="PetitionFlowMenu"/>
	</head>
    <form method="post" action="${ctx}/petitionFlows" id="petitionFlowSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#petitionFlowSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPetitionFlow'/>',title:'<fmt:message key="petitionFlowDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePetitionFlowFormOpen,afterDialogOpen:afterPetitionFlowFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectPetitionFlow) == "undefined"){
			afterSelectPetitionFlow = function(data){return true;};
		}
		if(typeof(beforePetitionFlowFormOpen) == "undefined"){
			beforePetitionFlowFormOpen = function(data){return true;};
		}
		if(typeof(afterPetitionFlowFormOpen) == "undefined"){
			afterPetitionFlowFormOpen = function(data){return true;};
		}
	</script>
    <div id="petitionFlowSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="petitionFlow.petitionFlowId"/></th>
				<th><fmt:message key="petitionFlow.createdByUser"/></th>
				<th><fmt:message key="petitionFlow.createdTime"/></th>
				<th><fmt:message key="petitionFlow.memo"/></th>
				<th><fmt:message key="petitionFlow.partyId"/></th>
				<th><fmt:message key="petitionFlow.petitionId"/></th>
				<th><fmt:message key="petitionFlow.svcId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${petitionFlows}" var="petitionFlow">
				<tr onclick="commonTableListSelect(this,afterSelectPetitionFlow)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPetitionFlow'/>',title:'<fmt:message key="petitionFlowDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePetitionFlowFormOpen,afterDialogOpen:afterPetitionFlowFormOpen,data:{petitionFlowId:'${petitionFlow.petitionFlowId}',from:'list'}})">${petitionFlow.petitionFlowId}</a></td>
					
					<td>${petitionFlow.createdByUser}</td>
					<td>${petitionFlow.createdTime}</td>
					<td>${petitionFlow.memo}</td>
					<td>${petitionFlow.partyId}</td>
					<td>${petitionFlow.petitionId}</td>
					<td>${petitionFlow.svcId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="petitionFlowPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#petitionFlowSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#petitionFlowSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#petitionFlowSearchForm'),'${page.pageIndex+1}')">
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
