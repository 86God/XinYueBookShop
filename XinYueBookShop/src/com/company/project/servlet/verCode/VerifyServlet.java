package com.company.project.servlet.verCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��֤��֤��
 * @author God_86
 *
 */
@WebServlet("/verify-servlet")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VerifyServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String verCode = request.getParameter("verCode");
		System.out.println("-----------------");
		
		String flag = null ;
		String code = (String) request.getSession().getAttribute("verCode");
		
		if(code==null) {
			//��֤��ʧЧ
			flag = "0";
		}
		else if(verCode.toUpperCase().equals(code.toUpperCase())) {
			//��֤��������ȷ
			flag = "1";
		}else {
			//��֤������ʧ��
			flag = "2";
			request.getSession().removeAttribute("verCode");
		}
		
		PrintWriter out=response.getWriter();
		out.print(flag);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
