<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Home"/>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KfEqPqDSBSsh3NDiHXiF2PTX"></script>
</head>
<div id="allmap" style="width:1000px;height:500px;">
</div>
<script>
	var map = new BMap.Map("allmap");
	//map.centerAndZoom(new BMap.Point(116.404,39.915),11);
	
	var myGeo = new BMap.Geocoder();
	myGeo.getPoint("郑州",function(point){
		map.centerAndZoom(point,16);
		map.addOverlay(new BMap.Marker(point));
	});
	//map.setCurrentCity("郑州");
	map.addControl(new BMap.MapTypeControl());
	map.enableScrollWheelZoom(true);
</script>