package com.company.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.project.biz.BooksBiz;
import com.company.project.biz.OrderFormBiz;
import com.company.project.biz.ShoppingCartBiz;
import com.company.project.biz.impl.BooksBizImpl;
import com.company.project.biz.impl.OrderFormBizImpl;
import com.company.project.biz.impl.ShoppingCartBizImpl;
import com.company.project.model.po.BookPo;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.ShoppingCartPo;
import com.company.project.model.po.UserPo;

/**
 * 添加购物车
 * @author God_86
 *
 */
@WebServlet("/add-shopping-cart")
public class AddShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddShoppingCart() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取输出流对象
		PrintWriter out = response.getWriter();
		
		long bookId = Long.valueOf(request.getParameter("bookId"));
		String shippingAddress = request.getParameter("shippingAddress");
		int bookNum = Integer.valueOf(request.getParameter("bookNum"));
		
//		System.out.println("bookId:"+ bookId);
//		System.out.println("shippingAddress:"+ shippingAddress);
//		System.out.println("bookNum:"+ bookNum);

		UserPo userPo = (UserPo)request.getSession().getAttribute("userPo");
		
		ShoppingCartPo shoppingCartPo = new ShoppingCartPo();
		shoppingCartPo.setUserId(userPo.getId());
		shoppingCartPo.setBookNum(bookNum);
		shoppingCartPo.setBookId(bookId);
		
		ShoppingCartBiz shoppingCartBiz = new ShoppingCartBizImpl();
		boolean flag = shoppingCartBiz.insertGoodsToCart(shoppingCartPo);
		request.setAttribute("addShoppingCartFlag", flag);
		request.setAttribute("bookPoId", bookId);
		request.getRequestDispatcher("page/dynamic/details.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
