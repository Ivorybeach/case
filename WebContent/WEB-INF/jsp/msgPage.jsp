<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- spring标签库 -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>

<body> 
	<!-- 找到属性文件变量名为welcome的配置 -->
	<spring:message code="username"/>	 <br/> <br/> 
	<a href="${pageContext.request.contextPath }/message/msgPage.do?language=zh_CN">中文</a>
	<label>|</label><a href="${pageContext.request.contextPath }/message/msgPage.do?language=en_US">English</a>
	
	
</body>
</html>
