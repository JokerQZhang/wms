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
<div class="col-sm-4"></div>
<div class="col-sm-8">
	<div class="panel panel-default">
	  <div class="panel-heading">站点地图设置 <code>拖动红色标记点到站点地图位置处</code><button class="btn btn-sm btn-warning" onclick="saveStationPoint()">保存当前标记点为站点位置</button></div>
	  <div class="panel-body" id="allmap" style="height:600px;">
	    
	  </div>
	</div>
</div>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KfEqPqDSBSsh3NDiHXiF2PTX"></script>
<script type="text/javascript">
var currentPoint = null;
var currentSiteId = null;
var marker=null;
var map = new BMap.Map("allmap");
$(function(){ 
	$("input[name='organizationtype']").val("company");
	$("#partyGroupSearchForm").submit();
	$("#moniteSiteSearchForm").submit();
	//map.centerAndZoom(new BMap.Point(116.404,39.915),11);
	
	var myGeo = new BMap.Geocoder();
	
	myGeo.getPoint("郑州",function(point){
		map.centerAndZoom(point,16);
		marker = new BMap.Marker(point);
		marker.addEventListener("dragend",function(e){
			//alert(e.point.lng+","+e.point.lat);
			currentPoint = e.point;
		});
		map.addOverlay(marker);
		marker.enableDragging();
	});
	
	//map.setCurrentCity("郑州");
	map.addControl(new BMap.MapTypeControl());
	map.enableScrollWheelZoom(true);
})
function saveStationPoint(){
	if(currentSiteId==null||currentSiteId==""){
		alert("请先选择站点，然后再保存。");
		return false;
	}
	if(currentPoint==null || currentPoint==""){
		alert("请先拖动地图上的标记到站点实际位置处，然后再保存。");
		return false;
	}
	$.ajax({
		url:"<c:url value='/wmsd/saveMonitorSitePoint'/>"
		,data:{currentSiteId:currentSiteId,currentPoint:currentPoint.lng+","+currentPoint.lat}
		,type:"post"
		,success:function(data){
			alert(data.msg);
			$("#moniteSiteSearchForm").submit();
		}
	});
}
</script>
