<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>尉氏县-党员测试系统</title>
    <link rel="stylesheet" href="<c:url value="/scripts/bootstrap/css/bootstrap.min.css"/>">
    <script type="text/javascript" src="<c:url value="/scripts/bootstrap/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/scripts/bootstrap/js/bootstrap.min.js"/>"></script>
    <style type="text/css">
    h1, .h1, h2, .h2, h3, .h3, h4, .h4, .lead{
    	font-family:"ff-tisa-web-pro-1","ff-tisa-web-pro-2","Lucida Grande","Helvetica Neue",Helvetica,Arial,"Hiragino Sans GB","Hiragino Sans GB W3","Microsoft YaHei UI","Microsoft YaHei","WenQuanYi Micro Hei",sans-serif;
    }
    .header{
    	background:#222;
    	background-repeat:no-repeat;
    	background-position:center 0;
    	background-size:cover;
    	-webkit-background-size:cover;
    	padding:138px 0 0;
    	text-align:center;
    	min-height:400px;
    	position:relative;
    }
    .logoimg{
    	position:absolute;
    	left:1%;
    	right:1%;
    	bottom:-34px;
    }
    .logotxt{
    	margin-bottom:30px;
    	border:0;
    }
    .logotxt a{
    	font-weight:700;
    	color:#fff;
    	font-size:54px;
    }
    .header h2{
    	color:#fff;
    	padding:0;
    	margin:0 0 45px;
    	font-weight:100;
    	font-size:30px;
    }
    body{
    	background:#f2f2f2;
    }
    .main{
    	margin-top:60px;
    }
    </style>
</head>
<body>
	<div class="header" style="background-image: url(<c:url value="/images/extitle.jpg"/>)">
		<div class="logoimg">
			<a href="#" title="党员学习测试系统"><img
				src="<c:url value="/images/logo.png"/>"
				alt="党务" width="78"></a>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="logotxt">
						<h1>
							<a href="#">尉氏县党委</a>
						</h1>
					</div>
					<h2 class="site-name text-center">
						党员考试系统
					</h2>
				</div>
			</div>
		</div>
	</div>
	<main class="main" role="main">
		<div class="container">
			<form class="form-horizontal" action="<c:url value="/wmsd/examinationResults"/>" method="post">
			  <div class="form-group">
			    <label for="answer_phone" class="col-sm-2 control-label">手机号</label>
			    <div class="col-sm-10">
			      <input type="phone" class="form-control" id="answer_phone" name="answer_phone" value="${answer_phone}" placeholder="手机号码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="answer_name" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="answer_name" name="answer_name" placeholder="姓名">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="answer_id" class="col-sm-2 control-label">身份证号</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="answer_id" name="answer_id" placeholder="身份证号">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="answer_code" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="answer_code" name="answer_code" placeholder="短信验证码">
			      <a href="#" class="btn btn-warning btn-sm">发送验证码</a>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <a class="btn btn-default" href="#" onclick="beginexa()">开始考试</a>
			    </div>
			  </div>
			</form>
		</div>
	</main>
	<script type="text/javascript">
	function beginexa(){
		
	}
	</script>
</body>
</html>
