package com.company.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * ¸ÄÃÜ
 * @author God_86
 *
 */
@WebServlet("/user-change-pw-servlet")
public class UserChangePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserChangePwServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		UserPo oldUserPo = (UserPo)session.getAttribute("userPo");

		String oldPw = request.getParameter("oldPassword");
		String newPw = request.getParameter("newPassWord1");
		oldUserPo.setPassword(oldPw);	

		System.out.println("oldPassword:" + oldUserPo.getPassword());
		System.out.println("newPassword:"+ newPw);

		
		UserBiz userBiz = new UserBizImpl();
		
		boolean updatePassWordFlag = userBiz.updatePassWord(oldUserPo, newPw);
		
		request.setAttribute("updatePassWordFlag", updatePassWordFlag);
		request.getRequestDispatcher("page/static/changePw.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
