package com.company.project.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.project.biz.OrderFormBiz;
import com.company.project.biz.impl.OrderFormBizImpl;
import com.company.project.model.po.OrderFormPo;

/**
 * 取消支付处理
 * @author God_86
 *
 */
@WebServlet("/not-pay-servlet")
public class NotPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NotPayServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		ArrayList<OrderFormPo> orderFormPoList = (ArrayList<OrderFormPo>) session.getAttribute("orderFormPoList");
		String username = request.getParameter("username");
		long tel = Long.valueOf(request.getParameter("tel"));
		String address = request.getParameter("address");

		OrderFormBiz orderFormBiz = new OrderFormBizImpl();

		for (OrderFormPo orderFormPo : orderFormPoList) {
			orderFormPo.setShippingAddress(address);
			orderFormPo.setShippingPersonName(username);
			orderFormPo.setShippingPhoneNum(tel);
			orderFormPo.setType("待付款");
			System.out.println(orderFormPo);
			orderFormBiz.insert(orderFormPo);
		}

		response.sendRedirect("page/dynamic/order.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
