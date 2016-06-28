<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.Locale,java.util.ResourceBundle"%>
<%@ include file="/common/taglibs.jsp" %>

<head>
    <meta name="menu" content="Login"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
    <title>大同水质监测系统登录</title>
    <t:assets type="css"/>
    <t:assets type="js"/>
	<script type="text/javascript">
		if ($.cookie("username") != null && $.cookie("username") != "") {
	        $("#j_username").val($.cookie("username"));
	        $("#j_password").focus();
	    } else {
	        $("#j_username").focus();
	    }
    
	    function saveUsername(theForm) {
	        $.cookie("username",theForm.j_username.value, { expires: 30, path: "<c:url value="/"/>"});
	    }
	    
	    function validateForm(form) {                                                               
	        var valid = validateRequired(form);
	        if (valid == false) {
	            $(".form-group").addClass('error');
	        }
	        return valid;
	    }
	
	    function passwordHint() {
	        if ($("#j_username").val().length == 0) {
	            alert("<s:text name="errors.requiredField"><s:param><s:text name="label.username"/></s:param></s:text>");
	            $("#j_username").focus();
	        } else {
	            location.href="<c:url value="/passwordHint"/>?username=" + $("#j_username").val();
	        }
	    }
	    
	    function required () { 
	        this.aa = new Array("j_username", "<s:text name="errors.requiredField"><s:param><s:text name="label.username"/></s:param></s:text>", new Function ("varName", " return this[varName];"));
	        this.ab = new Array("j_password", "<s:text name="errors.requiredField"><s:param><s:text name="label.password"/></s:param></s:text>", new Function ("varName", " return this[varName];"));
	    }
    </script>
    <style type="text/css">
    .headers{width:1000px;height:64px;position:relative;margin:0 auto;z-index:2;overflow:hidden;}
	.headerLogo{top:17px;left:50px}
	.headerIntro{height:28px;width:160px;display:block;background-position:0 -64px;top:17px;left:194px;position:absolute;}
	.headerNav{top:21px;right:100px;text-align:right;color:#cfd0d0;position:absolute;}
	.headerNav a{padding-left:13px;display:inline-block;}
	.headerNav .last{padding-left: 0;}
	a{text-decoration:none;color:#959595}
	#mainCnt{width:100%;height:600px;position:relative;clear:both;background-repeat:no-repeat;background-position:center top;}
	.login{width:295px;height:460px;padding:13px 14px 15px;top:200px;left:42%;text-align:left;position:absolute;z-index:2;}
	.footers{height:65px;margin:0 auto;}
	.footer-inner{width:1000px;height:63px;overflow:visible;margin:0 auto;color:#848585;position:relative;}
	.footerLogo{top:11px;left:35px}
	.footerNav{top:25px;right:123px;}
	.footerNav a{margin-left:12px}
	.copyright{margin:0 12px;}
	
	.headerIntro,
	.headerNav,
	.footerLogo,
	.footerNav,
	.formIpt,
	.domain,
	#whatAutologinTip,
	#mobtips,
	#mobtips_arr,
	#mobtips_close{position:absolute}
    </style>
</head>
<body id="login" style="">
<header class="headers">
	<h1 class="headerLogo"><a href="http://www.kfqicaihong.com/" target="_blank" title="走进七彩虹"><img src="<c:url value='/images/toplogo.png'/>"></a></h1>
	<nav class="headerNav">
		<!-- 
		<a href="http://www.kfqicaihong.com/about-1.html" target="_blank">公司简介</a>
        <a href="http://www.kfqicaihong.com/about-2.html" target="_blank">企业文化</a>
        <a href="http://www.kfqicaihong.com/about-3.html" target="_blank">发展历程</a>
        <a href="http://www.kfqicaihong.com/about-4.html" target="_blank">资质荣誉</a>
         -->
        <a href="http://www.baidu.com" target="_blank">联系方式</a>
        <a href="#" target="_blank">帮助</a>&nbsp;|&nbsp;<a class="last" href="http://www.baidu.com" target="_blank">在线留言</a>
	</nav>
</header>
<section class="main" id="mainBg" style="background-color: rgb(229, 230, 230);">
	<div class="main-inner" id="mainCnt" style="background-image: url(<c:url value='/images/loginmain.jpg'/>);">
		<div id="loginBlock" class="login tab-2">
			<div id="normalLoginTab" class="loginForm" style="display: block;">
				<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
				    onsubmit="saveUsername(this);return validateForm(this)" class="form-signin" autocomplete="off">
				    <h2 class="form-signin-heading">
				        &nbsp;
				    </h2>
				<c:if test="${param.error != null}">
				    <div class="alert alert-danger alert-dismissable">
				        <fmt:message key="errors.password.mismatch"/>
				    </div>
				</c:if>
				    <input type="text" name="j_username" id="j_username" class="form-control"
				           placeholder="<fmt:message key="label.username"/>" required tabindex="1">
				    <input type="password" class="form-control" name="j_password" id="j_password" tabindex="2"
				           placeholder="<fmt:message key="label.password"/>" required>
				
				<c:if test="${appConfig['rememberMeEnabled']}">
				    <label for="rememberMe" class="checkbox">
				        <input type="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
				        <fmt:message key="login.rememberMe"/></label>
				</c:if>
				
				    <button type="submit" class="btn btn-lg btn-primary btn-block" name="login" tabindex="4">
				        <fmt:message key='button.login'/>
				    </button>
				</form>
				
			</div>
		</div>
	</div>
</section>
<%
//Locale currentLocale = Locale.getDefault();
//Locale locale = request.getLocale();
//ResourceBundle myResource = ResourceBundle.getBundle("ApplicationResources_zh");
%>

<footer id="footer" class="footers">
	<div class="footer-inner" id="footerInner">
		<a class="footerLogo" href="#" target="_blank" style="position: absolute"><img src="<c:url value='/images/bottomlog.png'/>" alt="大同水质检测"></a>
		<a id="KX_IMG" style="position:absolute;right:50PX;top:24px;" href="#" target="_blank">
			<img src="http://mimg.127.net/logo/knet.png" alt="可信网站，身份验证">
		</a>
		<nav class="footerNav">
			<a href="http://www.163.com/" target="_blank">青豆首页</a>|<span class="copyright">河南青豆科技公司版权所有©2014-2015</span>|<a href="http://www.kfqicaihong.com/ProductClass-1-1.html" target="_blank">ICP证豫C2-20150904</a>
		</nav>
	</div>
</footer>
<script type="text/javascript">
$(function(){
	var wheight = $(window).height();
	var paddingTop = 0;
	if(wheight>729){
		paddingTop = (wheight-729)/2;
	}
	$("body").attr("style","padding-top:"+paddingTop+";background-color: #ffffff !important;font-family:'Microsoft YaHei', arial !important;");
})
</script>
</body>