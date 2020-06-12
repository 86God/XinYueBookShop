<%@page import="com.company.project.model.po.UserPo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<html>
	<head>
		<meta charset="UTF-8">
		<title>【新悦书城】意见反馈</title>
		<%@include file="/page/common/basePath.jsp" %>
	</head>
	<body>
		<form>
			<table id="container" class="container">
				<%@include file="/page/common/top.jsp" %>
				<tr id="main" class="main-PerInfo"><td>
					<table class="main4">
						<tr id="top" class="top"><td>
							<h1>新悦<span>·意见反馈</span></h1>
						</td></tr>
						<tr id="bottom2" class="bottom2"><td>
							<form action="" method="post" target="_parent" class="form2">
								<h3>意见反馈</h3>
                				<br />
                				<p>您好！非常感谢您来深圳书城浏览购物。为了更好地提升我们的服务，我们希望收集您使用深圳书城网站时的看法或建议。</p>
                				<p>对您的配合和支持表示衷心感谢！</p>
                				<br /><br />
                				<h3>反馈问题类型</h3>
                				<br />
                					<div class="three2">
                    				<input type="radio" name="protype" id=1/>订单问题
                    				<br /><br />
                    				<input type="radio" name="protype" id=2/>系统报错
                    				<br /><br />
                    				<input type="radio" name="protype" id=3/>产品建议
                    				<br /><br />
                    				<input type="radio" name="protype" id=4/>其他
                    				<br /><br />
                				</div>
                				<br /><br />
                				<h3>问题详细描述</h3>
                				<br />
                				<div class="three3">
                    				<textarea rows="4" cols="60" name="eva2" id="eva2" class="eva2"></textarea>
                				</div>
                				<br /><br />
                				<h3>联系方式</h3>
                				<br />
                				<div>
                    				<input type="text" maxlength="11" class="tel">
                				</div>
                				<br />
                				<div><input value="提交" type="submit"></div>
							</form>
						</td></tr>
					</table>
				</td></tr>
				<%@include file="/page/common/bottom.jsp" %>
			</table>
		</form>
	</body>
</html>
