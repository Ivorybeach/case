<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="keywords" content="知通,教育,知通教育,安徽理工大学,web前端开发,java,php">
<title>登录</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>
	<div class="container">
		<div class="login">
			<h1 class="login-heading">
				<strong>Welcome</strong> To Login
			</h1>
			<form method="post" action="${pageContext.request.contextPath }/admin/loginSubmit.do">
				<input type="text" name="adminName" placeholder="Username"
					required="required" class="input-txt" /> <input type="password"
					name="password" placeholder="Password" required="required"
					class="input-txt" />
				<div class="login-footer">
					<a href="#" class="lnk"> <span class="icon icon--min"></span>
						<a href="./cat-login.do" class="lnk"><code>Here Exclusive Entrance For Mr.cat !</code></a>
					</a>
					
					<button type="submit" class="btn btn--right">Sign in</button>
				</div>
			</form>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/js/index.js"></script>
</body>
</html>
