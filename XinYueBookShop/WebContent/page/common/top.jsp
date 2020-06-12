<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/page/common/variate.jsp"%>
<tr id="nav" class="nav">
	<td>
		<div id="slogan">读万卷书&nbsp;&nbsp;行万里路</div>
		<table class="operate">
			<tr>
				<td><a href="page/dynamic/index.jsp">首页</a></td>
				<td><a href="<%=shoppoingCartHref%>">购物车</a></td>
				<td><a href="<%=orderHref%>">我的订单</a></td>
				<td><a href="page/static/help-center.jsp">帮助中心</a></td>
				<td><a href="page/static/service.jsp">意见反馈</a></td>
				<td><a href="<%=perInfoHref%>"><%=text%></a></td>
			</tr>
		</table>
	</td>
</tr>
