<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shipCarList.title"/></title>
    <meta name="menu" content="ShipCarMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <h2><fmt:message key="shipCarList.heading"/></h2>

    <form method="post" action="${ctx}/shipCars" id="shipCarSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#shipCarSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editShipCar'/>',title:'<fmt:message key="shipCarDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeShipCarFormOpen,afterDialogOpen:afterShipCarFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectShipCar) == "undefined"){
			afterSelectShipCar = function(data){return true;};
		}
		if(typeof(beforeShipCarFormOpen) == "undefined"){
			beforeShipCarFormOpen = function(data){return true;};
		}
		if(typeof(afterShipCarFormOpen) == "undefined"){
			afterShipCarFormOpen = function(data){return true;};
		}
	</script>
    <p><fmt:message key="shipCarList.message"/></p>
    <div id="shipCarSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="shipCar.shipCarId"/></th>
				<th><fmt:message key="shipCar.carCardId"/></th>
				<th><fmt:message key="shipCar.conName"/></th>
				<th><fmt:message key="shipCar.conPhone"/></th>
				<th><fmt:message key="shipCar.loadWeight"/></th>
				<th><fmt:message key="shipCar.typeName"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shipCars}" var="shipCar">
				<tr onclick="commonTableListSelect(this,afterSelectShipCar)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editShipCar'/>',title:'<fmt:message key="shipCarDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeShipCarFormOpen,afterDialogOpen:afterShipCarFormOpen,data:{shipCarId:'${shipCar.shipCarId}',from:'list'}})">${shipCar.shipCarId}</a></td>
					
					<td>${shipCar.carCardId}</td>
					<td>${shipCar.conName}</td>
					<td>${shipCar.conPhone}</td>
					<td>${shipCar.loadWeight}</td>
					<td>${shipCar.typeName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="shipCarPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#shipCarSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#shipCarSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#shipCarSearchForm'),'${page.pageIndex+1}')">
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
