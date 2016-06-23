<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>
	<div class="col-sm-7">
		<div class="panel panel-default">
		  <div class="panel-heading">优抚发放</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/tbProvideList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-5">
		<div class="panel panel-default">
		  <div class="panel-heading">优抚发放明细<span class="text-primary"><code id="zhibuname"></code></span></div>
		  <div class="panel-body">
		  	<jsp:include page="/WEB-INF/pages/tbProvideDtlList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
<script type="text/javascript">
var selectedProvideId;
afterSelectTbProvide=function(data){
	var provideId = data[0];
	var nowProvideId = $("input[name='provideId']").val();
	selectedProvideId = provideId;
	if(provideId!=nowProvideId){
		$("input[name='provideId']").val(provideId);
		$("#tbProvideDtlSearchForm").submit();
	}
}
function sendMoney(item){
	disableItem(item);
	$.ajax({
		url:"<c:url value='/wmsd/sendMoney'/>",
		type:"post",
		data:{provideId:selectedProvideId},
	    success:function(data){
	    	alert(data);
	    	enableItem(item);
	    	$("#tbProvideSearchForm").submit();
	    }
	});
}
$(function(){
	$("#tbProvideSearchForm").submit();
})
</script>
