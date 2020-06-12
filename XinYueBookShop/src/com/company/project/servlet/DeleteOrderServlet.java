package com.company.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.project.biz.OrderFormBiz;
import com.company.project.biz.ShoppingCartBiz;
import com.company.project.biz.impl.OrderFormBizImpl;
import com.company.project.biz.impl.ShoppingCartBizImpl;

/**
 * É¾³ý¶©µ¥
 * @author God_86
 *
 */
@WebServlet("/delete-order-servlet")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteOrderServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long id = Long.valueOf(request.getParameter("orderPoId"));
		System.out.println(id);
		OrderFormBiz orderFormBiz = new OrderFormBizImpl();
		orderFormBiz.delete(id);
		response.sendRedirect("page/dynamic/order.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
