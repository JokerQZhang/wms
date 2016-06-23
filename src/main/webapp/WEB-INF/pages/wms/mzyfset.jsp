<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="activeUsers.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>
	<div class="col-sm-9">
		<div class="panel panel-default">
		  <div class="panel-heading">优抚人员信息</div>
		  <div class="panel-body">
		    <jsp:include page="/WEB-INF/pages/tbCarePeopleList.jsp" flush="true"></jsp:include>
		  </div>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="panel panel-default">
		  <div class="panel-heading">享受优抚类型<span class="text-primary"><code id="zhibuname"></code></span></div>
		  <div class="panel-body">
		  	<div id="search" style="width:50px;">
		  		<a class="btn btn-primary btn-sm" href="#" onclick="addYFType()">新增</a>
		  	</div>
		  	<div id="yflistDiv">
		  		
		  	</div>
		  </div>
		</div>
	</div>
<script type="text/javascript">
var selectedPeopleId;
var selectedPeopleName;
afterSelectTbCarePeople = function(data){
	selectedPeopleId = data[0];
	selectedPeopleName = data[1];
	$('#yfpeoplename').html(selectedPeopleName);
	//根据选择的people_id查询民政优抚享有类型
	ajaxUpdateArea("yflistDiv","<c:url value='/wmsd/peopleYFTypes'/>",{selectedPeopleId:selectedPeopleId});
}
function addYFType(){
	if(selectedPeopleId==null || selectedPeopleId==""){
		alert("请先选择人员,然后在添加民政优抚类型");
		return false;
	}
	ajaxLoadDaialog({
		url:"<c:url value='/wmsd/addPeopleYFType'/>",
		data:{selectedPeopleId:selectedPeopleId,selectedPeopleName:selectedPeopleName},
		title:"新增人员的优抚类型",
		height:"200",
		width:"400"
	});
}
function savePeopleYFType(){
	var yfTypeId = $("select[name='yfTypeId']").val();
	var peopleId = $("input[name='selectedPeopleId']").val();
	if(yfTypeId=="" || peopleId==""){
		alert("信息不完整。");
	}
	$("#jokerdialogframexixi").dialog("close");
	$.ajax({
		url:"<c:url value='/wmsd/savePeopleYFType'/>",
		data:{yfTypeId:yfTypeId,selectedPeopleId:peopleId},
		type:"post",
		success:function(data){
			alert(data);
			ajaxUpdateArea("yflistDiv","<c:url value='/wmsd/peopleYFTypes'/>",{selectedPeopleId:selectedPeopleId});
		}
	});
}
function deletePeopleYFType(careId){
	$.ajax({
		url:"<c:url value='/wmsd/savePeopleYFType'/>",
		data:{careId:careId,"delete":"delete"},
		type:"post",
		success:function(data){
			alert(data);
			ajaxUpdateArea("yflistDiv","<c:url value='/wmsd/peopleYFTypes'/>",{selectedPeopleId:selectedPeopleId});
		}
	});
}
$(function(){
	$("#tbCarePeopleSearchForm").submit();
})
</script>
