<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="testQuestionList.title"/></title>
    <meta name="menu" content="TestQuestionMenu"/>
</head>
<div class="col-sm-12">
	<div class="panel panel-default">
	  <div class="panel-heading">题库管理</div>
	  <div class="panel-body">
	    <jsp:include page="/WEB-INF/pages/testQuestionList.jsp" flush="true"></jsp:include>
	  </div>
	</div>
</div>
