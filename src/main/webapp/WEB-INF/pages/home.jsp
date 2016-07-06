<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Home"/>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=KfEqPqDSBSsh3NDiHXiF2PTX"></script>
<style type="text/css">
.tree {
    min-height:20px;
    padding:19px;
    margin-bottom:20px;
    background-color:#fbfbfb;
    border:1px solid #999;
    -webkit-border-radius:4px;
    -moz-border-radius:4px;
    border-radius:4px;
    -webkit-box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05);
    -moz-box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05);
    box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05)
}
.tree li {
    list-style-type:none;
    margin:0;
    padding:10px 5px 0 5px;
    position:relative
}
.tree li::before, .tree li::after {
    content:'';
    left:-20px;
    position:absolute;
    right:auto
}
.tree li::before {
    border-left:1px solid #999;
    bottom:50px;
    height:100%;
    top:0;
    width:1px
}
.tree li::after {
    border-top:1px solid #999;
    height:20px;
    top:25px;
    width:25px
}
.tree li span {
    -moz-border-radius:5px;
    -webkit-border-radius:5px;
    border:1px solid #999;
    border-radius:5px;
    display:inline-block;
    padding:3px 8px;
    text-decoration:none
}
.tree li.parent_li>span {
    cursor:pointer
}
.tree>ul>li::before, .tree>ul>li::after {
    border:0
}
.tree li:last-child::before {
    height:30px
}
.tree li.parent_li>span:hover, .tree li.parent_li>span:hover+ul li span {
    background:#eee;
    border:1px solid #94a0b4;
    color:#000
}
</style>
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
	              <jsp:include page="/WEB-INF/pages/admin/geoTree.jsp" flush="true"></jsp:include>
	            </div>
			</div>
		</div>
		<div class="col-md-8">
			<div class="box box-primary">
				<div class="box-header with-border">
	              <h3 class="box-title">监控站点分布</h3>
	
	              <div class="box-tools pull-right">
	                <div class="has-feedback">
	                  <span id="sitelayer" class="text-muted"></span>
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
var map;
$(function(){
	map = new BMap.Map("allmap");
	//map.centerAndZoom(new BMap.Point(116.404,39.915),11);
	
	var myGeo = new BMap.Geocoder();
	myGeo.getPoint("郑州",function(point){
		map.centerAndZoom(point,16);
		map.addOverlay(new BMap.Marker(point));
	});
	//map.setCurrentCity("郑州");
	map.addControl(new BMap.MapTypeControl());
	map.enableScrollWheelZoom(true);
	$("#chinaspan").click();
})
	
</script>