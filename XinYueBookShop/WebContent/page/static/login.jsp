<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


  

<html>
	<head>
		<meta charset="UTF-8">
		<title>欢迎登录【新悦书城】</title>
		<%@include file="/page/common/basePath.jsp" %>
		
		<%
	if (request.getAttribute("loginFlag") != null) {
		if ((boolean) request.getAttribute("loginFlag")) {
%>
<script>
	alert("恭喜您登录成功");
	
</script>
<%
	} else {
%>
<script>
	alert("您输入的手机号或密码不正确，请重新登陆");
</script>
<%
	}
	}
%>

<script>
	function loginToDetect() {
		var tipMsg = "";

		var rf = document.getElementById("loginForm");
		console.log(rf);

		var phoneNum = document.getElementById("tel").value;

		var PW = document.getElementById("psw").value;


		console.log(phoneNum);
		console.log(PW);
		var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;

		if (!myreg.test(phoneNum)) {
			tipMsg = tipMsg + "手机号码格式不正确!";
		}

		if (PW == null || PW == "") {
			tipMsg = tipMsg + "密码不能为空!";
		}

		document.getElementById("tipPanel").innerHTML = tipMsg;
		if (tipMsg == "") {
			console.log("输入正确");
			rf.submit();
		}
</script>
		
	</head>
	<body>

			<table id="container" class="container">
				<%@include file="/page/common/top.jsp" %>
				<tr id="main" class="main-login"><td>
					<div class="main2">
						<h2>新悦书城 · 欢迎登录</h2>
		        		<div class="r">
                   			<form id="loginForm" action="user-login-servlet" method="post">
                   			
                      		  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手&nbsp;机&nbsp;号:<input type="text" maxlength="11" value="" name="tel" id="tel"/>
                        		<br /><br />
                        		
                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input name="psw" type="password" id="psw" />
                       		 	<br /><br />   
                       		 	           		 	
									
								
                       		 	<div id="tipPanel">
								<!--此处会显示验证提醒信息...-->
								</div>
                       		 	
                       			<p class="enrol"><a href="page/static/enrol.jsp">用户注册</a><a href="">忘记密码？</a></p>
                        	
                           		<input value="登录" type="button" onclick="loginToDetect()" style="margin-right:4%; margin-top:5%;">
                        		
                   			</form>
						</div>
					</div>
				</td></tr>
				<%@include file="/page/common/bottom.jsp" %>
			</table>
	</body>
</html>
