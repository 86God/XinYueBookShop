package com.company.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.project.biz.BooksBiz;
import com.company.project.biz.OrderFormBiz;
import com.company.project.biz.UserBiz;
import com.company.project.biz.impl.BooksBizImpl;
import com.company.project.biz.impl.OrderFormBizImpl;
import com.company.project.biz.impl.UserBizImpl;
import com.company.project.model.po.BookPo;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;

/**
 * 购买，在商品页将商品生成订单
 */
@WebServlet("/buy-servelt")
public class BuyServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BuyServelt() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 获取输出流对象
		PrintWriter out = response.getWriter();
		
		ArrayList<OrderFormPo> orderFormPoList = new ArrayList<>();
		
		long bookId = Long.valueOf(request.getParameter("bookId"));
//		String shippingAddress = request.getParameter("shippingAddress");
		int bookNum = Integer.valueOf(request.getParameter("bookNum"));
		
		BooksBiz booksBiz = new BooksBizImpl();
		BookPo bookPo = booksBiz.findById(bookId);
		UserPo userPo = (UserPo)request.getSession().getAttribute("userPo");
		UserPo consignee = userPo;
		OrderFormBiz orderFormBiz = new OrderFormBizImpl();
		OrderFormPo orderFormPo = orderFormBiz.create(bookPo, bookNum, userPo, consignee);
		orderFormPoList.add(orderFormPo);
		System.out.println(orderFormPo);
		
		request.setAttribute("orderFormPoList", orderFormPoList);
		request.getRequestDispatcher("page/dynamic/confirmOrder.jsp").forward(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
