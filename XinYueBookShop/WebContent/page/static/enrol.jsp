<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<html>
<head>
<meta charset="UTF-8">
<title>欢迎注册【新悦书城】</title>


<%
	if (request.getAttribute("regFlag") != null) {
		if ((boolean) request.getAttribute("regFlag")) {
%>
<script>
	alert("恭喜您注册成功,点击确定进入登录界面");
	
</script>
<%
	} else {
%>
<script>
	alert("这个手机号已经注册过了，请更换手机号注册");
</script>
<%
	}
	}

%>

<%@include file="/page/common/basePath.jsp" %>

<script>
	function valData() {
		var tipMsg = "";

		var rf = document.getElementById("regform");
		console.log(rf);

		var phoneNum = document.getElementById("tel").value;

		var firstPW = document.getElementById("psw1").value;

		var secondPW = document.getElementById("psw2").value;

		console.log(phoneNum);
		console.log(firstPW);
		console.log(secondPW);
		var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;

		if (!myreg.test(phoneNum)) {
			tipMsg = tipMsg + "手机号码格式不正确!";
		}

		if (firstPW == null || firstPW == "" || secondPW == null
				|| secondPW == "") {
			tipMsg = tipMsg + "密码不能为空!";
		}

		if (!(firstPW == secondPW)) {
			tipMsg = tipMsg + "两次密码输入不同";
		}

		document.getElementById("tipPanel").innerHTML = tipMsg;
		if (tipMsg == "") {
			console.log("输入正确");
			rf.submit();
		}

		//console.log(tipMsg);
	}
	
	var baseUrl = "verify-servlet";
	var xmlHttp;
	var responseText;
	var onBlurId;
	var code;		

	//创建创建 XMLHttp 对象
	function createXmlHttp(name, value) {
		if(window.ActiveXObject) {
			console.log("操作提示：您的浏览器是IE浏览器。");
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if(window.XMLHttpRequest) {
			console.log("操作提示：您的浏览器不是IE浏览器。");
			xmlHttp = new XMLHttpRequest();
		}

		//注册监听或者回调函数
		xmlHttp.onreadystatechange = callback;
		//1:打开状态
		//传递参数
		var url = baseUrl + "?" + name + "=" + value;
		//GET方法打开,第三个参数如果为true,那么为异步请求,将不会刷新整个页面.
		xmlHttp.open("GET", url, true);
		//2:发送状态
		//Get方式的send()
		xmlHttp.send(null);

	}

	//回调函数，处理响应信息
	function callback() {

		//获取响应内容
		if(xmlHttp.readyState == 4) {
			if(xmlHttp.status == 200) {
				responseText = xmlHttp.responseText;
				console.log(responseText);
				var pText = document.getElementById("tipPanel");
				var button = document.getElementById("regButton");
			
				if(responseText == "0") {
					pText.style.color = "red";
					button.disabled = true;
				
					pText.innerHTML="验证码已失效，点击刷新";
				} else if(responseText == "1") {
					pText.style.color = "green";
					button.disabled = false;
					pText.innerHTML="验证码输入成功";
				}else{
					pText.style.color = "red";
					button.disabled = true;
					pText.innerHTML="验证码输入失败";
				}

			}
		}
	}

	//通过处理后的响应信息修改提醒文本
	function setResponseText(text) {
		var id;
		var responseText;
		
	}

	//重写失去焦点事件
	function onBlur(id) {
		var module = document.getElementById(id);
		var name = module.name;
		var value = module.value;
		//var url = baseUrl + "?" + name + "=" + value;
		onBlurId = id;
		console.log(name + "失去焦点");
		console.log(name + ":" + value);
		createXmlHttp(name, value);
	}
	
	function onClick(){
		var id = Math.floor(Math.random()*10);
		code = document.getElementById("verCodeImg");
		console.log(code);
		code.src = "verification-code-servlet"+"?id="+id;
		console.log(code.src);
	}
</script>
</head>
<body>
	<table id="container" class="container">
		<%@include file="/page/common/top.jsp" %>
		<tr id="main" class="main-login">
			<td>
				<div class="main2">
					<h2>新悦书城 · 欢迎注册</h2>
					<div class="r">
						<form id="regform" name="regform" action="user-register-servlet" 
							method="post">
							<table>
								<tr>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手&nbsp;&nbsp;机&nbsp;&nbsp;号:<input
								type="text" maxlength="11" value="" name="tel" id="tel" /> <br /></td>
									
								</tr>
								<tr>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入密码:<input name="psw1"
								type="password" id="psw1" /> <br /></td>
								</tr>
								<tr>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确认密码:<input name="psw2"
								type="password" id="psw2" /> <br /></td>
								
								</tr>
								<tr>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;验证码： <input type="text"  id="verCode" name="verCode" onblur="onBlur(id)"/></td>
									<td><img id="verCodeImg"  src="verification-code-servlet" onclick="onClick()" ></td>
								</tr>
							</table>
							
							<div id="tipPanel">
								<!--此处会显示验证提醒信息...-->
							</div>
							
							
							
							<div class="button">
								<input value="注 册"  id="regButton" type="button" onclick="valData()"
									style="margin: 20px auto; width: 80%;" > <br /> <a
									href="page/static/login.jsp"><input value="有账号，登录" type="button"
									style="margin-right: 45px; margin-top: 20px;"></a>
							</div>
						</form>

					</div>
				</div>
			</td>
		</tr>
		<%@include file="/page/common/bottom.jsp" %>
	</table>
</body>
</html>
