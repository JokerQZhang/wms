<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="FacilityMgnMenu"/>
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
		  <div class="panel-heading">单位仓库及固定资产设置</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/facilityList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>

	<script type="text/javascript">
	var selectedgroupid;
	afterSelectPartyGroup = function(data){
		var sgroupid = data[0];
		selectedgroupid = sgroupid;
		var groupId = $("input[name='groupId']").val();
		if(sgroupid == groupId){
			return false;
		}
		$("input[name='groupId']").val(sgroupid);
		$("input[name='selectedGroupId']").val(data[0]);
		$("#facilitySearchForm").submit();
		return true;
	};
	beforeFacilityFormOpen = function(){
		if(selectedgroupid==null || selectedgroupid==""){
			alert("请先选择相应的单位，然后再添加其仓库");
			return false;
		}
		return true;
	};
	afterFacilityFormOpen = function(){
		$("input[name='groupId']").val(selectedgroupid);
		return true;
	};
	</script>
