<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.company.project.model.po.UserPo"%>    





<%
	UserPo userpo = (UserPo) session.getAttribute("userPo");
	//根据登录状态切换按键和链接（登录注册 /用户名）
	String text = "登录/注册";
	String perInfoHref = "page/static/login.jsp";
	String shoppoingCartHref = "page/static/login.jsp"; 
	String orderHref = "page/static/login.jsp";
	String detailsHref = "page/static/login.jsp";

	
	
	if (userpo != null) {
		text = userpo.getUserName();
		perInfoHref = "page/static/perInfo.jsp";
		shoppoingCartHref = "page/dynamic/shopping-cart.jsp";
		orderHref = "page/dynamic/order.jsp";
		detailsHref = "page/dynamic/details.jsp";
	}
%>
