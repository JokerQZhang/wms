<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="alarmSetList.title"/></title>
    <meta name="menu" content="MonitorMenu"/>
    <meta name="title.name" content="预警设置"/>
</head>
<div class="col-sm-12">
	<div class="panel panel-default">
	  <div class="panel-heading">预警设置列表</div>
	  <div class="panel-body">
	    <jsp:include page="/WEB-INF/pages/alarmSetList.jsp" flush="true"></jsp:include>
	  </div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("#alarmSetSearchForm").submit();
})
</script>
