<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="enumerationList.title"/></title>
    <meta name="menu" content="EnumerationMenu"/>
</head>
<%
if(request.getAttribute("showForm") == null){
%>
    <form method="get" action="${ctx}/enumerations" id="enumerationSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#enumerationSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="enumTypeId"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editEnumeration'/>',beforeDialogOpen:beforeEnumerationFormOpen,afterDialogOpen:afterEnumerationFormOpen,width:600,height:385,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectEnumeration) == "undefined"){
			afterSelectEnumeration = function(data){};
		}
		if(typeof(afterEnumerationFormOpen) == "undefined"){
			afterEnumerationFormOpen = function(){
				$("#enumerationForm").find("input[name='enumTypeId']").val($("#enumerationSearchForm").find("input[name='enumTypeId']").val());
			};
		}
		if(typeof(beforeEnumerationFormOpen) == "undefined"){
			beforeEnumerationFormOpen = function(){
				var enumerationTypeId = $("#enumerationSearchForm").find("input[name='enumTypeId']").val();
				if(enumerationTypeId==null || enumerationTypeId==""){
					alert("数据字典类型为空，请先选择数据字典类型，然后再修改数据字典信息。");
					return false;
				}else{
					return true;
				}
			};
		}
	</script>
    <p><fmt:message key="enumerationList.message"/></p>
    <div id="enumerationSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="enumeration.enumId"/></th>
				<th><fmt:message key="enumeration.description"/></th>
				<th><fmt:message key="enumeration.enumCode"/></th>
				<th><fmt:message key="enumeration.sequenceId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${enumerations}" var="enumeration">
				<tr onclick="commonTableListSelect(this,afterSelectEnumeration)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editEnumeration'/>',beforeDialogOpen:beforeEnumerationFormOpen,afterDialogOpen:afterEnumerationFormOpen,width:600,height:385,data:{enumId:'${enumeration.enumId}',from:'list'}})">${enumeration.enumId}</a></td>
					<td>${enumeration.description}</td>
					<td>${enumeration.enumCode}</td>
					<td>${enumeration.sequenceId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="enumerationPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#enumerationSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#enumerationSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#enumerationSearchForm'),'${page.pageIndex+1}')">
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
