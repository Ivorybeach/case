<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">
	$(document).ready(function (){
		$("#commit").click(function (){
			var str=$("form").serialize();
			$.post({
				url:'./param/commonParamPojo2',
				data:$("form").serialize,
				success:function (result){
					
				}
			});
			
		});
	});
</script>
</head>

<body> 
	<form id="form">
		<input id="roleName" name="roleName" value=""><br>
		<input id="note" name="note" value=""><br>
		<input id="commit" type="button" value="提交">
	</form>
</body>
</html>
