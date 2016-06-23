<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="tbCarePeopleList.title"/></title>
	    <meta name="menu" content="TbCarePeopleMenu"/>
	</head>

    <form method="post" action="${ctx}/tbCarePeoples" id="tbCarePeopleSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#tbCarePeopleSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTbCarePeople'/>',title:'<fmt:message key="tbCarePeopleDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTbCarePeopleFormOpen,afterDialogOpen:afterTbCarePeopleFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectTbCarePeople) == "undefined"){
			afterSelectTbCarePeople = function(data){return true;};
		}
		if(typeof(beforeTbCarePeopleFormOpen) == "undefined"){
			beforeTbCarePeopleFormOpen = function(data){return true;};
		}
		if(typeof(afterTbCarePeopleFormOpen) == "undefined"){
			afterTbCarePeopleFormOpen = function(data){return true;};
		}
	</script>
    <div id="tbCarePeopleSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="tbCarePeople.peopleId"/></th>
				<th><fmt:message key="tbCarePeople.peopleName"/></th>
				<th><fmt:message key="tbCarePeople.gender"/></th>
				<th><fmt:message key="tbCarePeople.birthday"/></th>
				<th><fmt:message key="tbCarePeople.nation"/></th>
				<th><fmt:message key="tbCarePeople.departmentId"/></th>
				<th><fmt:message key="tbCarePeople.address"/></th>
				<th><fmt:message key="tbCarePeople.idCard"/></th>
				<th><fmt:message key="tbCarePeople.job"/></th>
				
				<th><fmt:message key="tbCarePeople.partyStatus"/></th>
				<th><fmt:message key="tbCarePeople.partyType"/></th>
				<th><fmt:message key="tbCarePeople.pensionInsurance"/></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tbCarePeoples}" var="tbCarePeople">
				<tr onclick="commonTableListSelect(this,afterSelectTbCarePeople)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editTbCarePeople'/>',title:'<fmt:message key="tbCarePeopleDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeTbCarePeopleFormOpen,afterDialogOpen:afterTbCarePeopleFormOpen,data:{peopleId:'${tbCarePeople.peopleId}',from:'list'}})">${tbCarePeople.peopleId}</a></td>
					<td>${tbCarePeople.peopleName}</td>
					<td>${tbCarePeople.gender}</td>
					<td>${tbCarePeople.birthday}</td>
					<td>${tbCarePeople.nation}</td>
					<td>${tbCarePeople.departmentId}</td>
					<td>${tbCarePeople.address}</td>
					<td>${tbCarePeople.idCard}</td>
					<td>${tbCarePeople.job}</td>
					<td>${tbCarePeople.partyStatus}</td>
					<td>${tbCarePeople.partyType}</td>
					<td>${tbCarePeople.pensionInsurance}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="tbCarePeoplePageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#tbCarePeopleSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#tbCarePeopleSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#tbCarePeopleSearchForm'),'${page.pageIndex+1}')">
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
