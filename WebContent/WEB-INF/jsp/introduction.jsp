<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="知通,教育,知通教育,安徽理工大学,web前端开发,java,php">
<title>资讯</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/linkcss.css">

<style>
.f1 {
	float: left;
	font-family: 微软雅黑;
	font-size: 15px;
	line-height: 25px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top top-bar">
	<div class="container-fluid">
		<div class="navbar-header">
			<a href="#" class="navbar-brand"> <img
				src="${pageContext.request.contextPath }/img/logo.png" alt="知通教育">
			</a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-c">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse navbar-c">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath }/index.do"><span
						class="glyphicon glyphicon-home"></span>首页</a></li>
				<li><a
					href="${pageContext.request.contextPath }/introduction,do"
					class="active"><span class="glyphicon glyphicon-tint"></span>团队介绍</a></li>
				<li><a href="${pageContext.request.contextPath }/temp.do"><span
						class="glyphicon glyphicon-indent-right"></span>学习资源</a></li>
				<li><a href="${pageContext.request.contextPath }/join.do"><span
						class="glyphicon glyphicon-hand-up"></span>报名入口</a></li>
				<li><a href="${pageContext.request.contextPath }/about.do"><span
						class="glyphicon glyphicon-user"></span>关于我们</a></li>
				<li><a
					href="${pageContext.request.contextPath }/admin/login.do"
					target="_blank"><span class="glyphicon glyphicon-hand-up"></span>管理员入口</a></li>
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
	<div id="information">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<h2>团队介绍</h2>
					<div class="container-fluid">


						<a href="${pageContext.request.contextPath }/other/1.do">
							<div class="row info-content">
								<div class="col-md-5 col-sm-5 col-xs-5">
									<img src="${pageContext.request.contextPath }/img/14.jpg"
										alt="" class="img-responsive">
								</div>
								<div class="col-md-7 col-sm-7 col-xs-7">
									<h3>基地环境</h3>
									<p>
										知通教育实训基地为参加实训的人员提供公司办公环境，有别于培训学校的培训环境。在公办环境下实训人员才会把自己当成是一个员工，只有这样才能达到实训的目标而不仅仅是培训。
										实训的目标是技能和工作经验的积累......</p>
								</div>

							</div>
						</a> <a href="${pageContext.request.contextPath }/other/2.do">
							<div class="row info-content">

								<div class="col-md-5 col-sm-5 col-xs-5">
									<img src="${pageContext.request.contextPath }/img/14.jpg"
										alt="" class="img-responsive">
								</div>
								<div class="col-md-7 col-sm-7 col-xs-7">
									<h3>实训为王</h3>
									<p>
										如果你参加的IT培训不专业，面对越来竞争激烈的职场，基本找不到工作，真正的IT教育必须由专业的分析出发，提供业内人士真正认同的专业知识。知通实训
										实训为王......</p>
								</div>
							</div>
						</a> <a href="${pageContext.request.contextPath }/other/3.do">
							<div class="row info-content">

								<div class="col-md-5 col-sm-5 col-xs-5">
									<img src="${pageContext.request.contextPath }/img/14.jpg"
										alt="" class="img-responsive">
								</div>
								<div class="col-md-7 col-sm-7 col-xs-7">
									<h3>常见问题</h3>
									<p>知通教育实训和其他的机构有什么差别？为什么叫“知通教育”？ 专注软件实训，专业打造精英，是知通教育实训的宗旨。

										技术实战＋关键职业能力培养，一主一辅知通教育系并行培养软件精英......</p>
								</div>
							</div>
						</a> <a href="${pageContext.request.contextPath }/other/4.do">
							<div class="row info-content">

								<div class="col-md-5 col-sm-5 col-xs-5">
									<img src="${pageContext.request.contextPath }/img/14.jpg"
										alt="" class="img-responsive">
								</div>
								<div class="col-md-7 col-sm-7 col-xs-7">
									<h3>选择知通</h3>
									<p>
										IT产业是一个迅速发展之中的产业，新技术、新产品和新应用不断涌现，很多毕业生一提到IT行业，首先想到的就是高技术、高要求。但是，经过与业内专业人士、合作企业的共同研究分析，知通教育实训发现：IT行业固然有相当的技术含量......



									
								</div>
							</div>
					</div>
				</div>
				</a>

				<div class="col-md-4">
					<h2>组别介绍</h2>
					<div class="container-fluid">
						<div class="row">
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<ul class="media-list">
											<li class="media">
												<div class="media-left">
													<a
														href="http://blog.csdn.net/xiangzhihong8/article/details/72235569?locationNum=2&fps=1">
														<img class="media-object"
														src="${pageContext.request.contextPath }/img/user.png"
														alt="...">
													</a>
												</div>
												<div class="media-body">
													<a
														href="http://blog.csdn.net/xiangzhihong8/article/details/72235569?locationNum=2&fps=1">
														<h4 class="media-heading">前端知识图谱</h4>
														WEB前端开发技术是一个先易后难的过程，主要包括三个要素：HTML & CSS & JavaScript 
												</div> </a>
											</li>
											<li class="media">
												<div class="media-left"></div>
												<div class="media-body">

													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>

											</li>
											<li class="media">
												<div class="media-left">
													<a
														href="http://blog.csdn.net/xenia1992/article/details/54666564">
														<img class="media-object"
														src="${pageContext.request.contextPath }/img/user.png"
														alt="...">
													</a>
												</div>
												<div class="media-body">
													<a
														href="http://blog.csdn.net/xenia1992/article/details/54666564">
														<h4 class="media-heading">PHP的基本介绍</h4> PHP 是一种 HTML
														内嵌式的语言,是一种在服务器端执行的嵌入HTML文档的脚本语言 
												</div> </a>
											</li>

											<li class="media">
												<div class="media-left"></div>
												<div class="media-body">

													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>

											</li>



											<li class="media">
												<div class="media-left">
													<a
														href="http://blog.csdn.net/elibrace/article/details/50587631">
														<img class="media-object"
														src="${pageContext.request.contextPath }/img/user.png"
														alt="...">
													</a>
												</div>
												<div class="media-body">
													<a
														href="http://blog.csdn.net/elibrace/article/details/50587631">
														<h4 class="media-heading">JAVA简单介绍</h4>
														Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言 
												</div> </a>
											</li>
										</ul>
										<!--
										<ul class="list-unstyled ulist">
						                    <li><a href="#">团队招新正式拉开序幕 <span class="time">02-27</span></a></li>
						                    <li><a href="#">团队招新正式拉开序幕 <span class="time">02-27</span></a></li>
						                    <li><a href="#">团队招新正式拉开序幕 <span class="time">02-27</span></a></li>
						                    <li><a href="#">团队老人总结报告<span class="time">02-27</span></a></li>
						                    <li><a href="#">团队老人总结报告<span class="time">02-27</span></a></li>
						                    <li><a href="#">团队老人总结报告<span class="time">02-27</span></a></li>
						                    <li><a href="#">团队招新正式拉开序幕 <span class="time">02-27</span></a></li>
						                    <li><a href="#">团队招新正式拉开序幕 <span class="time">02-27</span></a></li>
						                    <li><a href="#">团队招新正式拉开序幕 <span class="time">02-27</span></a></li>
						                  </ul>-->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer" class="text-muted">
		<div class="container text-center">
			<p>企业培训 | 合作事宜 | 版权投诉</p>
			<p>苏ICP备1234578@2008-2016 知通教育，Powered by Bootstrap</p>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script>
		
	</script>
</body>
</html>