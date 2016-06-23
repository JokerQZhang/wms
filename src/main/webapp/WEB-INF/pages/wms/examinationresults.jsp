<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.List,java.util.Map,com.joker.wms.model.*" %>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>尉氏县-党员测试系统</title>
    <link rel="stylesheet" href="<c:url value="/scripts/bootstrap/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/styles/examination.css"/>">
    <script type="text/javascript" src="<c:url value="/scripts/bootstrap/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/scripts/bootstrap/js/bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container">
			<div class="navbar-header visible-xs">
				<span id="toggle-mobile-dropdown-nav" style="width: 25%;text-align: left;">考试记录</span>
				<div class="navbar-brand" style="width: 50%;text-align: center;">
				<a href="/"></a>
				</div>
				<a class="toggle-mobile-telephone-nav visible-xs" href="#" style="width: 15%;text-align: right">
				</a>
			</div>
			<div class="navbar-header hidden-xs">
				<span style="color:#9cc71a;font-size:20px;float:left;line-height:50px;">考试记录</span>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="panel panel-warning">
		  <div class="panel-heading">考试记录表</div>
		   <div class="list-group">
<%
	List testPapers = (List)request.getAttribute("testPapers");
	if(testPapers!=null && testPapers.size()>0){
		for(int i=0;i<testPapers.size();i++){
			Object[] obs = (Object[])testPapers.get(i);
			TestPaper tp = (TestPaper)obs[0];
			Examination ex = (Examination)obs[1];
%>
				<a href="<c:url value="/wmsd/examinationResult"/>?nowExaminationId=<%=ex.getExaminationId() %>" class="list-group-item"><%=tp.getPaperName()+"--状态："+(tp.getScore()==null?"未交卷":"已交卷")+"--分数:"+(tp.getScore()==null?"0":tp.getScore()) %></a>
<%
		}
	}
%>
			</div>
		</div>
		<button class="btn btn-sm btn-danger" onclick="newtestpaper()">开始考试</button>
	</div>
	<script type="text/javascript">
	function newtestpaper(){
		var url = "<c:url value="/wmsd/examinationpaper"/>";
		window.location = url;
	}
	</script>
	</body>
</html>
