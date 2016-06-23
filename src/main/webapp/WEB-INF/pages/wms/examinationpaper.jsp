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
				<span id="toggle-mobile-dropdown-nav" style="width: 25%;text-align: left;">考试中...</span>
				<div class="navbar-brand" style="width: 50%;text-align: center;">
				<a href="/"></a>
				</div>
				<a class="toggle-mobile-telephone-nav visible-xs" href="#" style="width: 15%;text-align: right">
				</a>
			</div>
			<div class="navbar-header hidden-xs">
				<span style="color:#9cc71a;font-size:20px;float:left;line-height:50px;">考试中...</span>
			</div>
		</div>
	</div>
	<div class="container">
<%
	List testQuestions = (List)request.getAttribute("testQuestions");
	Map<Long,String> rOptions = (Map<Long,String>)request.getAttribute("rOptions");
	if(testQuestions!=null && testQuestions.size()>0){
		for(int i=0;i<testQuestions.size();i++){
			Object[] obs = (Object[])testQuestions.get(i);
			PaperQuestion pq = (PaperQuestion)obs[0];
			TestQuestion tq = (TestQuestion)obs[1];
%>
		<div class="panel panel-warning" id="question<%=pq.getPaperQuestionId() %>">
		  <div class="panel-heading">题目<%=i+1 %>:&nbsp;&nbsp; <%=tq.getQuestionTitle() %></div>
		  
		   <ul class="list-group">
			    <%=rOptions.get(tq.getQuestionId()) %>
		   </ul>
		</div>
<%
		}
	}
%>
		<button class="btn btn-sm btn-danger" onclick="commitpaper()">交卷</button>
	</div>
	<script type="text/javascript">
	function updateAnswer(item){
		var pqid = $(item).attr("name");
		var value = $(item).val();
		var url = "<c:url value="/wmsd/examinationSaveAnswer"/>";
		$.get(url,{pqid:pqid,value:value},
			function(data){
			}
		)
	}
	function commitpaper(){
		if(!confirm("交卷后将计算得分并且所有题目不再可修改，您确认交卷么？")) return false;
		var url = "<c:url value="/wmsd/examinationCommit"/>";
		window.location = url;
	}
	</script>
	</body>
</html>
