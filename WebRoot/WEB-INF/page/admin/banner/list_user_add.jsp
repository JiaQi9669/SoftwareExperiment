<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/layer/layer.js"></script>
<!-- 新闻UE相关 -->
<link
	href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
 function check(){
 	 var pwd1 = document.getElementById("password").value;
     var pwd2 = document.getElementById("repassword").value;
     if(pwd1!=pwd2)
     alert("两次密码不一致，请重新输入！");
 }
</script>

</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a>
			</li>
			<li><a href="#">账号添加</a>
			</li>
		</ul>
	</div>

	<script type="text/javascript">
		var ue = UE.getEditor('editor');
	</script>
	<center>
	<form action="Useraddwrite" method="post">
	            账号:<input type="text" name="username"/>
		密码:<input type="password" name="password"/>
              确认密码:<input type="password" name="repassword"/>
		<input type="submit" onclick="check()"/>
	</form>
	</center>

</body>

</html>

