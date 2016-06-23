<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="statusItemList.title"/></title>
    <meta name="menu" content="StatusItemMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
	<script type="text/javascript">
		if(typeof(afterSelectStatusItem) == "undefined"){
			afterSelectStatusItem = function(data){return true;};
		}
		
		if(typeof(beforeStatusItemSearchSubmit) == "undefined"){
			beforeStatusItemSearchSubmit = function(){
				return true;
			}
		}
		if(typeof(beforeStatusItemFormOpen) == "undefined"){
			beforeStatusItemFormOpen = function(data){
				var selectedStatusTypeId = $("input[name='selectedStatusTypeId']").val();
				if(selectedStatusTypeId == null || selectedStatusTypeId == ""){
					alert("请先选择状态类型！");
					return false;
				}
				return true;
			};
		}
		if(typeof(afterStatusItemFormOpen) == "undefined"){
			afterStatusItemFormOpen = function(data){
				$("input[name='statusItem.statusTypeId']").val($("input[name='selectedStatusTypeId']").val());
				return true;
			};
		}
	</script>
    <form method="post" action="${ctx}/statusItems" id="statusItemSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#statusItemSearchFormDiv'),undefined,beforeStatusItemSearchSubmit);">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input name="selectedStatusTypeId" type="hidden"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editStatusItem'/>',title:'<fmt:message key="statusItemDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeStatusItemFormOpen,afterDialogOpen:afterStatusItemFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	
    <p><fmt:message key="statusItemList.message"/></p>
    <div id="statusItemSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="statusItem.statusId"/></th>
				<th><fmt:message key="statusItem.description"/></th>
				<th><fmt:message key="statusItem.sequenceId"/></th>
				<th><fmt:message key="statusItem.statusCode"/></th>
				<th><fmt:message key="statusItem.statusTypeId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${statusItems}" var="statusItem">
				<tr onclick="commonTableListSelect(this,afterSelectStatusItem)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editStatusItem'/>',title:'<fmt:message key="statusItemDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeStatusItemFormOpen,afterDialogOpen:afterStatusItemFormOpen,data:{statusId:'${statusItem.statusId}',from:'list'}})">${statusItem.statusId}</a></td>
					
					<td>${statusItem.description}</td>
					<td>${statusItem.sequenceId}</td>
					<td>${statusItem.statusCode}</td>
					<td>${statusItem.statusTypeId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="statusItemPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#statusItemSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#statusItemSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#statusItemSearchForm'),'${page.pageIndex+1}')">
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
