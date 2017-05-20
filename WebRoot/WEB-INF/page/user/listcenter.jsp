<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>郑州轻工业学院软件学院实验示范中心</title>
<link
	href="${pageContext.request.contextPath}/newuser/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/newuser/css/master.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/newuser/css/index.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/user/css/style.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<%@include file="top.jspf"%>
	<div class="list_center">
		<div class="list_centerbg">
			<div class="list_centertitle">
				中心概括<br /> Center Generalize
			</div>
		</div>
	</div>
	<div class="list_main">
		<div class="list_center_main">
			<div class="list_mainleft">
				<dl>
					<dt>中心概括</dt>
						<s:iterator value="pageBean.recordList">
						<dd class="cur">
							<a href="centerfinds?id=${id }">${titles }</a>
						</dd>
					</s:iterator>
				</dl>
			</div>
			<div class="list_mainright" name="main">
			
				<div class="outer3 outer4 outer6">
					<div class="line"></div>
					<div class="list06">
						<div class="list06left list06left">
							<h4 class="h4">详细内容&nbsp;&nbsp;</h4>
						</div>
						<div class="list06right list06right licon">
							<span class="a13">当前位置：<a href="viewindex" style="color: #0066cc;">首页 </a> > 中心概括</span>
						</div>
					</div>
					<!-- 详情 -->
					<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<c:if test="${beans != null }">
					<div class="detail_title">
						<p class="title"><center style="font-size:30px">${beans.titles }</center></p>
						<br />
						<p><center>
							<span class="blue">信息来源：</span>郑轻软创&nbsp;&nbsp;&nbsp;&nbsp; <span
								class="blue">发布日期：</span>${beans.date }&nbsp;&nbsp;&nbsp;&nbsp; <span
								class="blue">浏览次数：</span>${beans.count }
						</p></center>
					</div>
					<br /> <br />
						${beans.context }
						<br /> <br />
					<div class="detail_foot">
						<p>郑州轻工业学院-软件综合实践与创新基地</p>
						<p>${beans.date }</p>
					</div>
					</c:if>
					<c:if test="${beans == null }">
						<center>请点击侧栏查看</center>
					</c:if>
				
				</div>
			</div>
		</div>
	</div>
	<%@include file="button.jspf"%>
</body>
</html>
