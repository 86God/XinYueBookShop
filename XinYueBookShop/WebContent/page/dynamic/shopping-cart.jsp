<%@page import="com.company.project.model.po.OrderFormPo"%>
<%@page import="com.company.project.biz.impl.BooksBizImpl"%>
<%@page import="com.company.project.biz.BooksBiz"%>
<%@page import="com.company.project.model.po.BookPo"%>
<%@page import="com.company.project.model.po.ShoppingCartPo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.project.biz.impl.ShoppingCartBizImpl"%>
<%@page import="com.company.project.biz.ShoppingCartBiz"%>
<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserPo userPo = (UserPo) request.getSession().getAttribute("userPo");
	ShoppingCartBiz shoppingCartBiz = new ShoppingCartBizImpl();
	ArrayList<ShoppingCartPo> shoppingCartPoList = shoppingCartBiz.lookOwnShoppingCart(userPo.getId());
	BooksBiz booksBiz = new BooksBizImpl();
%>


<html>
<head>
<meta charset="UTF-8">
<title>【新悦书城】我的购物车</title>
<%@include file="/page/common/basePath.jsp"%>

<script type="text/javascript">
	function addNum(i) {	
		var bookNum = document.getElementById("num"+i);
		var sumPrice = document.getElementById("sumPrice"+i);
		var price = document.getElementById("price"+i);
		bookNum.value++;
		sumPrice.value = bookNum.value * price.value;
		calcSumPrice();
	}

	function subNum(i) {
		var bookNum = document.getElementById("num"+i);
		var sumPrice = document.getElementById("sumPrice"+i);
		var price = document.getElementById("price"+i);
		if (bookNum.value > 0){
			bookNum.value--;
			sumPrice.value = bookNum.value * price.value;
		}
		calcSumPrice();	
	}
	
	function delete_confirm(i) 
	{
		if(window.confirm('你确定要将该商品移除购物车？')){
	    	console.log("点击了确定");		    	  
	    	  return true;
	    }else{
	    	console.log("点击了取消");
	    	return false;
	    }
		calcSumPrice();
	}
	
	function allCh() {
		var allChange = document.getElementById("allChange");
		console.log(allChange.checked);
		for(var i =0;i< <%=shoppingCartPoList.size()%>;i++){
			var change = document.getElementById("select"+i);
			change.checked=allChange.checked;
		}
		calcSumPrice();
	}
	
	function pitchOn() {
		calcSumPrice();
	}
	
	function calcSumPrice(){
		var sum = 0;
		for(var i =0;i< <%=shoppingCartPoList.size()%>;i++){
			var change = document.getElementById("select"+i);
			var sumPrice = document.getElementById("sumPrice"+i);
			if( change.checked== true){
				sum += parseInt(sumPrice.value);
			}
		}
		var sumPriceText = document.getElementById("sumPriceText");
		sumPriceText.value = sum;
	}
	
	function confirmOrder() {
		var OrderList = new Array();
		var url="?";
		for(var i =0;i< <%=shoppingCartPoList.size()%>;i++){
			
			var shopCart = document.getElementById("shopCart"+i).innerText;
			var bookId = document.getElementById("bookId"+i).innerText;
			var change = document.getElementById("select"+i);
			var bookNum = document.getElementById("num"+i).value; 
			var sumPrice = document.getElementById("sumPrice"+i);
			
			if( change.checked== true){
				url += "shopCart"+i+"="+shopCart+"&bookId"+i+"="+bookId+"&bookNum"+i+"="+bookNum+"&";
				
			}
			
		}
		if(url!="?")
		location.href='confirm-order'+url;
		
	}
	
</script>

</head>
<body>
	<form action="confirm-order" method="get">
		<table id="container" class="container">
			<%@include file="/page/common/top.jsp"%>
			<tr id="main" class="main-shop">
				<td>
					<table class="main3">
						<tr id="top" class="top">
							<td>
								<h1>
									新悦<span>·我的购物车</span>
								</h1>
							</td>
						</tr>
						<tr id="bottom" class="bottom">
							<td>
								<div id="shop">
									<table>
										<tr class="head">
											<td><input type="checkbox" value="all" id="allChange"
												name="allChange" onclick="allCh()" />全选</td>
											<td>编号</td>	
											<td>图书编号</td>
											<td>商品</td>
											<td>书名</td>
											<td>单价</td>
											<td>数量</td>
											<td>金额</td>
											<td>操作</td>
										</tr>

										<%
											for (int i = 0; i < shoppingCartPoList.size(); i++) {
												BookPo bookPo = booksBiz.findById(shoppingCartPoList.get(i).getBookId());
										%>
										<tr class="list">
											<td><input type="checkbox" value="select1"
												name="select<%=i%>" id="select<%=i%>"
												onclick="calcSumPrice()" /></td>
											<td><span id="shopCart<%=i%>"><%=shoppingCartPoList.get(i).getId()%></span></td>	
											<td><span id="bookId<%=i%>"><%=bookPo.getId()%></span></td>
											<td><a href="<%=detailsHref %>?bookPoId=<%=bookPo.getId()%>">
													<img src="<%=bookPo.getBookImg()%>" />
												</a></td>

											<td><a href="#"><span><%=bookPo.getName()%></span></a></td>
											<td><input type="text" id="price<%=i%>"
												value="<%=bookPo.getPrice()%>" readonly="readonly"
												style="border: none;"></td>
											<td><input type="button" id="" onclick="subNum(<%=i%>)"
												value="-" /> <input type="text" id="num<%=i%>"
												value="<%=shoppingCartPoList.get(i).getBookNum()%>"
												readonly="readonly" /> <input type="button" id=""
												onclick="addNum(<%=i%>)" value="+" /></td>
											<%
												float sum = bookPo.getPrice() * shoppingCartPoList.get(i).getBookNum();
											%>
											<td><input type="text" id="sumPrice<%=i%>"
												value="<%=sum%>" readonly="readonly" style="border: none;">
											</td>

											<td><a
												href="delete-shopping-cart-servlet?shoppingCartPoId=<%=shoppingCartPoList.get(i).getId()%>"
												onclick="delete_confirm()">删除</a></td>
										</tr>
										<%
											}
										%>

										<tr class="foot" id="settle-accounts-tr">
											<td colspan="7" id="settle-accounts-td"><span
												id="settle-accounts-span">合计：￥ <input type="text"
													value="0" id="sumPriceText" name="sumPriceText"
													readonly="readonly"
													style="border: none; text-align: center;" />

											</span> <input type="button" value="结算" id="settle-accounts-button"
												onclick="confirmOrder()" /></td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<%@include file="/page/common/bottom.jsp"%>
		</table>
	</form>
</body>
</html>
