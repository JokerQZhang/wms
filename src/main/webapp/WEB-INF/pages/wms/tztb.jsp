<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="tztb.title"/></title>
    <meta name="menu" content="PartyMgnMenu"/>
</head>
	<div class="col-sm-3">
		<div class="panel panel-default">
		  <div class="panel-heading">第一书记工作台帐填报</div>
		  <div class="panel-body">
		    <div class="list-group" id="listMenu">
			  <a href="#" onclick="openForm(this,'editTzDyzth')" class="list-group-item">调研座谈会情况</a>
			  <a href="#" onclick="openForm(this,'editTzDhbz')" class="list-group-item">带好班子情况</a>
			  <a href="#" onclick="openForm(this,'editTzZtjj')" class="list-group-item">助推经济情况</a>
			  <a href="#" onclick="openForm(this,'editTzFwqz')" class="list-group-item">服务群众情况</a>
			  <a href="#" onclick="openForm(this,'editTzHjmd')" class="list-group-item">化解矛盾情况</a>
			  <a href="#" onclick="openForm(this,'editTzGfmz')" class="list-group-item">规范民主情况</a>
			</div>
		  </div>
		</div>
	</div>
	<div class="col-sm-9">
		<div class="panel panel-default">
		  <div class="panel-heading">第一书记<span class="text-primary"><code id="zhibuname">(${currentPerson.name})</code></span>工作台帐填报：<strong><%=com.joker.wms.util.MyDateUtil.getCurrDate("yyyy-MM") %></strong></div>
		  <div class="panel-body" id="manyformId">
		    
		  </div>
		</div>
	</div>
<script type="text/javascript">
function openForm(item, formname){
	$("#listMenu").children().each(function(){
		$(this).removeClass('active');
	});
	$(item).addClass('active');
	$.ajax({
		url:"<c:url value='/"+ formname +"'/>",
		type:"get",
		success:function(data){
			$("#manyformId").html(data);
		}
	});
}
</script>
