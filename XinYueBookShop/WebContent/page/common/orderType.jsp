<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<tr class="head">
	<td><a href="page/dynamic/order.jsp" target="order"><input
			value="全部订单" type="button"></a></td>
	<td><a href="page/dynamic/order.jsp?type=待付款" target="order"><input
			value="待付款" type="button"></a></td>
	<td><a href="page/dynamic/order.jsp?type=待发货" target="order"><input
			value="待发货" type="button"></a></td>
	<td><a href="page/dynamic/order.jsp?type=待确认收货" target="order"><input
			value="待确认收货" type="button"></a></td>
	<td><a href="page/dynamic/order.jsp?type=退货/退款中" target="order"><input
			value="退货/退款中" type="button"></a></td>
</tr>