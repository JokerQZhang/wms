<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>
	<div class="col-sm-12">
		<div class="panel panel-default">
		  <div class="panel-heading">行政单位审批项目<span class="text-primary"><code id="zhibuname">查询</code></span></div>
		  <div class="panel-body">
		  	<jsp:include page="/WEB-INF/pages/approvalProjList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$("#approvalProjSearchForm").submit();
	})
	</script>
