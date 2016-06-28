<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="alarmSetList.title"/></title>
    <meta name="menu" content="MonitorMenu"/>
    <meta name="title.name" content="监测站点"/>
</head>
<div class="col-sm-4">
	<div class="panel panel-default">
	  <div class="panel-heading">企业信息</div>
	  <div class="panel-body">
	    <jsp:include page="/WEB-INF/pages/wms/companyList.jsp" flush="true"></jsp:include>
	  </div>
	</div>
</div>
<div class="col-sm-8">
	<div class="panel panel-default">
	  <div class="panel-heading">企业监测站点</div>
	  <div class="panel-body">
	    <jsp:include page="/WEB-INF/pages/moniteSiteList.jsp" flush="true"></jsp:include>
	  </div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("input[name='organizationtype']").val("company");
	$("#partyGroupSearchForm").submit();
	$("#moniteSiteSearchForm").submit();
})
</script>
