<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="partyGroupList.title"/></title>
    <meta name="menu" content="PartyGroupMenu"/>
</head>

<%
if(request.getAttribute("showForm") == null){
%>
    <h2><fmt:message key="partyGroupList.heading"/></h2>
	<input type="hidden" name="selectedGroupId"/>
    <form method="post" action="${ctx}/partyGroupCustoms" id="customersearch" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#customerlistdiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="vendorId" id="vendorId">
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/dialog/addcustom'/>',title:'添加客户',width:360,height:240,afterDialogOpen:afteraddcustom,data:{vendorId:$('#vendorId').val()}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
    <script type="text/javascript">
		function afteraddcustom(){
			$("#customerlist").combobox();
			$("#customerlist").next().find("input").focus().select();
			$(".ui-autocomplete").attr("style",$(".ui-autocomplete").attr("style") + "z-index:103;");
		}
	</script>
    <p><fmt:message key="partyGroupList.message"/></p>
    <div id="customerlistdiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="partyGroup.pgId"/></th>
				<th><fmt:message key="partyGroup.groupName"/></th>
				<th><fmt:message key="partyGroup.address"/></th>
				<th><fmt:message key="partyGroup.numEmployees"/></th>
				<th><fmt:message key="partyGroup.phone"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${partyGroups}" var="partyGroup">
				<tr>
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPartyGroup'/>',title:'<fmt:message key="partyGroupDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforePartyGroupFormOpen,afterDialogOpen:afterPartyGroupFormOpen,data:{pgId:'${partyGroup.pgId}',from:'list'}})">${partyGroup.pgId}</a></td>
					<td>${partyGroup.groupName}</td>
					<td>${partyGroup.address}</td>
					<td>${partyGroup.numEmployees}</td>
					<td>${partyGroup.phone}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="partyGroupPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#partyGroupSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#partyGroupSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#partyGroupSearchForm'),'${page.pageIndex+1}')">
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
