<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>
	<div class="col-sm-5">
		<div class="panel panel-default">
		  <div class="panel-heading">组织单位信息</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/partyGroupList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">单位人员信息</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/personList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		
	})
	</script>
