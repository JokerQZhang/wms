<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="priceList.title"/></title>
    <meta name="menu" content="PriceMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <h2><fmt:message key="priceList.heading"/></h2>

    <form method="post" action="${ctx}/prices" id="priceSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#priceSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPrice'/>',title:'<fmt:message key="priceDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePriceFormOpen,afterDialogOpen:afterPriceFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectPrice) == "undefined"){
			afterSelectPrice = function(data){return true;};
		}
		if(typeof(beforePriceFormOpen) == "undefined"){
			beforePriceFormOpen = function(data){return true;};
		}
		if(typeof(afterPriceFormOpen) == "undefined"){
			afterPriceFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="priceList.message"/></p>
    <div id="priceSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="price.priceId"/></th>
				<th><fmt:message key="price.fromDate"/></th>
				<th><fmt:message key="price.price"/></th>
				<th><fmt:message key="price.priceType"/></th>
				<th><fmt:message key="price.priceUomId"/></th>
				<th><fmt:message key="price.productId"/></th>
				<th><fmt:message key="price.thruDate"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${prices}" var="price">
				<tr onclick="commonTableListSelect(this,afterSelectPrice)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPrice'/>',title:'<fmt:message key="priceDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePriceFormOpen,afterDialogOpen:afterPriceFormOpen,data:{priceId:'${price.priceId}',from:'list'}})">${price.priceId}</a></td>
					<td>${price.fromDate}</td>
					<td>${price.price}</td>
					<td>${price.priceType}</td>
					<td>${price.priceUomId}</td>
					<td>${price.productId}</td>
					<td>${price.thruDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="pricePageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#priceSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#priceSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#priceSearchForm'),'${page.pageIndex+1}')">
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
