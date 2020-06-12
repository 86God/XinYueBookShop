package com.company.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.project.biz.ShoppingCartBiz;
import com.company.project.biz.impl.ShoppingCartBizImpl;

import oracle.net.aso.s;

/**
 * 删除购物车商品
 */
@WebServlet("/delete-shopping-cart-servlet")
public class DeleteShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteShoppingCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		long id = Long.valueOf(request.getParameter("shoppingCartPoId"));
		System.out.println(id);
		ShoppingCartBiz shoppingCartBiz = new ShoppingCartBizImpl();
		shoppingCartBiz.deleteGoods(id);
		response.sendRedirect("page/dynamic/shopping-cart.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
