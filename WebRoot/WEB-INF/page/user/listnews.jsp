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
				新闻中心<br /> News Center
			</div>
		</div>
	</div>
	<div class="list_main">
		<div class="list_center_main ">

			<div class="list_center">
				<div class="outer3 outer4 outer6">
					<div class="line"></div>
					<div class="list06">
						<div class="list
						06left list06left">
							<h4 class="h4">新闻中心&nbsp;&nbsp;News Center</h4>
						</div>
						<div class="list06right list06right licon">
							<span class="a13">当前位置：<a href="viewindex" style="color: #0066cc;">首页 </a> > 新闻中心</span>
						</div>
					</div>
					<ul>
						<s:iterator value="pageBean.recordList">
							<li>
								<dl>
									<dt class="messdt"></dt>
									<dd>
										<a href="newsview?id=${id }" class="title03 hovercolor" title="${titles }">${titles } 
										<span class="title04 gray"> ${date }</span></a>
									</dd>
								</dl></li>
						</s:iterator>
					</ul>
					<!-- 分页 -->
					<div class="pageing">
						<ul class="page">
							<li><a href="newsindex?pageNum=${pageNums -1}"><</a></li>
							<s:iterator begin="pageBean.beginPageIndex"
								end="pageBean.endPageIndex" var="pageNums">
								<li
									class="paginItem ${pageBean.currentPage==pageNums?'current':''}">
									<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
									<c:if test="${pageBean.currentPage == pageNums }">
										<a href="#" class="cur">${pageNums }</a>
									</c:if> <c:if test="${pageBean.currentPage != pageNums }">
										<a href="newsindex?pageNum=${pageNums }">${pageNums }</a>
									</c:if>
								</li>
							</s:iterator>

							<li><a href="newsindex?pageNum=${pageNums }">></a></li>
						</ul>
						<!-- <ul class="pageingtz">
							<li>跳转：<input type="text" class="input" />&nbsp;页&nbsp;<a
								href="#" class="a13">GO</a>
							</li>
						</ul> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="button.jspf"%>
</body>
</html>
