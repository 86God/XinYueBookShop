<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() 
			+ "://" + request.getServerName() 
			+ ":" + request.getServerPort()
			+ request.getContextPath()
			+ "/";
%>
<!-- base标签，指的页面打开默认地址 -->
<base href="<%=basePath%>"/>
<link type="text/css" rel="stylesheet" href="css/all.css" />
<link type="text/css" rel="stylesheet" href="css/paging.css" />
