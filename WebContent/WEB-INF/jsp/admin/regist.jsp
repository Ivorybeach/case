<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="keywords" content="知通,教育,知通教育,安徽理工大学,web前端开发,java,php">
<title>注册</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>
	<div class="container">
		<div class="login">
			<h1 class="login-heading">
				<strong>Welcome</strong> To Regist
			</h1>
			<form method="post" action="${pageContext.request.contextPath }/admin/registSubmit.do">
				<input type="text" name="adminName" placeholder="AdminName"
					required="required" class="input-txt" /> <input type="password"
					name="password" placeholder="Password" required="required"
					class="input-txt" />
					<!-- 再次输入密码 -->
					 <input type="password"
					name="password" placeholder="Password Again" required="required"
					class="input-txt" />
					<!-- 输入邮箱 -->
					 <input type="text"
					name="email" placeholder="Email" required="required"
					class="input-txt" />
				<div class="login-footer">
					<a href="#" class="lnk"> <span class="icon icon--min"></span>
						<!-- 可以加入提示信息
						<strong>I've forgotten something...</strong> -->
					</a>
					<button type="submit" class="btn btn--right">Regist</button>
				</div>
			</form>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/js/index.js"></script>
</body>
</html>
