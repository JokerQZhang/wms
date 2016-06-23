<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="menu.partymgn"/></title>
    <meta name="menu" content="PartyMgnMenu"/>
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
	<div class="col-sm-5">
		<div class="panel panel-default">
		  <div class="panel-heading">行政组织信息</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/wms/villagetree.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">第一书记工作台帐<span class="text-primary"><code id="zhibuname">请先选中村</code></span></div>
		  <div class="panel-body" id="dtlpanel">
		  	<form method="post" action="<c:url value='/wmsd/tzdtl'/>" id="tzdtlSearchForm" class="form-inline" onsubmit="return ajaxSubmitFormUpdateAreas(this,$('#dtlinfo'));">
			    <div id="search" class="text-right">
			    	<input type="hidden" name="partyId" value="${partyId}"/>
			    	<input type="hidden" name="isXiang" value="${isXiang}"/>
			        <span class="col-sm-9">
			            <input type="text" size="20" name="tzDate" value="${tzDate}"
			                   placeholder="2016-03" class="form-control input-sm"/>
			        </span>
			        <div id="actions" class="btn-group">
				        <button id="button.search" class="btn btn-default btn-sm" type="submit">
				            <i class="icon-search"></i> <fmt:message key="button.search"/>
				        </button>
			        </div>
			    </div>
		    </form>
			<div id="dtlinfo">
		    	<!-- <jsp:include page="/WEB-INF/pages/wms/villagedtl.jsp" flush="true"></jsp:include> -->
		    </div>
		  </div>
		</div>
		<div id="sss" class="modal fade" role="dialog">
			<div class="modal-dialog" align="center">
				<img alt="" src="/images/waiting.gif" style="opacity:0.50;">Waiting....
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	$(function(){
		$("#partyGroupSearchForm").submit();
		//$("#sss").modal('show');
	})
	function modifyCun(){
		if(selectedGroupId==""||isNowXiang=="xiang"){
			alert("请先选择需要修改的村信息!");
			return false;
		}
		ajaxLoadDaialog({url:'<c:url value='/wmsd/editPartyGroupCun'/>',title:'<fmt:message key="partyGroupDetail.heading"/>',width:600,height:500,beforeDialogOpen:undefined,afterDialogOpen:afterPartyGroupFormOpen,data:{partyId:selectedGroupId,method:'Add',from:'list'}});
	}
	function addPeople(){
		if(selectedGroupId==""||isNowXiang=="xiang"){
			alert("请先选择需要修改的村信息!");
			return false;
		}
		ajaxLoadDaialog({url:'<c:url value='/wmsd/editCunPerson'/>',title:'<fmt:message key="partyGroupDetail.heading"/>',width:600,height:500,beforeDialogOpen:undefined,afterDialogOpen:afterPartyGroupFormOpen,data:{belongGroupId:selectedGroupId,method:'Add',from:'list'}});
	}
	function villageTreeSelect(partyId, isXiang){
		//loadingEffect($(".col-sm-7"));
		$("input[name='partyId']").val(partyId);
		$("input[name='isXiang']").val(isXiang);
		$("#tzdtlSearchForm").submit();
		//loadingEffectOff($(".col-sm-7"));
		
/* 		$.ajax({
			url:"<c:url value='/wmsd/tzdtl'/>"
			,type:"post"
			,data:{partyId:partyId,isXiang:isXiang}
			,success:function(data){
				loadingEffectOff($(".col-sm-7"));
				$("#dtlinfo").html(data);
			}
		}); */
	}
	function loadingEffect(loadingarea){
		//组织效果叠加
		$(loadingarea).find("div[role='jokerloading']").remove();
		var mask = $("<div role='jokerloading' class='modal-backdrop fade in' align='center'><img src='/images/waiting.gif'></div>");
		
		var height = $(loadingarea).outerHeight();
		var width = $(loadingarea).outerWidth();
		$(mask).width(width);
		$(mask).height(height);
		$(mask).css("line-height",height+"px");
		$(loadingarea).append($(mask));
	}
	function loadingEffectOff(loadingarea){
		$(loadingarea).find("div[role='jokerloading']").remove();
	}
	</script>