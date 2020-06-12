
<%@page import="java.util.List"%>
<%@page import="com.company.project.model.po.BookPo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.project.biz.impl.BooksBizImpl"%>
<%@page import="com.company.project.biz.BooksBiz"%>
<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 	BooksBiz booksBiz = new BooksBizImpl();
	ArrayList<BookPo> bookPoList = null;
	//一页显示12本书
	int numsOfpages = 12;
	
	//当前选择的类型
	String type = request.getParameter("type");
	
	if(type==null || type==""){
		bookPoList = booksBiz.findAll();
	}else{
		bookPoList = booksBiz.findByType(type);
	}
	
	ArrayList<BookPo> bookPos = (ArrayList<BookPo>)request.getAttribute("searchList");
	if(bookPos != null){
		bookPoList = bookPos;
	}
	
	if(bookPoList!=null){
		session.setAttribute("bookPoList", bookPoList);
	}
	
	//当前选择的第几页
	String pages =request.getParameter("pages");
	
	
	if(pages==null || pages=="" || pages.equals("0")){
		pages = "1";
	}
	int pageNow = Integer.valueOf(pages);

	//总共书籍数量
	int booksNum = bookPoList.size();
	//需要的页数
	int pageNum = (int)Math.ceil((double)booksNum/(double)numsOfpages);
	if(pageNum == 0){
		pageNum = 1;
	}
	if(pageNow>pageNum){
		pageNow=pageNum;
	}
	List<BookPo> bookPos2 = null;
	if(bookPoList.size()<=12){
		bookPos2 = bookPoList;
	}
	System.out.println("pageNum"+pageNum);
	System.out.println("pageNow"+pageNow);
	System.out.println("booksNum"+booksNum);
	bookPos2 = bookPoList.subList((pageNow-1)*numsOfpages, pageNow*numsOfpages > booksNum ? booksNum : pageNow*numsOfpages);
	
%>


<html>
<head>
<meta charset="UTF-8">
<title>【新悦书城】</title>
<%@include file="/page/common/basePath.jsp" %>
<%-- JSP注释 --%>

</head>

<body>
	<form action="search-servlet">
		<table id="container" class="container">
			<%@include file="/page/common/top.jsp" %>
			<tr id="main" class="main-index">
				<td>
					<table class="main1">
						<tr id="top" class="top">
							<td>
								<h1>新悦书城</h1> 
								<input id="search2" class="search" type="submit"
								name="search2" value="搜索" /> 
								<input id="search1" class="search"
								type="text"  name="search1" value="" />
							</td>
						</tr>
						<tr id="bottom" class="bottom">
							<td>
								<%@include file="/page/common/bookClass.jsp" %>
								<div id="right" class="right">
									<h2>好书推荐</h2>
									<hr />
									<table>
										<%
										for(int i = 0;i<bookPos2.size();i++){
											BookPo bookPo = bookPos2.get(i);
											if(i%6 == 0){
												%>
										<tr>		
												<%
											}
											%>
											
											<td><a href="<%=detailsHref %>?bookPoId=<%=bookPo.getId()%>">
												<img src="<%=bookPo.getBookImg()%>" style="width: 100px;" /></a>
												<p class="o"><%=bookPo.getName()%></p>
												<p class="p"><%=bookPo.getAuthor()%></p>
												<p class="q">
													<span>￥<%=bookPo.getPrice()%></span>起
												</p>
											</td>
											
											<%
											if((i+1)%6 == 0){
												%>
										</tr>		
												<%
											}
										}
										%>
									</table>
								</div>
								<div class="container text-center" id="pagind" >
									<nav aria-label="Page navigation">
										<ul class="pagination">
											<li>
												<a href="page/dynamic/index.jsp?pages=<%= pageNow -1 %>">
													<span aria-hidden="true">&laquo;</span>
												</a>
											</li>
											<%
											for(int j = 1;j<=pageNum;j++){
												%>
												<li><a href="page/dynamic/index.jsp?pages=<%= j %>"><%= j %></a></li>
												<%
											}
											%>
											<li>
												<a href="page/dynamic/index.jsp?pages=<%= pageNow +1 %>">
													<span aria-hidden="true">&raquo;</span>
												</a>
											</li>
										</ul>
									</nav>
								</div>
								
							</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<%@include file="/page/common/bottom.jsp" %>
		</table>
	</form>
</body>
</html>
