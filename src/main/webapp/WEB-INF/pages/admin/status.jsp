<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="AdminMenu"/>
    <meta name="title.name" content="状态设置"/>
</head>
	<div class="col-sm-5">
		<div class="panel panel-default">
		  <div class="panel-heading">状态类型</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/statusTypeList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">状态设置</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/statusItemList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-5"></div>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">状态改变设置</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/statusValidChangeList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
	beforeStatusItemSearchSubmit = function(){
		if($("input[name='selectedStatusTypeId']").val()==null || $("input[name='selectedStatusTypeId']").val()==""){
			alert("清先选择状态类型！");
			return false;
		}else{
			return true;
		}
	}
	beforeVCSearchSubmit = function(){
		if($("input[name='selectedStatusTypeId']").val()==null || $("input[name='selectedStatusTypeId']").val()==""){
			alert("清先选择状态类型！");
			return false;
		}else{
			return true;
		}
	}
	</script>
