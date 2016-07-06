<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="PartyGroupMenu"/>
    <meta name="title.name" content="地区位置"/>
</head>
<div class="col-sm-4">
	<div class="panel panel-default">
	  <div class="panel-heading">地区信息</div>
	  <div class="panel-body">
	    <jsp:include page="/WEB-INF/pages/geoList.jsp" flush="true"></jsp:include>
	  </div>
	</div>
</div>
<div class="col-sm-8">
	<div class="panel panel-default">
	  <div class="panel-heading">地区地图设置 <code>拖动红色标记点到地区地图位置处</code><button class="btn btn-sm btn-warning" onclick="saveGeoPoint()">保存当前标记点为地区位置</button></div>
	  <div class="panel-body" id="allmap" style="height:600px;">
	    
	  </div>
	</div>
</div>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KfEqPqDSBSsh3NDiHXiF2PTX"></script>
<script type="text/javascript">
var currentPoint = null;
var currentGeoId = null;
var marker=null;
var map = new BMap.Map("allmap");
$(function(){ 
	$("#geoSearchForm").submit();
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
function saveGeoPoint(){
	if(currentGeoId==null||currentGeoId==""){
		alert("请先选择区域，然后再保存。");
		return false;
	}
	if(currentPoint==null || currentPoint==""){
		alert("请先拖动地图上的标记到站点实际位置处，然后再保存。");
		return false;
	}
	$.ajax({
		url:"<c:url value='/wmsd/saveGeoSitePoint'/>"
		,data:{currentGeoId:currentGeoId,currentPoint:currentPoint.lng+","+currentPoint.lat}
		,type:"post"
		,success:function(data){
			alert(data.msg);
			$("#geoSearchForm").submit();
		}
	});
}
</script>
