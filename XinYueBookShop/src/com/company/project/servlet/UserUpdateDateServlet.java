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
 * 用户更新个人信息
 * @author God_86
 *
 */
@WebServlet("/user-update-date-servlet")
public class UserUpdateDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserUpdateDateServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// 获取输出流对象
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		long phoneNum = Long.valueOf(request.getParameter("tel"));
		String userName = request.getParameter("username");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex").equals("boy") ? "男" : "女";
		String address = request.getParameter("address");

		UserPo userpo = (UserPo) session.getAttribute("userPo");
		long id = userpo.getId();

		UserPo newUser = new UserPo();
		newUser.setId(id);
		newUser.setUserName(userName);
		newUser.setName(name);
		newUser.setPhoneNum(phoneNum);
		newUser.setSex(sex);
		newUser.setShippingAddress(address);

		System.out.println(newUser.getId());
		System.out.println(newUser.getName());
		System.out.println(newUser.getPhoneNum());
		System.out.println(newUser.getSex());
		System.out.println(newUser.getUserName());
		System.out.println(newUser.getShippingAddress());
		
		UserBiz userBiz = new UserBizImpl();
		int updatePersonalDataFlag = userBiz.updatePersonalData(newUser);
		if(updatePersonalDataFlag==0) {
			session.setAttribute("userPo", newUser);
		}
		
		request.setAttribute("updatePersonalDataFlag", updatePersonalDataFlag);
		request.getRequestDispatcher("page/static/perInfo.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
