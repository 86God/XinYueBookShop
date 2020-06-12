<%@page import="com.company.project.model.po.BookPo"%>
<%@page import="com.company.project.biz.impl.BooksBizImpl"%>
<%@page import="com.company.project.biz.BooksBiz"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.project.model.po.OrderFormPo"%>
<%@page import="com.company.project.biz.impl.OrderFormBizImpl"%>
<%@page import="com.company.project.biz.OrderFormBiz"%>
<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	UserPo userPo = (UserPo) request.getSession().getAttribute("userPo");
	OrderFormBiz orderFormBiz = new OrderFormBizImpl();
	String type = request.getParameter("type");
	ArrayList<OrderFormPo> orderFormPoList = null;
	if(type==null || type==""){
		orderFormPoList = orderFormBiz.findByUserId(userPo.getId());
	}else{
		orderFormPoList = orderFormBiz.findByUserIdAndType(userPo.getId(), type);
	}
	BooksBiz booksBiz = new BooksBizImpl();	
%>	



<html>

<head>
<meta charset="UTF-8">
<title>【新悦书城】我的订单</title>
<%@include file="/page/common/basePath.jsp"%>
<script type="text/javascript">
function delete_shopping_cart() {
	if(window.confirm('你确定要将该订单删除？')){
    	console.log("点击了确定");		    	  
    	  return true;
    }else{
    	console.log("点击了取消");
    	return false;
    }
}

</script>
</head>

<body>
	<form>
		<table id="container" class="container">
			<%@include file="/page/common/top.jsp"%>
			<tr id="main" class="main-PerInfo">
				<td>
					<table class="main3">
						<tr id="top" class="top">
							<td>
								<h1>
									新悦<span>·我的订单</span>
								</h1>
							</td>
						</tr>
						<tr id="bottom" class="bottom">
							<td><%@include file="/page/common/perInfoMenu.jsp"%>
								<div id="order-right" class="right">
									<h2 class="">&nbsp;&nbsp;个人中心>我的订单</h2>
									<table cellpadding="1vw" border="1">
										<%@include file="/page/common/orderType.jsp" %>
										<tr class="list">
											<td colspan="5">
												<table>
													<tr id="bottom" class="bottom">
														<td>
															<div id="shop">
																<table style="font-size: 15px;">
																	<tr class="head">
																		<td>订单号</td>
																		<td>商品</td>
																		<td>书名</td>
																		<td>单价</td>
																		<td>数量</td>
																		<td>金额</td>
																		<td>状态</td>
																		<td>操作</td>
																	</tr>
																	
																	<%
																	if(orderFormPoList!=null)
																	for(int i = 0;i<orderFormPoList.size();i++){
																		BookPo bookPo = booksBiz.findById(orderFormPoList.get(i).getBookId());
																	%>
																	<tr class="list">
																		<td><%=orderFormPoList.get(i).getId() %></td>
																		<td><a href="page/dynamic/orderDetails.jsp?orderId=<%=orderFormPoList.get(i).getId() %>"><img src="<%=bookPo.getBookImg() %>" /></a></td>
																		<td><a href="#"><%=bookPo.getName() %></a></td>
																		<td><%=bookPo.getPrice() %></td>
																		<td><%=orderFormPoList.get(i).getBookNum() %></td>
																		<td><%=orderFormPoList.get(i).getMoney() %></td>
																		<td><%=orderFormPoList.get(i).getType() %></td>
																		<td><a href="delete-order-servlet?orderPoId=<%=orderFormPoList.get(i).getId()%>"
																		onclick="delete_shopping_cart()">删除</a></td>
																	</tr>
																	<%
																	}
																	%>


																</table>
															</div>
														</td>
													</tr>
												</table>

											</td>
										</tr>
									</table>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
			<%@include file="/page/common/bottom.jsp"%>
		</table>
	</form>
</body>

</html>
