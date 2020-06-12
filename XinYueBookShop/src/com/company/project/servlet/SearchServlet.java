package com.company.project.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.project.biz.BooksBiz;
import com.company.project.biz.impl.BooksBizImpl;
import com.company.project.model.po.BookPo;

/**
 * ËÑË÷¿ò´¦Àí
 * @author God_86
 *
 */
@WebServlet("/search-servlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchText = request.getParameter("search1");
		BooksBiz booksBiz = new BooksBizImpl();
		ArrayList<BookPo> bookPoList = booksBiz.findByDim(searchText);
		request.setAttribute("searchList", bookPoList);
		request.getRequestDispatcher("page/dynamic/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
