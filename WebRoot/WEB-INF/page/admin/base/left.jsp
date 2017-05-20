<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript"
	src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop">
		<span></span>信息
	</div>

	<dl class="leftmenu">

		<dd>
			<div class="title">
				<span><img src="${pageContext.request.contextPath}/admin/images/leftico01.png" />
				</span>中心概括
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Managecenterupdate"
					target="rightFrame">概括管理</a><i></i>
				</li>
				<li><cite></cite><a href="Managecenterhistory"
					target="rightFrame">下架管理</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${pageContext.request.contextPath}/admin/images/leftico01.png" />
				</span>新闻中心
			</div>
			<ul class="menuson">
				<!-- <li><cite></cite><a href="Managenewsadd"
					target="rightFrame">添加新闻</a><i></i>
				</li> -->
				<li><cite></cite><a href="Managenewsupdate"
					target="rightFrame">新闻管理</a><i></i>
				</li>
				<li><cite></cite><a href="Managenewshistory"
					target="rightFrame">下架新闻</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/admin/images/leftico01.png" />
				</span>实验教学
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Managelabsupdate"
					target="rightFrame">条目管理</a><i></i>
				</li>
				<li><cite></cite><a href="Managelabshistory"
					target="rightFrame">下架条目</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${pageContext.request.contextPath}/admin/images/leftico01.png" />
				</span>规章制度
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Manageruleupdate"
					target="rightFrame">制度管理</a><i></i>
				</li>
				<li><cite></cite><a href="Managerulehistory"
					target="rightFrame">下架制度</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="${pageContext.request.contextPath}/admin/images/leftico01.png" />
				</span>实验仪器
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Managedeviceupdate"
					target="rightFrame">仪器管理</a><i></i>
				</li>
				<li><cite></cite><a href="Managedevicehistory"
					target="rightFrame">下架仪器</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/admin/images/leftico01.png" />
				</span>申报材料
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Managereportupdate"
					target="rightFrame">申报管理</a><i></i>
				</li>
				<li><cite></cite><a href="Managereporthistory"
					target="rightFrame">下架材料</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/admin/images/leftico01.png" />
				</span>师资队伍
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Manageteacherupdate"
					target="rightFrame">教师管理</a><i></i>
				</li>
				<li><cite></cite><a href="Manageteacherhistory"
					target="rightFrame">历史管理</a><i></i>
				</li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img
					src="${pageContext.request.contextPath}/admin/images/leftico01.png" />
				</span>账号管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="Userupdate"
					target="rightFrame">修改密码</a><i></i>
				</li>
				<li><cite></cite><a href="Useradd"
					target="rightFrame">添加账号</a><i></i>
				</li>
			</ul>
		</dd>
	</dl>

</body>
</html>
