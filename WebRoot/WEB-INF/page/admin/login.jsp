<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript"
	src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/cloud.js"
	type="text/javascript"></script>

<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		});
	});
</script>

</head>

<body
	style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/pages/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎登录郑州轻工业学院软件工程实践示范中心后台管理平台</span>
		<ul>
			<li><a href="viewindex">回首页</a>
			</li>
		</ul>
	</div>

	<div class="loginbody">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
		<!--      <form class="login" name="login" action="teacherAction_login.action" -->
		<form class="login" name="login" action="Userlogin" method="post">
			<!-- <form class="login" name="login" action="student_login.action"
				method="post" >  -->
			<div class="loginbox">
				<ul>
					<li><input name="username" type="text" class="loginuser"
						 onclick="JavaScript:this.value=''" />
					</li>
					<li><input name="password" type="password" class="loginpwd"
						onfocus="this.type='password'" autocomplete="off" class="loginpwd"
						value="" onclick="JavaScript:this.value=''" />
					</li>
					<li><input name="" type="submit" class="loginbtn" value="登录" /><label>
					</label>
					</li>
				</ul>

			</div>
		</form>
	</div>

</body>

</html>
