<%@page import="com.company.project.biz.impl.UserBizImpl"%>
<%@page import="com.company.project.biz.UserBiz"%>
<%@page import="com.company.project.biz.impl.OrderFormBizImpl"%>
<%@page import="com.company.project.biz.OrderFormBiz"%>
<%@page import="oracle.net.aso.f"%>
<%@page import="com.company.project.biz.impl.BooksBizImpl"%>
<%@page import="com.company.project.biz.BooksBiz"%>
<%@page import="com.company.project.model.po.BookPo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.project.model.po.OrderFormPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%

OrderFormBiz orderFormBiz = new OrderFormBizImpl();
OrderFormPo orderFormPo = orderFormBiz.findById(Long.valueOf(request.getParameter("orderId")));
ArrayList<OrderFormPo> orderFormPoList = new ArrayList();
orderFormPoList.add(orderFormPo);
BooksBiz booksBiz = new BooksBizImpl();
float sumPrice = 0;
boolean flag = false;
%>	
	

<html>
	<head>
		<meta charset="UTF-8">
		<title>【新悦书城】个人信息</title>
		<%@include file="/page/common/basePath.jsp" %>
		<script type="text/javascript">
		function payment() {
			var tipMsg = "";
			var username = document.getElementById("username").value;
			var phoneNum = document.getElementById("tel").value;
			var address = document.getElementById("address").value;
			var paymentForm = document.getElementById("paymentForm");
			
			
			var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;

			if (!myreg.test(phoneNum)) {
				tipMsg = tipMsg + "手机号码格式不正确!";
			}	
			
			if (tipMsg == "") {
				console.log("输入正确");
				if(window.confirm('你确定要付款？')){							
			    	console.log("点击了确定");	 
			    	<% session.setAttribute("payFlag", true);
					 session.setAttribute("orderFormPoList", orderFormPoList);					 
					 %>
					 paymentForm.submit();
			    }else{	    	
			    	
			    }	

			}else{
				alert(tipMsg);
			}					
		}		
		</script>
		
	</head>
	<body>
			<table id="container" class="container">
				<%@include file="/page/common/top.jsp" %>
				<tr id="main" class="main-PerInfo">
					<td>
						<table class="main3">
							<tr id="top" class="top">
								<td>
									<h1>新悦<span>·确定订单</span></h1>
								</td>
							</tr>
							<tr id="bottom" class="bottom">
								<td>
									<div class="right" style="float: inherit;margin: auto;">
										<h2 class="">收货人信息</h2>
										<form action="one-pay-servlet" method="post" target="_parent" id="paymentForm" name="paymentForm">
											<table style="height: 20vh;">
												<tr>
													<td class="l">收货人姓名：</td>
													<td><input type="text" value="<%=orderFormPo.getShippingPersonName() %>" name="username" id="username" class="t" /></td>
												</tr>

												<tr>
													<td class="l">手机号：</td>
													<td><input type="text" maxlength="11" value="<%=orderFormPo.getShippingPhoneNum() %>" name="tel" id="tel" class="t" /></td>
												</tr>
												<tr>
													<td class="l">收货地址：</td>
													<td><input type="text" value="<%=orderFormPo.getShippingAddress() %>" name="address" id="address" class="t1" /></td>
												</tr>
											</table>
											<tr id="main" class="main-shop">
												<td>
													<table class="main3">
														<tr id="bottom" class="bottom">
															<td>
																<div id="shop">
																	<table>
																		<tr class="head">
																			
																			<td>商品</td>
																			<td>书名</td>
																			<td>单价</td>
																			<td>数量</td>
																			<td>金额</td>
																		</tr>
																		<%
																		for(int i = 0;i<orderFormPoList.size();i++){
																			BookPo bookPo = booksBiz.findById(orderFormPoList.get(i).getBookId());
																			sumPrice += orderFormPoList.get(i).getMoney();
																			%>
																		<tr class="list">
																			
																			
																			<td><a href="<%=detailsHref %>?bookPoId=<%=bookPo.getId()%>">
																					<img src="<%=bookPo.getBookImg()%>" />
																				</a></td>
																			<td>
																				<span><%=bookPo.getName() %></span>
																			</td>
																			<td><%=bookPo.getPrice() %></td>
																			<td>
																				<span><%=orderFormPoList.get(i).getBookNum() %></span>
																			</td>
																			<td>
																				<span><%=orderFormPoList.get(i).getMoney() %></span>
																			</td>

																		</tr>	
																			<%
																			if(orderFormPoList.get(i).getType().equals("待付款")){
																				%>
																				<tr class="foot">
																			<td colspan="7">
																				<span>合计：￥<span class="span"><%=sumPrice %></span></span>
																				<input type="button" value="结算"  onclick="payment()"/>
																			</td>
																		</tr>
																				<%
																			}
																		}
																		%>
																		
																		
																	</table>
																</div>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</form>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<%@include file="/page/common/bottom.jsp" %>
			</table>
	</body>

</html>