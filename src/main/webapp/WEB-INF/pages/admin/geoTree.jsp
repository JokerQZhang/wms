<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%
if(request.getAttribute("showForm") == null){
%>
	<head>
	    <title><fmt:message key="geoList.title"/></title>
	    <meta name="menu" content=PartyGroupMenu/>
	    <meta name="title.name" content="<fmt:message key="geoList.heading"/>"/>
	</head>
    <form method="post" action="${ctx}/geoes" id="geoSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#geoSearchFormDiv'));" style="display:none;">
	    <input type="hidden" name="page.pageSize"/>
    	<input type="hidden" name="page.pageIndex"/>
	    <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
	        </span>
	        <div id="actions" class="btn-group">
		        <button id="button.search" class="btn btn-default btn-sm" type="submit">
		            <i class="icon-search"></i> <fmt:message key="button.search"/>
		        </button>
		        <a class="btn btn-primary btn-sm" href="#" onclick="ajaxLoadDaialog({url:'<c:url value='/editGeo'/>',title:'<fmt:message key="geoDetail.heading"/>',width:600,height:500,beforeDialogOpen:beforeGeoFormOpen,afterDialogOpen:afterGeoFormOpen,data:{method:'Add',from:'list'}})" >
		            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
		        </a>
	        </div>
	    </div>
    </form>
	<script type="text/javascript">
	function barLeafClick(spanItem, parentId){
		//开合子元素
    	var children = $(spanItem).parent('li.parent_li').find(' > ul > li');
        if (children.is(":visible")) {
            children.hide('fast');
            $(spanItem).attr('title', 'Expand this branch').find(' > i').addClass('glyphicon-plus-sign').removeClass('glyphicon-minus-sign');
        } else {
            children.show('fast');
            $(spanItem).attr('title', 'Collapse this branch').find(' > i').addClass('glyphicon-minus-sign').removeClass('glyphicon-plus-sign');
          	//是否已经查询出子元素如果已存在则展开或者闭合，如果没有则查询
          	var nextItem = $(spanItem).next();
          	var nodeName = $(nextItem).prop("nodeName");
          	if(nodeName!="UL"){
          		//动态加载子元素
          		$.ajax({
          			url:"${ctx}/wmsd/geoTree",
          			data:{geoParentId:parentId},
          			type:"post",
          			success:function(data){
          				$(data).insertAfter($(spanItem));
          			}
          		});
          	}
        }
        //选中效果
        var nowClass = $(spanItem).attr("class");
        if(nowClass=="btn-success"){
        }else{
        	$(".btn-success").removeClass("btn-success");
        	$(spanItem).addClass("btn-success");
        }
        
        var pStr = $(spanItem).parent().parent().parent().find("span:first").text();
        var sStr = $(spanItem).text();
        $("#sitelayer").html(pStr + " >>" + sStr);
      	//选中触发
      	if(parentId!="1"){
      		selectGeo(parentId,1);
      	}
    }
	function selectGeo(areaId,type){
		//1选择区域
		//2选择公司
		//3选择站点
		remove_overlay();
		var url = "";
		if(type=="1"){
			url="<c:url value='/wmsd/getAreaPoints' />";
		}else if(type=="2"){
			url="<c:url value='/wmsd/getCompanyPoints' />";
		}else if(type=="3"){
			url="<c:url value='/wmsd/getSitePoints' />";
		}
		$.ajax({
  			url:url,
  			data:{areaId:areaId},
  			type:"post",
  			success:function(data){
  				var result = data.result;
  				if(result=="success"){
  					var sites = data.sites;
  					if(sites.length>0){
  						for(var i=0;i<sites.length;i++){
  							var site = sites[i];
  							var pointstr = site.geopoint;
  							var pointsplit = pointstr.split(",");
  							if(pointsplit.length == 2){
  								var point = new BMap.Point(parseFloat(pointsplit[0]),parseFloat(pointsplit[1]));
  								if(i == 1){
  									map.panTo(point);
  								}
  								addMarker(point)
  							}
  						}
  					}
  				}else if(result=="lose"){
  					alert(data.msg);
  				}
  			}
  		});
	}
	function addMarker(point){
	  var marker = new BMap.Marker(point);
	  map.addOverlay(marker);
	}
	function remove_overlay(){
		map.clearOverlays();         
	}
	function companyLeafClick(spanItem, parentId){
		//开合子元素
    	var children = $(spanItem).parent('li.parent_li').find(' > ul > li');
        if (children.is(":visible")) {
            children.hide('fast');
            $(spanItem).attr('title', 'Expand this branch').find(' > i').addClass('glyphicon-plus-sign').removeClass('glyphicon-minus-sign');
        } else {
            children.show('fast');
            $(spanItem).attr('title', 'Collapse this branch').find(' > i').addClass('glyphicon-minus-sign').removeClass('glyphicon-plus-sign');
          	//是否已经查询出子元素如果已存在则展开或者闭合，如果没有则查询
          	var nextItem = $(spanItem).next();
          	var nodeName = $(nextItem).prop("nodeName");
          	if(nodeName!="UL"){
          		//动态加载子元素
          		$.ajax({
          			url:"${ctx}/wmsd/companySitesTree",
          			data:{companyId:parentId},
          			type:"post",
          			success:function(data){
          				$(data).insertAfter($(spanItem));
          			}
          		});
          	}
        }
        //选中效果
        var nowClass = $(spanItem).attr("class");
        if(nowClass=="btn-success"){
        }else{
        	$(".btn-success").removeClass("btn-success");
        	$(spanItem).addClass("btn-success");
        }
        
        var pStr = $(spanItem).parent().parent().parent().find("span:first").text();
        var sStr = $(spanItem).text();
        $("#sitelayer").html(pStr + " >>" + sStr);
      	//选中触发
        selectGeo(parentId,2);
    }
	</script>
    <div id="geoSearchFormDiv" class="tree">
    	<ul>
			<li class="parent_li">
				<span onclick="barLeafClick(this,1)" id="chinaspan"><i class="glyphicon glyphicon-th-list"></i> 中国</span>
			</li>
		</ul>
    </div>
<%
}else{
%>
	<ul>
		<c:forEach items="${companys}" var="company">
			<li class="parent_li">
				<span onclick="companyLeafClick(this,'${company.partyId}')" class="badge btn-info"><i class="glyphicon glyphicon-plus-sign"></i> ${company.groupName}</span>
			</li>
		</c:forEach>
		<c:forEach items="${geoes}" var="geo">
			<li class="parent_li">
				<span onclick="barLeafClick(this,'${geo.geoId}')"><i class="glyphicon glyphicon-plus-sign"></i> ${geo.geoName}</span>
			</li>
		</c:forEach>
	</ul>
<%
}
%>
