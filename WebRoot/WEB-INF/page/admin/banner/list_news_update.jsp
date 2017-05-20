<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/layer/layer.js"></script>
<script language="javascript">
	$(function() {
		//导航切换
		$(".imglist li").click(function() {
			$(".imglist li.selected").removeClass("selected");
			$(this).addClass("selected");
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
	function load() {
		var index = layer.load(1, {
			shade : [ 0.1, '#fff' ]
		//0.1透明度的白色背景
		});
	}
</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a>
			</li>
			<li><a href="#">新闻管理</a>
			</li>
		</ul>
	</div>

	<div class="rightinfo">
		
		<div class="tools">

			<ul class="toolbar">
				<a href="Managenewsadd">
					<li class="click"><span><img
							src="${pageContext.request.contextPath}/admin/images/t01.png" />
					</span>添加</li>
				</a>
			</ul>
		</div>
		
		<table class="imgtable">

			<thead>
				<tr>
					<th>编号</th>
					<th width="100px;">缩略图</th>
					<th>新闻标题</th>
					<th>浏览量</th>
					<th>发布时间</th>
					<th>操作</th>
					<th>修改信息</th>
				</tr>
			</thead>

			<tbody>
				<s:iterator value="pageBean.recordList" var="n" status="indexs">
					<tr>
						<td>${indexs.index+1 }</td>
						<td><img src="${pageContext.request.contextPath}/uploads/files/${n.path }" style="width: 70px;height: 35px;"/></td>
						<td><a href="Managenewsview?id=${n.id }">${n.titles }</a></td>
						<td>${n.count }</td>
						<td>${n.date }</td>
						<td><c:if test="${n.view == true }">
								<a href="Managenewsunshow?id=${n.id }">关闭</a>
							</c:if> <c:if test="${n.view != true }">
								<a href="Managenewsshow?id=${n.id }">开启</a>
							</c:if></td>
							<td><a href="Managenewsinster?id=${n.id }">修改</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<!-- 分页 -->
				<link href="${pageContext.request.contextPath}/user/css/style.css" type="text/css" rel="stylesheet" />
				<div class="pageing">
					<ul class="page">
						<li><a href="Managenewsupdate?pageNum=${pageNums -1}"><</a>
						</li>
						<s:iterator begin="pageBean.beginPageIndex"
							end="pageBean.endPageIndex" var="pageNums">
							<li
								class="paginItem ${pageBean.currentPage==pageNums?'current':''}">
								<c:if test="${pageBean.currentPage == pageNums }">
									<a href="#" class="cur">${pageNums }</a>
								</c:if> <c:if test="${pageBean.currentPage != pageNums }">
									<a href="Managenewsupdate?pageNum=${pageNums }">${pageNums }</a>
								</c:if></li>
						</s:iterator>

						<li><a href="Managenewsupdate?pageNum=${pageNums }">></a>
						</li>
					</ul>
					<!-- <ul class="pageingtz">
						<li>跳转：<input type="text" class="input" />&nbsp;页&nbsp;<a
							href="#" class="a13">GO</a></li>
					</ul> -->
				</div>
	</div>
</body>

</html>

