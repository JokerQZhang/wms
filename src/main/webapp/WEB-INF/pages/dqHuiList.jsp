<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="menu.partymgn"/></title>
    <meta name="menu" content="PartyMgnMenu"/>
	</head>
	<div class="col-sm-12">
		<div class="panel panel-default">
		  <div class="panel-heading">三会一课信息</div>
		  <div class="panel-body">
		    
		 
    <form method="post" action="${ctx}/wmsHuies" id="wmsHuiSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#wmsHuiSearchFormDiv'));">
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
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editwmsHui'/>',title:'<fmt:message key="wmsHuiDetail.heading"/>',width:1024,height:550,beforeDialogOpen:beforewmsHuiFormOpen,afterDialogOpen:afterwmsHuiFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		$(function(){
			$("#wmsHuiSearchForm").submit();
		})
		if(typeof(afterSelectwmsHui) == "undefined"){
			afterSelectwmsHui = function(data){return true;};
		}
		if(typeof(beforewmsHuiFormOpen) == "undefined"){
			beforewmsHuiFormOpen = function(data){return true;};
		}
		if(typeof(afterwmsHuiFormOpen) == "undefined"){
			afterwmsHuiFormOpen = function(data){return true;};
		}
	</script>
    <div id="wmsHuiSearchFormDiv"></div>
     </div>
		</div>
	</div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="wmsHui.huiId"/></th>
				<th><fmt:message key="wmsHui.title"/></th>
				<th><fmt:message key="wmsHui.huiTime"/></th>
				<th><fmt:message key="wmsHui.huiAddress"/></th>
				<th><fmt:message key="wmsHui.huiType"/></th>
				<th><fmt:message key="wmsHui.zhibuPartyId"/></th>
				<th><fmt:message key="wmsHui.huiMaster"/></th>
				<th><fmt:message key="wmsHui.huiRecorder"/></th>
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${wmsHuies}" var="wmsHui">
				<tr onclick="commonTableListSelect(this,afterSelectwmsHui)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editwmsHui'/>',title:'<fmt:message key="wmsHuiDetail.heading"/>',width:1024,height:550,beforeDialogOpen:beforewmsHuiFormOpen,afterDialogOpen:afterwmsHuiFormOpen,data:{huiId:'${wmsHui.huiId}',from:'list'}})">${wmsHui.huiId}</a></td>
					
					<td>${wmsHui.title}</td>
					<td>${wmsHui.huiTime}</td>
					<td>${wmsHui.huiAddress}</td>
					<td>${wmsHui.huiType}</td>
					<td>${wmsHui.zhibuPartyId}</td>
					<td>${wmsHui.huiMaster}</td>
					<td>${wmsHui.huiRecorder}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="wmsHuiPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#wmsHuiSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#wmsHuiSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#wmsHuiSearchForm'),'${page.pageIndex+1}')">
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
