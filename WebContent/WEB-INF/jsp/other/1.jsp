<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="知通,教育,知通教育,安徽理工大学,web前端开发,java,php">
	<title>资讯</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/linkcss.css">
    <style >
      .j{
      line-height: 40px;
      }
	</style>
</head>
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
				<h1>团队介绍</h1>
				<h4>知通团队的简要介绍...</h4>
			</hgroup>
		</div>
	</div>

	<div class="j">
	<center><h1>基地环境</h1></center>  <br><br><br>

	<p><h4> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;知通教育实训基地为参加实训的人员提供公司办公环境，有别于培训学校的培训环境。在办公环境下实训人员才会把自己当成是一个员工，只有这样才能达到实训的目标而不仅仅是培训;</p><br>

    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实训的目标是技能和工作经验的积累，让参训人员具备工作经验；培训是让培训学员学习相关技能，不太注重对于工作经验方面积累。而大学生要和企业无缝对接，工作经验恰恰是软肋;</p><br>

    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在项目过程中，项目小组需要经常开会讨论和沟通。知通教育实训基地提供了专门的会议室，供实训人员开会使用。在项目经理的带领下，每次会议都是一个自我提升、总结经验的机会。<br>
    </p></h4></div>



       <br><br><br>



 
 
			 
	<div class="footer" class="text-muted">
		<div class="container text-center">
			<p>企业培训 | 合作事宜 | 版权投诉</p>
			<p>苏ICP备1234578@2008-2016 知通教育，Powered by Bootstrap</p>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script>
	</script>
</body>
</html>
