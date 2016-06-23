<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="uomConversionList.title"/></title>
    <meta name="menu" content="UomConversionMenu"/>
    <meta name="menu.title" content="<fmt:message key="uomConversionList.heading"/>"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>

    <form method="post" action="${ctx}/uomConversions" id="uomConversionSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#uomConversionSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editUomConversion'/>',title:'<fmt:message key="uomConversionDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeUomConversionFormOpen,afterDialogOpen:afterUomConversionFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectUomConversion) == "undefined"){
			afterSelectUomConversion = function(data){return true;};
		}
		if(typeof(beforeUomConversionFormOpen) == "undefined"){
			beforeUomConversionFormOpen = function(data){return true;};
		}
		if(typeof(afterUomConversionFormOpen) == "undefined"){
			afterUomConversionFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="uomConversionList.message"/></p>
    <div id="uomConversionSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="uomConversion.uomConversionId"/></th>
				<th><fmt:message key="uomConversion.uomIdFrom"/></th>
				<th><fmt:message key="uomConversion.conversionFactor"/></th>
				<th><fmt:message key="uomConversion.uomIdTo"/></th>
				<th><fmt:message key="uomConversion.roundingMode"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${uomConversions}" var="uomConversion">
				<tr onclick="commonTableListSelect(this,afterSelectUomConversion)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editUomConversion'/>',title:'<fmt:message key="uomConversionDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeUomConversionFormOpen,afterDialogOpen:afterUomConversionFormOpen,data:{uomConversionId:'${uomConversion.uomConversionId}',from:'list'}})">${uomConversion.uomConversionId}</a></td>
					<!-- <td>${uomConversion.uomIdFrom}</td> -->
					<td>${uomExtend[uomConversion.uomConversionId][1].description}</td>
					<td>${uomConversion.conversionFactor}</td>
					<!-- <td>${uomConversion.uomIdTo}</td> -->
					<td>${uomExtend[uomConversion.uomConversionId][2].description}</td>
					<td>${uomConversion.roundingMode}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="uomConversionPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#uomConversionSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#uomConversionSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#uomConversionSearchForm'),'${page.pageIndex+1}')">
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
