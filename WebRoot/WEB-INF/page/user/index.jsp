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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>郑州轻工业学院软件学院实验示范中心</title>
<link
	href="${pageContext.request.contextPath}/newuser/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/newuser/css/master.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/newuser/css/index.css"
	rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
     <style>
    .mlr0{margin-left:0;margin-right:0;}
    </style>
    
</head>

<body>
	<!-- ##########页首########## -->
	<!-- 包含top内容 -->
	<%@include file="top.jspf"%>

	<div class="line theme"></div>

	<!-- ##########主体########## -->
	<div class="container">
		<!-- 栏目 -->
		<div class="row">

			<!-- 公司简介 -->
			<div class="col-md-4">
			<br>
			<br>
				<span class="part1"> <a href="#">中心概括</a> </span> <span
					class="part1 en"> &nbsp;&nbsp;</span>
					<a href="viewcentre" class="btn btn-default btn-xs more-btn">更多&gt;</a>
				<div class="line1">
					<div class="line2 theme"></div>
				</div>
				<div>
					<img class="img-responsive"
						src="${pageContext.request.contextPath}/newuser/images/about-us.jpg"
						alt="中心概括">
					<p class="text1">郑州轻工业学院软件综合实践与创新基地位于河南省郑州市中原区科学大道136号，创新基地多次在省级、国家级各类计算机竞赛中获得优异成绩</p>
				</div>
			</div>

			<!-- 公司新闻 -->
			<div class="col-md-8">
			<br>
			<br>
				<span class="part1"> <a href="#">新闻中心</a> </span> <span
					class="part1 en"> &nbsp;&nbsp;/ News </span> <a href="newsindex"
					class="btn btn-default btn-xs more-btn">更多&gt; </a>
				<div class="line1">
					<div class="line2 theme"></div>
				</div>
				<div class="col-md-6">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators nav-point">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
							<li data-target="#myCarousel" data-slide-to="3"></li>
							<li data-target="#myCarousel" data-slide-to="4"></li>
						</ol>
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner">
							<s:iterator value="pageBeanNews.recordList" begin="0" end="0">
								<div class="item active">
									<!-- active -->
									<a href="newsview?id=${id }"> <img style="width: 350px;height: 260px"
										src="${pageContext.request.contextPath}/uploads/files/${path }"
										alt="news1">
										<div class="carousel-caption nav-title">${titles }</div> </a>
								</div>
							</s:iterator>
							<s:iterator value="pageBeanNews.recordList" begin="1" end="4">
								<div class="item">
									<!-- active -->
									<a href="newsview?id=${id }"> <img style="width: 350px;height: 260px"
										src="${pageContext.request.contextPath}/uploads/files/${path }"
										alt="news1">
										<div class="carousel-caption nav-title">${titles }</div> </a>
								</div>
							</s:iterator>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<ul class="list-unstyled list-new">
						<br>
						<br>
						<li></li>
						<s:iterator value="pageBeanNews.recordList" begin="0" end="4">
							<li class="cur li01">
								<!-- 主选项 =5个 -->
								<dl>
									<dd>
										<a href="newsview?id=${id }">${titles }</a><span><s:date name="date"
													format="yyyy-MM-dd" /> </span>
									</dd>
								</dl>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="row row-2">
			<!-- 公告信息 -->
			<div class="col-md-4">
				<span class="part1"> <a href="#">实验教学</a> </span> <a
					href="labsindex" class="btn btn-default btn-xs more-btn">更多&gt;
				</a>
				<div class="line1">
					<div class="line2 theme"></div>
				</div>
				<div>
					<img class="img-responsive"
						src="${pageContext.request.contextPath}/newuser/image1/lab.png"
						alt="实验教学">
						<div style="position:absolute;top: 80px;left: 180px;font-family: '黑体';font-size: 32px;">实验教学</div>
					<ul class="list-unstyled list-new">
						<%-- <s:property value="pageBeanLabs.recordList.get(0).getId"/> --%>
						<s:iterator value="pageBeanLabs.recordList" begin="0" end="4">
							<li>
								<dl>
									<dt class="messdt"></dt>
									<a href="labsdesc?id=${id }" title="${titles }">
										<dd>
											${titles } <span class="title04"> <s:date name="date"
													format="yyyy-MM-dd" /> </span>
										</dd> </a>
								</dl></li>
						</s:iterator>
						</li>
					</ul>
				</div>
			</div>

			<!-- 技术中心 -->
			<div class="col-md-4">
				<span class="part1"> <a href="#">申报材料</a> </span> <span
					class="part1 en"> &nbsp;&nbsp;</span> <a href="reportindexs"
					class="btn btn-default btn-xs more-btn">更多&gt; </a>
				<div class="line1">
					<div class="line2 theme"></div>
				</div>
				<div>
					<img class="img-responsive"
						src="${pageContext.request.contextPath}/newuser/image1/up.png"
						alt="公告信息">
						<div style="position:absolute;top: 80px;left: 180px;font-family: '黑体';font-size: 32px;">申报材料</div>
					<ul class="list-unstyled list-new">
						<s:iterator value="pageBeanReports.recordList" begin="0" end="4">
							<a href="reportview?id=${id }">
								<li>
									<dl>
										<dt class="perdt"></dt>
										<dd>
											${titles } <span class="title04"> <s:date name="date"
													format="yyyy-MM-dd" /> </span>
										</dd>
									</dl></li> </a>
						</s:iterator>
						</li>
					</ul>
				</div>
			</div>

			<!-- 采购需求 -->
			<div class="col-md-4">
				<span class="part1"> <a href="#">规章制度</a> </span> <span
					class="part1 en"> &nbsp;&nbsp;</span> <a href="ruleall"
					class="btn btn-default btn-xs more-btn">更多&gt; </a>
				<div class="line1">
					<div class="line2 theme"></div>
				</div>
				<div>
					<img class="img-responsive"
						src="${pageContext.request.contextPath}/newuser/image1/ruloes.png"
						alt="公告信息">
						<div style="position:absolute;top: 80px;left: 180px;font-family: '黑体';font-size: 32px;">规章制度</div>
					<ul class="list-unstyled list-new">
						<s:iterator value="pageBeanRules.recordList" begin="0" end="4">
						<a href="ruledesc?id=${id }"
											title="${titles }">
							<li>
								<dl>
									<dt class="filedt"></dt>
									<dd>
										${titles } <span class="title04"><s:date
												name="date" format="yyyy-MM-dd" />
										</span>
									</dd>
								</dl>
							</li>
							</a>
						</s:iterator>
						</li>
					</ul>
				</div>
			</div>




			<div class="row">
				<!-- 友情链接 -->
				<div class="col-md-12">
					<h6>相关链接：</h6>
					<ul class="list-inline youq-li">
						<li><a href="http://www.zzuli.edu.cn/"><img
						style="width: 250px;height: 105px"
								src="${pageContext.request.contextPath}/newuser/images/school.png">
						</a>
						</li>
						<li><a href="http://soft.zzuli.edu.cn/"><img
						style="width: 250px;height: 105px"
								src="${pageContext.request.contextPath}/newuser/images/collage.png">
						</a>
						</li>
						<li><a href="http://172.20.28.243"><img
						style="width: 250px;height: 105px"
								src="${pageContext.request.contextPath}/newuser/images/center.png">
						</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- ##########主体（end）########## -->

		<%@include file="button.jspf"%>



		<script
			src="${pageContext.request.contextPath}/newuser/js/jquery-1.11.1.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/newuser/js/bootstrap.min.js"></script>
		<script>
			/*导航条标题点击事件*/
			$(".dropdown-toggle").click(function() {

				if ($(this).attr('href')) {
					window.location = $(this).attr('href');
				}

			});

			/*广告轮播*/
			$(function() {
				$('#ad-carousel').carousel();
				$('#menu-nav .navbar-collapse a').click(
						function(e) {
							var href = $(this).attr('href');
							var tabId = $(this).attr('data-tab');
							if ('#' !== href) {
								e.preventDefault();
								$(document)
										.scrollTop($(href).offset().top - 70);
								if (tabId) {
									$('#feature-tab a[href=#' + tabId + ']')
											.tab('show');
								}
							}
						});
			});

			/*导航条*/
			$(function() {
				$(".dropdown").mouseover(function() {

					$(this).addClass("open");
				});

				$(".dropdown").mouseleave(function() {

					$(this).removeClass("open");
				});
			});
		</script>
</body>
</html>

