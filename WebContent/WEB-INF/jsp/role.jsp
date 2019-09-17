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
	<form action="${pageContext.request.contextPath }/param/commonParam.do" method="post"> 
		姓名：<input id="roleName" name="roleName" value=""/>
		<br/>
		备注：<input id="note" name="note" value=""/>
		<br>
		<input type="submit" value="提交"> 
	</form>
	
</body>
</html>
