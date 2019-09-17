<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body> 
	<!-- 
	<form action="${pageContext.request.contextPath }/validationSubmit.do" method="post">
	-->
	<form action="${pageContext.request.contextPath }/validationSubmit.do" method="post"> 
		编号：<input name="id" id="id"/><br>
		日期：<input name="date" id="date"/><br> 
		价格：<input name="price" id="price"/><br>
		邮箱：<input name="email" id="email"/><br>
		数量：<input name="quantity" id="quantity"/><br>
		金额：<input name="amount" id="amount"/><br>
		电话: <input name="phone" id="phone"/><br>
		备注：<input name="note" id="note"/><br>
		<input type="submit" value="点点">
	</form>
</body>
</html>
