<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="AdminMenu"/>
    <meta name="title.name" content="数据字典设置"/>
</head>
	<div class="col-sm-5">
		<div class="panel panel-default">
		  <div class="panel-heading">数据字典类型</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/enumerationTypeList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">数据字典设置</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/enumerationList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$("#enumerationTypeSearchForm").submit();
		//查询相关的字典信息
		if(typeof(afterSelectEnumerationType) == "undefined"){
			afterSelectEnumerationType = function(data){
				var enumerationTypeId = data[0];
				$("#enumerationSearchForm").find("input[name='enumTypeId']").val(enumerationTypeId);
				$("#enumerationSearchForm").submit();
			};
		}
	})
	</script>
