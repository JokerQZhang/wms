<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="Uom"/>
    <meta name="title.name" content="单位度量衡"/>
</head>
	<div class="col-sm-5">
		<div class="panel panel-default">
		  <div class="panel-heading">度量单位类型</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/uomTypeList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">度量单位明细</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/uomList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-5"></div>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">度量单位换算</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/uomConversionList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
	afterSelectUomType=function(data){
		var uomTypeId = data[0];
		var selectedUomTypeId = $("input[name='uomTypeId']").val();
		if(uomTypeId == selectedUomTypeId){
			return false;
		}
		$("input[name='uomTypeId']").val(uomTypeId);
		$("#uomSearchForm").submit();
		$("#uomConversionSearchForm").submit();
	}
	beforeUomFormOpen = function(){
		var uomTypeId = $("input[name='uomTypeId']").val();
		if(uomTypeId==null || uomTypeId==""){
			alert("请先选择度量衡类型，然后再添加。");
			return false;
		}
		return true;
	};
	afterUomFormOpen = function(){
		var uomTypeId = $("input[name='uomTypeId']").val();
		$("input[name='uom.uomTypeId']").val(uomTypeId);
		return true;
	};
	</script>
