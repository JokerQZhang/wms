<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="petitionList.title"/></title>
	    <meta name="menu" content="PetitionMenu"/>
	</head>
	<div class="col-sm-12">
		<div class="panel panel-default">
		  <div class="panel-heading">
		  	<c:if test="${type == 'a'}">受理信访举报信息</c:if>
		  	<c:if test="${type == 'b'}">待审核信访举报信息</c:if>
		  	<c:if test="${type == 'c'}">待处理信访举报信息</c:if>
		  	<c:if test="${type == 'd'}">待办结信访举报信息</c:if>
		  	<c:if test="${type == 'e'}">查询信访举报信息</c:if>
		  </div>
		  <div class="panel-body">
    <form method="post" action="${ctx}/petitions" id="petitionSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#petitionSearchFormDiv'));">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
    	<input type="hidden" name="type" value="${type}"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <c:if test="${type == 'a'}">
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPetition?type='/>${type}',title:'<fmt:message key="petitionDetail.heading"/>',width:1100,height:500,beforeDialogOpen:beforePetitionFormOpen,afterDialogOpen:afterPetitionFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
		        </c:if>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
		if(typeof(afterSelectPetition) == "undefined"){
			afterSelectPetition = function(data){return true;};
		}
		if(typeof(beforePetitionFormOpen) == "undefined"){
			beforePetitionFormOpen = function(data){return true;};
		}
		if(typeof(afterPetitionFormOpen) == "undefined"){
			afterPetitionFormOpen = function(data){return true;};
		}
		$(function(){
			$("#petitionSearchForm").submit();
		})
	</script>
    <div id="petitionSearchFormDiv"></div>
    </div>
    </div>
    </div>
    
<%
}else{
%>
	<table class="table table-condensed table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th rowspan="2"><fmt:message key="petition.petitionId"/></th>
				<th colspan="3">被举报人信息</th>
				<th colspan="5">举报人信息</th>
				<th colspan="5">信访处理信息</th>
			</tr>
			<tr>
				<th>姓名</th>
				<th>工作单位</th>
				<th>职务</th>
				<th>姓名</th>
				<th>联系方式</th>
				<th>人数</th>
				<th>问题类型</th>
				<th>举报方式</th>
				<th>受理人</th>
				<th>受理时间</th>
				<th>要求结案时间</th>
				<th>责任部门</th>
				<th>处理状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${petitions}" var="petition">
				<tr onclick="commonTableListSelect(this,afterSelectPetition)">
					<td><a class="btn btn-info btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editPetition?type='/>${type}',title:'<fmt:message key="petitionDetail.heading"/>',width:1100,height:500,beforeDialogOpen:beforePetitionFormOpen,afterDialogOpen:afterPetitionFormOpen,data:{petitionId:'${petition.petitionId}',from:'list'}})">${petition.petitionId}</a></td>
					<td>${petition.reportedPeople}</td>
					<td>${petition.reportedDep}</td>
					<td>${petition.reportedStatus}</td>
					<td>${petition.reportPeople}</td>
					<td>${petition.reportPConnect}</td>
					<td>${petition.reportPNum}</td>
					<td>${problemTypeMap[petition.reportType].description}</td>
					<td>${methodMap[petition.reportMethod].description}</td>
					<c:set var="acctime" value="${petition.acceptTime}" scope="request"/>
					<c:set var="eetime" value="${petition.expectEndTime}" scope="request"/>
					<td>${petition.acceptName}</td>
					<td><%=com.joker.wms.util.MyDateUtil.getFormatedString("yyyy-MM-dd", (java.util.Date)request.getAttribute("acctime"))%></td>
					<td><%=com.joker.wms.util.MyDateUtil.getFormatedString("yyyy-MM-dd", (java.util.Date)request.getAttribute("eetime"))%></td>
					<td>${groupMap[petition.processPartyId].groupName}</td>
					<td>${statusMap[petition.statusId].description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.allRecordNum > page.pageSize}">
		<nav id="petitionPageNav">
		  <ul class="pagination" style="margin-top:0px;">
		    <li>
		      <a href="#" aria-label="Previous" onclick="formPage($('#petitionSearchForm'),'${page.pageIndex-1}')">
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
				<li ${i==page.pageIndex?"class='active'":""}><a href="#" onclick="formPage($('#petitionSearchForm'),'${i}')">${i}</a></li>
			</c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next" onclick="formPage($('#petitionSearchForm'),'${page.pageIndex+1}')">
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
