<%@page import="javafx.scene.control.Alert"%>
<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%
	String alertText = "";
	if (request.getAttribute("updatePersonalDataFlag") != null) {
		if ((int) request.getAttribute("updatePersonalDataFlag") == 0) {
			alertText = "更改信息成功";

		} else if ((int) request.getAttribute("updatePersonalDataFlag") == 1) {
			alertText = "此手机号已经注册过了";
		} else if ((int) request.getAttribute("updatePersonalDataFlag") == 2) {
			alertText = "此用户名已经使用过了";
		} else {
			alertText = "更新资料失败，请检测服务器是否正常";
		}
	}
	request.setAttribute("alertText", alertText);

	if (request.getAttribute("alertText") != "") {
%>
<script>
		alert("<%=alertText%>");
	</script>
<%
	}
%>




<html>
<head>
<meta charset="UTF-8">
<title>【新悦书城】个人信息</title>
<%@include file="/page/common/basePath.jsp"%>

<script type="text/javascript">
	function updatePersonalData() {
		var tipMsg = "";
		var username = document.getElementById("username").value;
		var name = document.getElementById("name").value;
		var phoneNum = document.getElementById("tel").value;
		var address = document.getElementById("address").value;
		var perInfoForm = document.getElementById("perInfoForm");

		console.log("username:"+username);
		console.log("name:"+name);

		console.log("tel:"+tel);
		console.log("address:"+address);

		var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;

		if (!myreg.test(phoneNum)) {
			tipMsg = tipMsg + "手机号码格式不正确!";
		}

		if (tipMsg == "") {
			console.log("输入正确");
			perInfoForm.submit();
		}else{
			alert(tipMsg);
		}
		
	} 
</script>


</head>
<body>

	<table id="container" class="container">
		<%@include file="/page/common/top.jsp"%>
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
						<td><%@include file="/page/common/perInfoMenu.jsp"%>
							<div class="right">
								<h2 class="">&nbsp;&nbsp;个人中心>个人信息</h2>
								<form action="user-update-date-servlet" id="perInfoForm"
									method="post" target="_parent">
									<table>
										<tr>
											<td class="l">用户名：</td>
											<td><input type="text" value="<%=userpo.getUserName()%>"
												name="username" id="username" class="t" /></td>
										</tr>
										<tr>
											<td class="l">姓名：</td>
											<td><input type="text" value="<%=userpo.getName()%>"
												name="name" id="name" class="t" /></td>
										</tr>
										<tr>
											<td class="l">性 别：</td>
											<td><input type="radio" id="boySex" name="sex"
												value="boy" />男 <input type="radio" id="girlSex" name="sex"
												value="girl" />女</td>
										</tr>

										<tr>
											<td class="l">手机号：</td>
											<td><input type="text" maxlength="11"
												value="<%=userpo.getPhoneNum()%>" name="tel" id="tel"
												class="t" /></td>
										</tr>



										<tr>
											<td class="l">地址：</td>
											<td><input type="text"
												value="<%=userpo.getShippingAddress()%>" name="address"
												id="address" class="t1" /></td>
										</tr>

										<tr>
											<td></td>
											<td><a href="page/static/perInfo.jsp"> <input
													type="button" value="重置" class="o" />
											</a> <input type="button" value="提交" class="o"
												onclick="updatePersonalData()" /></td>
										</tr>
									</table>
								</form>
							</div></td>
					</tr>
				</table>
			</td>
		</tr>
		<%@include file="/page/common/bottom.jsp"%>
	</table>
</body>

<script>
var boy = document.getElementById("boySex");
var girl = document.getElementById("girlSex");
console.log(boy);
console.log(girl);
if("<%=userpo.getSex()%>" == "男") {
		console.log("男");
		boy.checked = "checked";
	} else {
		console.log("女");
		girl.checked = "checked";
	}
</script>
</html>
