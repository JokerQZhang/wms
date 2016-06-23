<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
    <div id="cpChargeSearchFormDiv"></div>
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th><fmt:message key="cpCharge.cpChargeId"/></th>
				<th><fmt:message key="cpCharge.accountType"/></th>
				<th><fmt:message key="cpCharge.balance"/></th>
				<th><fmt:message key="cpCharge.cpTitle"/></th>
				<th><fmt:message key="cpCharge.ioType"/></th>
				<th><fmt:message key="cpCharge.memo"/></th>
				<th><fmt:message key="cpCharge.operPeople"/></th>
				<th><fmt:message key="cpCharge.operType"/></th>
				<th><fmt:message key="cpCharge.partyId"/></th>
				<th><fmt:message key="cpCharge.relateAccountType"/></th>
				<th><fmt:message key="cpCharge.relatePartyId"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cpCharges}" var="cpCharge">
				<tr onclick="commonTableListSelect(this,afterSelectCpCharge)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editCpCharge'/>',title:'<fmt:message key="cpChargeDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeCpChargeFormOpen,afterDialogOpen:afterCpChargeFormOpen,data:{cpChargeId:'${cpCharge.cpChargeId}',from:'list'}})">${cpCharge.cpChargeId}</a></td>
					<td>${cpCharge.accountType}</td>
					<td>${cpCharge.balance}</td>
					<td>${cpCharge.cpTitle}</td>
					<td>${cpCharge.ioType}</td>
					<td>${cpCharge.memo}</td>
					<td>${cpCharge.operPeople}</td>
					<td>${cpCharge.operType}</td>
					<td>${cpCharge.partyId}</td>
					<td>${cpCharge.relateAccountType}</td>
					<td>${cpCharge.relatePartyId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="cpChargePageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#cpChargeSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#cpChargeSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#cpChargeSearchForm'),'${page.pageIndex+1}')">
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
