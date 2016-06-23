<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="uomList.title"/></title>
    <meta name="menu" content="UomMenu"/>
    <meta name="menu.title" content="<fmt:message key="uomList.heading"/>"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>

    <form method="post" action="${ctx}/uoms" id="uomSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#uomSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="uomTypeId"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editUom'/>',title:'<fmt:message key="uomDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeUomFormOpen,afterDialogOpen:afterUomFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectUom) == "undefined"){
			afterSelectUom = function(data){return true;};
		}
		if(typeof(beforeUomFormOpen) == "undefined"){
			beforeUomFormOpen = function(data){return true;};
		}
		if(typeof(afterUomFormOpen) == "undefined"){
			afterUomFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="uomList.message"/></p>
    <div id="uomSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="uom.uomId"/></th>
				<th><fmt:message key="uom.abbreviation"/></th>
				<th><fmt:message key="uom.description"/></th>
				<th><fmt:message key="uom.sequenceId"/></th>
				<th><fmt:message key="uom.uomTypeId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${uoms}" var="uom">
				<tr onclick="commonTableListSelect(this,afterSelectUom)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editUom'/>',title:'<fmt:message key="uomDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeUomFormOpen,afterDialogOpen:afterUomFormOpen,data:{uomId:'${uom.uomId}',from:'list'}})">${uom.uomId}</a></td>
					<td>${uom.abbreviation}</td>
					<td>${uom.description}</td>
					<td>${uom.sequenceId}</td>
					<td>${uom.uomTypeId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="uomPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#uomSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#uomSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#uomSearchForm'),'${page.pageIndex+1}')">
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
