<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="geoList.title"/></title>
	    <meta name="menu" content=PartyGroupMenu/>
	    <meta name="title.name" content="<fmt:message key="geoList.heading"/>"/>
	</head>
    <form method="post" action="${ctx}/geoes" id="geoSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#geoSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editGeo'/>',title:'<fmt:message key="geoDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeGeoFormOpen,afterDialogOpen:afterGeoFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectGeo) == "undefined"){
			afterSelectGeo = function(data){
				currentGeoId = data[0];
				var pointstr = data[3];
				var pointopt = pointstr.split(",");
				if(pointopt.length==2){
					var spoint = new BMap.Point(parseFloat(pointopt[0]),parseFloat(pointopt[1]));
					map.panTo(spoint);
					marker.setPosition(spoint);
				}
				return true;
			};
		}
		if(typeof(beforeGeoFormOpen) == "undefined"){
			beforeGeoFormOpen = function(data){return true;};
		}
		if(typeof(afterGeoFormOpen) == "undefined"){
			afterGeoFormOpen = function(data){return true;};
		}
	</script>
    <div id="geoSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="geo.geoId"/></th>
				<th><fmt:message key="geo.geoName"/></th>
				<th><fmt:message key="geo.geoNamePinyin"/></th>
				<th><fmt:message key="geo.geoPoint"/></th>
				<th><fmt:message key="geo.geoType"/></th>
				<th><fmt:message key="geo.parentGeoId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${geoes}" var="geo">
				<tr onclick="commonTableListSelect(this,afterSelectGeo)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editGeo'/>',title:'<fmt:message key="geoDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeGeoFormOpen,afterDialogOpen:afterGeoFormOpen,data:{geoId:'${geo.geoId}',from:'list'}})">${geo.geoId}</a></td>
					
					<td>${geo.geoName}</td>
					<td>${geo.geoNamePinyin}</td>
					<td>${geo.geoPoint}</td>
					<td>${geo.geoType}</td>
					<td>${geo.parentGeoId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="geoPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#geoSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#geoSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#geoSearchForm'),'${page.pageIndex+1}')">
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
