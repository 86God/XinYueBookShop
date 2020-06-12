<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
String alertText1 = "";
if (request.getAttribute("updatePassWordFlag") != null) {
	if ((boolean) request.getAttribute("updatePassWordFlag")) {
		alertText1 = "更改密码成功";
		
	} else {
		alertText1 = "原密码错误，修改密码失败";
	}
}
request.setAttribute("alertText1", alertText1);

if (request.getAttribute("alertText1") != "") {
%>
<script>
	alert("<%=alertText1%>");
</script>
<% 
}


%>


<html>
<head>
<meta charset="UTF-8">
<title>【新悦书城】修改密码</title>
<%@include file="/page/common/basePath.jsp" %>


<script type="text/javascript">
	function updatePassWord() {
		var tipMsg = "";
		var oldPassword = document.getElementById("oldPassword").value;
		var newPassWord1 = document.getElementById("newPassWord1").value;	
		var newPassWord2 = document.getElementById("newPassWord2").value;
		var changePWForm = document.getElementById("changePWForm");
		
		
		console.log("oldPassword:"+oldPassword);
		console.log("newPassWord1:"+newPassWord1);
		console.log("newPassWord2:"+newPassWord2);

		if(newPassWord1 != newPassWord2){
			tipMsg += "两次输入的密码不同";
		}

		if (tipMsg == "") {
			console.log("输入正确");
			changePWForm.submit();
		}else{
			alert(tipMsg);
		}
		
	} 
</script>

</head>
<body>

		<table id="container" class="container">
			<%@include file="/page/common/top.jsp" %>
			<tr id="main" class="main-PerInfo">
				<td>
					<table class="main3">
						<tr id="top" class="top">
							<td>
								<h1>
									新悦<span>·个人中心</span>
								</h1> 
							</td>
						</tr>
						<tr id="bottom" class="bottom">
							<td>
								<hr />
								<%@include file="/page/common/perInfoMenu.jsp" %>
								<div class="right">
									<h2 class="">&nbsp;&nbsp;个人中心>修改密码</h2>
									<form action="user-change-pw-servlet" id="changePWForm" method="post" target="_parent">
										<table>
											<tr>
												<td class="l"><span class="a">*</span>原&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:</td>
												<td><input type="password" value="" name="oldPassword"
													id="oldPassword" class="t" /></td>
											</tr>
											<tr>
												<td class="l"><span class="a">*</span>设置新密码:</td>
												<td><input type="password" value="" name="newPassWord1"
													id="newPassWord1" class="t" /></td>
											</tr>
											<tr>
												<td class="l"><span class="a">*</span>确认新密码:</td>
												<td><input type="password" value="" name="newPassWord2"
													id="newPassWord2" class="t" /></td>
											</tr>
											<tr>
												<td></td>
												<td><input type="reset" value="重置" class="o" /><input
													type="button" value="提交" class="o" onclick="updatePassWord()" /></td>
											</tr>
										</table>
									</form>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<%@include file="/page/common/bottom.jsp" %>
		</table>
</body>
</html>
