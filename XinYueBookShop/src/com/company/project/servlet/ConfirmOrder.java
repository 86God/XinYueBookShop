package com.company.project.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.project.biz.BooksBiz;
import com.company.project.biz.ShoppingCartBiz;
import com.company.project.biz.impl.BooksBizImpl;
import com.company.project.biz.impl.OrderFormBizImpl;
import com.company.project.biz.impl.ShoppingCartBizImpl;
import com.company.project.model.po.BookPo;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;

import oracle.net.aso.l;

/**
 * 在购物车将商品生成订单
 * @author God_86
 *
 */
@WebServlet("/confirm-order")
public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmOrder() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserPo userPo = (UserPo) session.getAttribute("userPo");
	

		Enumeration<String> list = request.getParameterNames();
		
		ArrayList<OrderFormPo> orderFormPoList = new ArrayList<>();
		while (list.hasMoreElements()) {			
			OrderFormBizImpl orderFormBizImpl = new OrderFormBizImpl();
			String key1 = list.nextElement();
			long value1 = Long.valueOf(request.getParameter(key1));
			BookPo bookPo = null;
			if (list.hasMoreElements()) {
				String key2 = list.nextElement();
				long value2 = Long.valueOf(request.getParameter(key2));
				BooksBiz booksBiz = new BooksBizImpl();
				bookPo = booksBiz.findById(value2);
			}
						
			
			int num = 0;
			if (list.hasMoreElements()) {
				String key3 = list.nextElement();
				int value3 = Integer.valueOf(request.getParameter(key3));
				num = value3;
			}
			
			OrderFormPo orderFormPo = orderFormBizImpl.create(bookPo, num, userPo, userPo);
			System.out.println(orderFormPo);
			ShoppingCartBiz shoppingCartBiz = new ShoppingCartBizImpl();
			shoppingCartBiz.deleteGoods(value1);
			orderFormPoList.add(orderFormPo);
		}
		
		request.setAttribute("orderFormPoList", orderFormPoList);
		request.getRequestDispatcher("page/dynamic/confirmOrder.jsp").forward(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
