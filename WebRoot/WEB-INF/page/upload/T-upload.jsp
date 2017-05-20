<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <s:action name="data" id="dataList" executeResult="false" /> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>上传资源</title>
  <%--   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css_admin/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css_admin/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js_admin/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js_admin/jquery.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js_admin/style.js" ></script> --%>
    <style>
	<!--
	.tdLabel {text-align:right;} 
	-->
	</style>
</head>
<body>
  	<s:fielderror></s:fielderror>
        <div class="result-wrap">
        <center>
        	<p style="color: red;">请自觉遵守相关法律法规,上传合法资源,恭喜你成功上传</p>
        	<hr>
            <div class="result-content">
                <form action="upload" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" >
                        <tbody>
                            <%-- <tr>
                                <th width="120px"><i class="require-red">*</i>资源名称：</th>
                                <td>
                                    <input class="common-text required" autocomplete="off" id="title" name="name" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                           <s:select name="claName" list="#dataList.claNameList" label="选择上传的类型"  labelposition="right" />
                            <tr>
                                <th>资源介绍：</th>
                                <td><textarea name="message" autocomplete="off" class="common-textarea" id="content" cols="30" style="width: 80%;height: 250px;" rows="10"></textarea></td>
                            </tr> --%>
                            <tr>
                                <th><i class="require-red">*</i>资源文件：</th>
                                <td><input name="file" id="" type="file"></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="发布" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </center>
        </div>
    
</body>
</html>