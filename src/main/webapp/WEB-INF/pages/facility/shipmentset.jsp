<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="FacilityMgnMenu"/>
</head>
	<div class="col-sm-3">
		<div class="panel panel-default">
		  <div class="panel-heading">销售计划</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/salePlanList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-9">
		<div class="panel panel-default">
		  <div class="panel-heading">货运明细</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/shipmentList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>

	<script type="text/javascript">
	$(function(){
		$("#salePlanSearchForm").submit();
	});
	var selectedsaleplanid;
	afterSelectSalePlan = function(data){
		if(selectedsaleplanid == data[0]){
			return false;
		}
		selectedsaleplanid = data[0];
		$("input[name='salePlanId']").val(data[0]);
		$("#shipmentSearchForm").submit();
		return true;
	};
	</script>
