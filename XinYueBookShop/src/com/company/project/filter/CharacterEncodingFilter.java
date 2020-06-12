package com.company.project.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {

	private String author;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		
		//��ȡ��ʼ������,ʹ��filterConfig.getInitParameter("filter-name")������ȡ
		this.author = filterConfig.getInitParameter("author");
		System.out.println("author:"+this.author);
	
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("���ڳ�ʼ��������");
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		if (request.getRequestURI().contains(".css") || request.getRequestURI().contains(".js"))
	    {
	      chain.doFilter(request, response);
	    }
	    else
	    {
	    	response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");			
			chain.doFilter(request, response);
	    }	
	}

}
