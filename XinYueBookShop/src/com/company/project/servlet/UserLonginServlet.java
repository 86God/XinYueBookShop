package com.company.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.project.biz.UserBiz;
import com.company.project.biz.impl.UserBizImpl;
import com.company.project.model.po.UserPo;

/**
 * 登录
 * @author God_86
 *
 */
@WebServlet("/user-login-servlet")
public class UserLonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;

	public UserLonginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 获取输出流对象
		PrintWriter out = response.getWriter();

		long phoneNum = Long.valueOf(request.getParameter("tel"));
		String password = request.getParameter("psw");

//		System.out.println("phoneNum:" + phoneNum);
//		System.out.println("password:" + password);

		UserBiz userBiz = new UserBizImpl();
		boolean flag = userBiz.login(phoneNum, password);
		request.setAttribute("loginFlag", flag);
//		response.sendRedirect("page/enrol.jsp");

		if (flag) {
			HttpSession session = request.getSession();
			UserPo userPo = userBiz.getPersonalData(phoneNum);
			session.setAttribute("userPo", userPo);
			
			request.getRequestDispatcher("page/dynamic/index.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("page/static/login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
