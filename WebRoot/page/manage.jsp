<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resources/ext-all.css">
	<script type="text/javascript" src="resources/ext-all.js"></script>

  <script type="text/javascript" src="resources/ext-lang-zh_CN.js"></script></head>
  
  <body>
    This is my JSP page. <br>
    <script>
    Ext.onReady(function() {
    	Ext.create('Ext.Viewport',{
    		layout:'fit',
    		items:[{xtype:'panel',
    			title:'欢迎',
    			html:'<h1>hello workd</h1>'}]
    	});
    });</script>
  </body>
</html>
