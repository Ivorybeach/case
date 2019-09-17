<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js"></script>
	<!-- 传递json参数的script代码 -->
	<script type="text/javascript">
		$(document).ready(function (){
			//角色查询参数
			var data={
				roleName:'role',
				note:'note',
				
			}
			//Jquery的post请求
			$.post({
				url:"./findRole.do",
				//传递参数类型为Json
				contentType:"application/json",
				data:JSON.stringify(data),
				//成功后的方法
				success:function (result){
					
				}
			});
		});
		function test(){
		}
	</script>
</head>
<body> 
	<form action="${pageContext.request.contextPath }/param/findRole">
		roleName:<input id="roleName" name="roleName">
		<br>
		note:<input id="note" name="note" ><br>
		<input type="submit" value="提交"/>
		<input type="button" value="点点" onclick="test()"/>
	</form>
</body>
</html>
