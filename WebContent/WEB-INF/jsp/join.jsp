<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="知通,教育,知通教育,安徽理工大学,web前端开发,java,php">
	<title>加入我们</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/linkcss.css">
</head>
<script type="text/javascript">

</script>
<body>
	<nav class="navbar navbar-default navbar-fixed-top top-bar">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="#" class="navbar-brand">
					<img src="${pageContext.request.contextPath }/img/logo.png" alt="知通教育">
				</a>
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-c">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse navbar-c">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath }/index.do"><span class="glyphicon glyphicon-home"></span>首页</a></li>
					<li><a href="${pageContext.request.contextPath }/introduction.do" class="active"><span class="glyphicon glyphicon-tint"></span>团队介绍</a></li>
					<li><a href="${pageContext.request.contextPath }/temp.do"><span class="glyphicon glyphicon-indent-right"></span>学习资源</a></li>
					<li><a href="${pageContext.request.contextPath }/join.do"><span class="glyphicon glyphicon-hand-up"></span>报名入口</a></li>
					<li><a href="${pageContext.request.contextPath }/about.do"><span class="glyphicon glyphicon-user"></span>关于我们</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/login.do" target="_blank"><span class="glyphicon glyphicon-hand-up"></span>管理员入口</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<hgroup>
				<h4>如果你对IT有着满腔热血</h4>
				<h4>如果你想成为BAT大牛</h4>
				<h1>请加入我们</h1>	
			</hgroup>
		</div>
	</div>
	<div class="join">
		<div class="container">
			<div class="row">
				<form action="${pageContext.request.contextPath }/info/addInfo.do" method="POST">
				<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<div class="form-group">
							<label>姓名</label>
							<input type="text" id="name" name='name' class="form-control">
						</div>
						<div class="form-group">
							<label>院系</label>
							<input type="text" id="institution" name='institution' class="form-control">
						</div>
						<div class="form-group">
							<label>专业</label>
							<input type="text" id="major" name='major' class="form-control">
						</div>
						<div class="form-group">
							<label>手机号</label>
							<input type="text" id="phone" name='phone' class="form-control">
						</div>
						<div class="form-group">
							<label>QQ号</label>
							<input type="text" id="qq" name='qq' class="form-control">
						</div>
						<div class="form-group">
							<label>意向组别</label>
							<select  class="form-control" name='group' id="group" >
								<option selected="selected">java组</option>
								<option>web前端组</option>
								<option>php组</option>
							</select> 
						</div>
						<div class="form-group">
							<label>性别</label>
								<div class="radio">
								   <label>
								      <input id="sex" type="radio" name="sex"  id="optionsRadios1" value="男" checked >男
								   </label>
								
								   <label>
								      <input id="sex" type="radio" name="sex"  id="optionsRadios2"  value="女">
								         女
								   </label>
								</div>
						</div>
					</div>
				
				<div class="col-md-6 col-xs-12">
					<div class="form-group">
						<label>自我介绍/个人优势(不低于20字)</label>
						<textarea name="introduction" id="introduction" cols="30" rows="10" class="form-control">
							
						</textarea>
					</div>
					<div class="form-group text-center">
						<button type="submit" class="btn btn-primary" >提交</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>

	<div class="footer" class="text-muted">
		<div class="container text-center">
			<p>企业培训 | 合作事宜 | 版权投诉</p>
			<p>苏ICP备1234578@2008-2016 知通教育，Powered by Bootstrap</p>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script>
		$(function(){
		
});
	</script>
</body>
</html>