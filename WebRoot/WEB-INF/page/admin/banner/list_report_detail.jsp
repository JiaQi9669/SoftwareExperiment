<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>
<link href="${pageContext.request.contextPath}/user/css/style.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="detail_center">
		<div class="detail_centerbg">
			<div class="list07">
				<div class="list07left list07left">
					<h4 class="h4">申报材料&nbsp;&nbsp;</h4>
				</div>
				<div class="list07right list07right licon">
					<span class="a13">首页 ><a href="Managereportupdate">申报材料</a>>详情</span>
				</div>
			</div>
			<div class="detail_title">
				<p class="title">${beans.titles }</p>
				<br/>
				<p>
					<span class="blue">信息来源：</span>本站原创&nbsp;&nbsp;&nbsp;&nbsp; <span
						class="blue">发布日期：</span>${beans.date }&nbsp;&nbsp;&nbsp;&nbsp; <span
						class="blue">浏览次数：</span>${beans.count }
				</p>
			</div>
			<div class="detail_data">
				<div id="sub_text_area">
					<p>${beans.context }</p>					
				</div>
			</div>
			<div class="detail_foot">
				<br /> <br /> <br />
				附件下载<a href="down_down?fileName=${beans.path }">${beans.path }</a>
				<p>
					<a href="Managereportview?id=${up.id }" class="a14 underline" ><c:if test="${up != null }">上一篇：${up.titles }</c:if></a> 
					<a href="Managereportview?id=${down.id }" class="a14 underline right"><c:if test="${down != null }">下一篇：${down.titles }</c:if></a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
