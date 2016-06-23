<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="approvalProjList.title"/></title>
	    <meta name="menu" content="ApprovalProjMenu"/>
	</head>
    <form method="post" action="${ctx}/approvalProjs" id="approvalProjSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#approvalProjSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="partyId"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editApprovalProj'/>',title:'<fmt:message key="approvalProjDetail.heading"/>',width:1100,height:550,beforeDialogOpen:beforeApprovalProjFormOpen,afterDialogOpen:afterApprovalProjFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectApprovalProj) == "undefined"){
			afterSelectApprovalProj = function(data){return true;};
		}
		if(typeof(beforeApprovalProjFormOpen) == "undefined"){
			beforeApprovalProjFormOpen = function(data){return true;};
		}
		if(typeof(afterApprovalProjFormOpen) == "undefined"){
			afterApprovalProjFormOpen = function(data){return true;};
		}
	</script>
    <div id="approvalProjSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="approvalProj.approvalProjId"/></th>
				<th><fmt:message key="approvalProj.projName"/></th>
				<th><fmt:message key="approvalProj.timeLimit"/></th>
				<th><fmt:message key="approvalProj.chargeStandard"/></th>
				<th><fmt:message key="approvalProj.connectPerson"/></th>
				<th><fmt:message key="approvalProj.placeName"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${approvalProjs}" var="approvalProj">
				<tr onclick="commonTableListSelect(this,afterSelectApprovalProj)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editApprovalProj'/>',title:'<fmt:message key="approvalProjDetail.heading"/>',width:1100,height:550,beforeDialogOpen:beforeApprovalProjFormOpen,afterDialogOpen:afterApprovalProjFormOpen,data:{approvalProjId:'${approvalProj.approvalProjId}',from:'list'}})">${approvalProj.approvalProjId}</a></td>
					<td>${approvalProj.projName}</td>
					<td>${approvalProj.timeLimit}</td>
					<td>${approvalProj.chargeStandard}</td>
					<td>${approvalProj.connectPerson}:${approvalProj.connectPhone}</td>
					<td>${approvalProj.placeName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="approvalProjPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#approvalProjSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#approvalProjSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#approvalProjSearchForm'),'${page.pageIndex+1}')">
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
