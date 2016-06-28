<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Home"/>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KfEqPqDSBSsh3NDiHXiF2PTX"></script>
</head>
<section class="content">
	<div class="row">
		<div class="col-md-4">
			<div class="box box-primary">
				<div class="box-header with-border">
	              <h3 class="box-title">监控企业</h3>
	
	              <div class="box-tools pull-right">
	                <div class="has-feedback">
	                  <span></span>
	                </div>
	              </div>
	            </div>
	            <div class="box-body no-padding">
	            	
	            </div>
			</div>
		</div>
		<div class="col-md-8">
			<div class="box box-primary">
				<div class="box-header with-border">
	              <h3 class="box-title">监控站点分布</h3>
	
	              <div class="box-tools pull-right">
	                <div class="has-feedback">
	                  <span></span>
	                </div>
	              </div>
	            </div>
	            <div class="box-body no-padding" >
	            	<div id="allmap" style="min-height:600px;">
					</div>
	            </div>
			</div>
		</div>
	</div>
</section>

<script>
$(function(){
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
})
	
</script>