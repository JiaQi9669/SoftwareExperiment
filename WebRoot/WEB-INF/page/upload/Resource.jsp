<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:action name="data" id="dataList" executeResult="false" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>个人管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css_admin/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css_admin/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js_admin/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js_admin/jquery.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js_admin/style.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js_admin/jquery-1.11.1.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js_admin/jquery-1.11.2.js" ></script>
    <script src="${pageContext.request.contextPath }/js_admin/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/pages.css" type="text/css"></link>
   <style type="text/css">
   		table{
   			text-align: center;
   		}
   </style>
</head>
<body>
    
    <div class="search-wrap">
        <div class="search-content">
            <form action="datafindByName" method="post">
                <table class="search-tab">
                    <tr>
                        <th width="70">搜索:</th>
                        <td><input class="common-text" placeholder="关键字" name="name" id="" type="text"></td>
                        <td><input class="btn btn-primary btn2" type="submit" value="搜索"></td>
                        <td><a href="dataupload"><i class="icon-font"></i>上传资源</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    
    <!-- begin by JiaQi -->
    <div class="result-wrap">
            <div class="result-content">
                <table class="result-tab" width="100%">
                	<tr>
                		<th colspan="5" style="text-align: center;">资源一览</th>
                	</tr>
                    <tr>
                        <th>资源名称</th>
                        <th>上传时间</th>
                        <th>上传人</th>
                        <th>下载次数</th>
                        <th>操作</th>
                    </tr>
                    <tr>
		            <s:iterator value="pageBean.recordList">
				        <tr>
					         <td><a href="dataintroduce?message=${message }&name=${name }&url=${url }&url_data=${url_data }" >${name }</a></td> <!--标签名称-->
					         <td>${dates }</td>
					         <td>${friends }</td>
					         <td>${down_num }</td>
					         <td>
								<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			  					<!-- 构建一个url -->
			  					<c:url var="url" value="datadowns">
			  						<c:param name="fileName" value="${url_data }"></c:param>
			  						<c:param name="id" value="${id }"></c:param>
			  					</c:url>
			  					<!-- down_download?fileName&id --> --%>
			  					<a href="down_download?fileName=Capture001.png">下载</a>
			  				 </td>
				       </tr>
		           </s:iterator>
                </table>
                <a href="down_down?fileName=Capture001.png">下载</a>
                <img alt="" src="${pageContext.request.contextPath }/uploads/files/Capture001.png" style="w">
            </div>
    </div>
    
    <div class="pagin">
		<div class="message">
			共<i class="blue_page"><s:property value="pageBean.pageCount" />
			</i>页， <i class="blue_page">
			<s:property value="pageBean.recordCount" />
			</i>条记录， 当前显示第&nbsp;<i class="blue_page">
			<s:if test="pageBean.currentPage == 0">
				1
			</s:if>
			<s:else>
				<s:property value="pageBean.currentPage" />
			</s:else>&nbsp;</i>页
			
		</div>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!--真分页遍历  -->
		<ul class="paginList">
			<s:iterator begin="pageBean.beginPageIndex"
				end="pageBean.endPageIndex" var="pageNums">
				<li class="paginItem ${pageBean.currentPage==pageNums?'current':''}">
					<c:if test="${pageBean.currentPage == pageNums }"><a>${pageNums }</a></c:if>
					<c:if test="${pageBean.currentPage != pageNums }">
						<c:if test="${datasPage != 1 }">
							<a href="dataview?pageNum=${pageNums }">${pageNums }</a>
						</c:if>
						<c:if test="${datasPage == 1 }">
							<a href="datafindByName?pageNum=${pageNums }&name=${names }">${pageNums }</a>
						</c:if>
					</c:if>
				</li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>