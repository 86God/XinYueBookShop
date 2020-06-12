<%@page import="com.company.project.model.po.BookPo"%>
<%@page import="com.company.project.biz.impl.BooksBizImpl"%>
<%@page import="com.company.project.biz.BooksBiz"%>
<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	long id = 0l;
	String idStr = request.getParameter("bookPoId");
	if(idStr == null){
		id = Long.parseLong(request.getParameter("bookId"));
	}else{
		id = Long.parseLong(idStr);
	}
	System.out.println("id:" + id);
	BooksBiz booksBiz = new BooksBizImpl();
	BookPo bookPo = booksBiz.findById(id);
	
	String addSCalertText = "";
	if (request.getAttribute("addShoppingCartFlag")!=null) {
		if ((Boolean)request.getAttribute("addShoppingCartFlag")) {
			addSCalertText = "添加购物车成功";
		} else {
			addSCalertText = "添加购物车失败";
		}
	}
	request.setAttribute("addSCalertText", addSCalertText);

	if (request.getAttribute("addSCalertText") != "") {
 %>
	<script>
		alert("<%=addSCalertText%>");
	</script>
<% 
	}
%>



<html>
<head>
<meta charset="UTF-8">
<title>【新悦书城】</title>
<%@include file="/page/common/basePath.jsp"%>

<script type="text/javascript">

	function addNum() {
		var bookNum = document.getElementById("num");
		console.log(bookNum);
		console.log(<%=bookPo.getRepertoryNumber()%>
	);
		if (bookNum.value <<%=bookPo.getRepertoryNumber()%>) {
			bookNum.value++;
		}
	}

	function subNum() {
		var bookNum = document.getElementById("num");
		console.log(bookNum);
		if (bookNum.value > 0) {
			bookNum.value--;
		}
	}

	function buyBooks() {
		var detailsFrom = document.getElementById("detailsFrom");
		detailsFrom.action="buy-servelt";
		detailsFrom.submit();
	}
	
	function addBooksShoopingCart() {
		var detailsFrom = document.getElementById("detailsFrom");
		detailsFrom.action="add-shopping-cart";
		detailsFrom.submit();
		
	}
	
</script>

</head>
<body>

	<table id="container" class="container">
		<%@include file="/page/common/top.jsp"%>
		<tr id="main" class="main-index">
			<td>
				<table class="main1">
					<tr id="top" class="top">
						<td>
							<h1>新悦书城</h1>
						</td>
					</tr>
					<tr id="bottom" class="bottom-detail">
						<td>
							<div class="left">
								<img class="l" src="<%=bookPo.getBookImg()%>" alt="">
							</div>
							<div id="right" class="right">
								<div id="title" class="title">
									<h5><%=bookPo.getName()%></h5>
									<p><%=bookPo.getIntroduction()%></p>
								</div>
								<form id="detailsFrom" action="" method="get">
									<table class="detail">
										<tr>
											<td colspan="3" >图书编号:&nbsp;&nbsp;<span><input type="text" class="f4" name="bookId" readonly="readonly"
												value="<%=bookPo.getId()%>" /></span></td>
											
										</tr>
										<tr>
											<td colspan="3" >作者:&nbsp;&nbsp;<span><%=bookPo.getAuthor()%></span></td>
										</tr>
										<tr>
											<td colspan="3" >类型:&nbsp;&nbsp;<span><%=bookPo.getType()%></span></td>
										</tr>
										<tr>
											<td colspan="3" >出版社:&nbsp;&nbsp;<span><%=bookPo.getPublishingHouse()%></span></td>
										</tr>
										<tr class="f">
											<td class="f1">价格</td>
											<td colspan="3"><span class="f2">￥<%=bookPo.getPrice()%></span></td>
										</tr>
										
										<tr class="f">
											<td class="f3">商户</td>
											<td>
												<p>新悦书城线上自营(陕西省)</p>
											</td>
										</tr>
									</table>
									<table class="detail2">
										<tr class="m1">
											<td class="m2">数量</td>
											<td class="m3">
											<input type="button" id="sub"
												class="crease" value="-" onclick="subNum()"
												style="text-align: center;" /> 
											<input type="text" name="bookNum"
												class="num" id="num" value="1" style="text-align: center;" />
											<input type="button" id="add" class="crease" value="+"
												onclick="addNum()" style="text-align: center;" />
											</td>
											<td>(库存：<%=bookPo.getRepertoryNumber()%>件)
											</td>
										</tr>

										<tr class="m4">
											<td colspan="3">
													<input id="addShoopingCart"
													type="button" class="btn" value="加入购物车"
													onclick="addBooksShoopingCart()" /> 
													<input
													id="buy" type="button" class="btn1"
													value="立即购买"  onclick="buyBooks()"/></td>
										</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<%@include file="/page/common/bottom.jsp"%>
	</table>
</body>

</html>
