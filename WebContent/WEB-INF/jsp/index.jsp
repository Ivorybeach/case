<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="keywords" content="知通,教育,知通教育,安徽理工大学,web前端开发,java,php">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>知通团队</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/linkcss.css">
	<style >
      .flo{
      line-height: 25px;
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
					<li><a href="${pageContext.request.contextPath }/index.do" class="active" target="_self"><span class="glyphicon glyphicon-home" ></span>首页</a></li>
					<li><a href="${pageContext.request.contextPath }/introduction.do" target="_self"><span class="glyphicon glyphicon-tint"></span>团队介绍</a></li>
					<li><a href="${pageContext.request.contextPath }/temp.do" target="blank"><span class="glyphicon glyphicon-indent-right"></span>学习资源</a></li>
					<!-- <li><a href="http://study.163.com/category/it" target="_self"><span class="glyphicon glyphicon-indent-right"></span>学习资源</a></li> -->
					<li><a href="${pageContext.request.contextPath }/join.do" target="_self"><span class="glyphicon glyphicon-hand-up"></span>报名入口</a></li>
					<li><a href="${pageContext.request.contextPath }/about.do" target="_self"><span class="glyphicon glyphicon-user"></span>关于我们</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/login.do" target="_blank"><span class="glyphicon glyphicon-hand-up"></span>管理员入口</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="myCarousel" class="carousel slide">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active" style="background:#1968A6">
				<a href="#"></a><img src="${pageContext.request.contextPath }/img/team1.png" alt=""></a>
			</div>
			<div class="item" style="background: #1968A6">
				<a href="#"></a><img src="${pageContext.request.contextPath }/img/team2.png" alt=""></a>
			</div>
			<div class="item" style="background:#1968A6">
				<a href="#" ></a><img src="${pageContext.request.contextPath }/img/team3.png" alt=""></a>
			</div>
			<div class="item" style="background:#1968A6">
				<a href="#" ></a><img src="${pageContext.request.contextPath }/img/team4.png" alt=""></a>
			</div>
		</div>
		<!-- <a href=""><span class="glyphicon glyphicon-chevron-left"></span></a>可以自动识别高度居中 -->
		<a href="#myCarousel" data-slide="prev" class="carousel-control left">&lsaquo;</a>
		<a href="#myCarousel" data-slide="next" class="carousel-control right">&rsaquo;</a>
	</div>
	
	<div id="sign">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-sm-6 text-center">
					<h3>零基础，零学费</h3>
				</div>
				<div class="col-md-6 col-sm-6 text-center">
				<button class="btn btn-info btn-lg">知通改变你的人生</button>
				</div>
			</div>
		</div>
	</div>
<br><br>
	<div id="teams">
		<div class="container">
			<h2 class="text-center">因为组织明确，所以更专业</h2>
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="panel panel-info">
				  		<div class="panel-heading">
								JAVA
				  		</div>
				  		<div class="panel-body"  >
				    		
                          <div class="flo">  
                           <p>JAVA 组：专注于网站后台开发,B/S框架WEB应用,企业级应用等;</p>
                           <p>以JAVA语言为基础,以Oracle数据库,JAVA EE(JSP,JavaBean,Servlet)
                              ,框架技术(Spring mvc,Spring,Mybatis )为主(JAVA SE学完后也可以学习android手机软件开发) ;</p>
                          <!-- <P>同时辅助学习HTML，CSS，Javascript，Ajax，XML，Linux，UML等语言或技术;</P>-->
                           <p>最终使组员达到可独立开发以JSP + JavaBean + Servlet为技术核心的网站或WEB应用。</p>
                          </div>
                         
				 		 </div>
				 		 <div class="panel-footer">
				 		 	<button class="btn btn-success"><a href="${pageContext.request.contextPath }/join.do">加入我们</a></button>
				 		 </div>
					</div>
				</div> 
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="panel panel-info">
				  		<div class="panel-heading">
							WEB前端
				  		</div>
				  		<div class="panel-body">
				    		 <div class="flo">

				    		    <p>前端组：专注于网站的前台设计，整站页面设计，页面排版，配合后台开发WEB应用等;</p>
				    		    <p>主要以javascript、css网站布局、html网页制作等技术为基础,以 jQuery、EasyUI、Bootstrap、AngularJS等框架技术为主;</p>
				    		    <p>同时辅助学习node.js、mongoDB数据库等技术;</p>
				    		    <p>最终使组员达到可以独立设计布局整个网站。</p>
				    		    <p>&nbsp;</p>
				    	        <p>&nbsp;</p>
                                   
				    		 </div>
				 		 </div>
				 		 <div class="panel-footer">
				 		 	<button class="btn btn-success"> <a href="${pageContext.request.contextPath }/join.do">加入我们</a></button>
				 		 </div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="panel panel-info">
				  		<div class="panel-heading">
							PHP
				  		</div>
				  		<div class="panel-body">
				    		 <div class="flo">
				    		  <p>PHP组：专注于网站后台开发，B/S框架WEB应用，以PHP + MySQL + Linux + Apache以及Laravel、Think PHP等框架为主;</p>
				    		  <p>辅助学习HTML,CSS,Javascript,Ajax,XML,Linux等辅助语言或技术；</p>
				    		  <p>最终使组员达到可独立开发以PHP技术为核心的网站或WEB应用。</p>
				    		  <p>&nbsp;</p>
				    		  <p>&nbsp;</p>
				    		  

				    		 </div>
				 		 </div>
				 		 <div class="panel-footer">
				 		 	<button class="btn btn-success"> <a href="${pageContext.request.contextPath }/join.do">加入我们</a></button>
				 		 </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br><br>
	<div class="tab2">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-sm-6 tab2-img">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-4 col-sm-4 col-xs-4" style="margin-top:80px">
									<img src="${pageContext.request.contextPath }/img/_8a654b6.png" alt="" class="img-resposive">
									<p>基础培训+自我学习</p>
								</div>
								<div class="col-md-4 col-sm-4 col-xs-4" style="margin-top:40px">
									<img src="${pageContext.request.contextPath }/img/_cf68708.png" alt="" class="img-responsive">
									<p>技能提升+实战开发</p>
								</div>
								<div class="col-md-4 col-sm-4 col-xs-4">
									<img src="${pageContext.request.contextPath }/img/_9c91f47.png" alt="" class="img-responsive">
									<p>授之他人+知识巩固</p>
								</div>
							</div>
						</div>
				</div>
				<div class="col-md-6 col-sm-6 text tab2-text">
					<h3>循序渐进的学习方式</h3>
					<p>三大阶段让你学有所获，学以致用</p>
				</div>
			</div>
		</div>
	</div><br><br>

	<div class="envior">
		<div class="text-center">
			<h2 class="">团队缩影</h2>
			<hr/>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-4 col-xs-4">
					<img src="${pageContext.request.contextPath }/img/01.png" alt="" class="img-responsive"/>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-4">
					<img src="${pageContext.request.contextPath }/img/03.png" alt="" class="img-responsive"/>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-4">
					<img src="${pageContext.request.contextPath }/img/02.png" alt="" class="img-responsive"/>
				</div>
			</div>
		</div>
	</div><br><br>
	

	<div class="footer" class="text-muted">
		<div class="container text-center">
			<!--<p> 关于知通教育│常见问题  </p>-->
			<p>Copyright © 2005-2017 知通教育 All rights reserved. 京ICP备11043089号-2</p>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script>
		$("#myCarousel").carousel({//图片轮播
			interval:2000,
		})
		//切换图片垂直居中
		$(".carousel-control").css('line-height',$('.carousel-inner img').height()+'px');
		$(window ).resize(function(){var $height=$('.carousel-inner img').eq(0).height()||$('.carousel-inner img').eq(1).height()||$('.carousel-inner img').eq(2).height();
			$(".carousel-control").css('line-height',$height+'px');
		})
		//卡片上滑
		$(".course").hover(function() {
			/* Stuff to do when the mouse enters the element */
		var $show=$(this).find(".upshow");
			if(!$show.is(":animated")){
				$show.animate({
					height: '100%',
					opacity: '0.6'},
					 400);
				$(this).parent().siblings('div').find(".upshow").animate({
					height: '0',
					opacity: '0'},
					200);
				}
		}, function() {
			var $show=$(this).find(".upshow");
			if(!$show.is(":animated")){
				$show.animate({
			 		height: '0',
					opacity: '0'},
					400);
				}
		});
	</script>
</body>
</html>