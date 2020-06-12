package com.company.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.project.biz.UserBiz;
import com.company.project.biz.impl.UserBizImpl;
import com.company.project.model.po.UserPo;

/**
 * 注册
 * @author God_86
 *
 */
@WebServlet("/user-register-servlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// 获取输出流对象
		PrintWriter out = response.getWriter();

		long phoneNum = Long.valueOf(request.getParameter("tel"));
		String password = request.getParameter("psw1");
		
		System.out.println("phoneNum" + phoneNum);
		System.out.println("password" + password);
		
		UserBiz userBiz =new UserBizImpl();
		
		UserPo userPo = new UserPo();
		userPo.setPassword(password);
		userPo.setPhoneNum(phoneNum);
		boolean flag = userBiz.reg(userPo);
		request.setAttribute("regFlag", flag);
//		response.sendRedirect("page/enrol.jsp");
		request.getRequestDispatcher("page/static/enrol.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
