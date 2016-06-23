<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="Uom"/>
    <meta name="title.name" content="地理区域设置"/>
</head>
	<div class="col-sm-12">
		<div class="panel panel-default">
		  <div class="panel-heading">地理区域设置</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/geoList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
	</script>
