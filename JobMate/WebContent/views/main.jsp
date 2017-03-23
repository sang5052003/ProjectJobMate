<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>취업메이트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.css'>
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css'>
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css'>
<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic'>

<link rel="stylesheet" href="${ctx}/css/style.css">


</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">

		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#mainnav-navbar-collapse">
				MENU <span class="fa fa-bars color-white"></span>
			</button>
			<!-- Logo -->
			<a class="navbar-brand" href="${ctx}/main.do"><img
				src="image/logowhite.png"></a>
		</div>

		<!-- Navigation Links -->
		<div class="collapse navbar-collapse" id="mainnav-navbar-collapse">
			<ul class="nav navbar-nav navbar-default">

				<li class="page-scroll"><a href="${ctx}/views/recruitList.jsp">채용관리</a></li>
				<li class="page-scroll"><a href="/introduce.html">자기소개서</a></li>
				<li class="page-scroll"><a href="/spec.html">스펙공유</a></li>
				<li class="page-scroll"><a href="${ctx }/question/list.do">면접질문</a></li>
				<li class="page-scroll"><a href="/interview.html">가상면접</a></li>
				<li class="page-scroll"><a href="${ctx}/myScrap/myList.do">내
						스크랩</a></li>


			</ul>
			<ul class="nav navbar-nav navbar-right">
				<button type="text" class="button buttonBlue openrb">
					회원가입
					<div class="ripples buttonRipples">
						<span class="ripplesCircle"></span>
					</div>
				</button>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${empty loginUser  }">
						<button type="text" class="button buttonBlue openb">
							로그인
							<div class="ripples buttonRipples">
								<span class="ripplesCircle"></span>
						</button>
					</c:when>
					<c:otherwise>
						<a class="button buttonBlue ot" href="${ctx }/logout.do"> 로그아웃
							<div class="ripples buttonRipples">
								<span class="ripplesCircle"></span>
							</div>
						</a>

					</c:otherwise>
				</c:choose>
		</div>

	</div>
	<div class="login-modal-overlay">

		<div class="login-modal">
			<h1>로그인</h1>
			<h2>아이디,비밀번호를 입력해주세요.</h2>
			<form action="${ctx}/login.do" method="post">
				<div class="group">
					<input type="text" required="required" name="customerID"></span><span
						class="bar"></span> <label>ID</label>
				</div>
				<div class="group">
					<input type="password" required="required" name="password"></span><span
						class="bar"></span> <label>Password</label>
				</div>
				<button type="submit" class="button buttonBlue">
					로그인
					<div class="ripples buttonRipples">
						<span class="ripplesCircle"></span>
					</div>
				</button>
			</form>
		</div>

	</div>
	<div class="register-modal-overlay">
		<div class="register-modal">
			<h1>회원가입</h1>
			<h2>아이디,비밀번호,이름을 입력해주세요.</h2>
			<form>
				<div class="group">
					<input type="text" required></span><span class="bar"></span> <label>ID</label>
				</div>

				<div class="group">
					<input type="password" required></span><span class="bar"></span> <label>Password</label>
				</div>
				<div class="group">
					<input type="password" required></span><span class="bar"></span> <label>Password
						Check</label>
				</div>

				<div class="group">
					<input type="text" required></span><span class="bar"></span> <label>NAME</label>
				</div>
				<button type="submit" class="button buttonBlue">
					회원가입
					<div class="ripples buttonRipples">
						<span class="ripplesCircle"></span>
					</div>
				</button>
			</form>
		</div>
	</div>
	</nav>
	<!-- / Navigation -->

	<!-- #Introduction -->
	<section id="introduction">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<!--                <img class="img-responsive wow fadeInDown" src="https://lh3.googleusercontent.com/-VetalvdAVZk/VlCMalt2EGI/AAAAAAAAAJY/kO_r5irJBGI/s200-Ic42/boy.png" alt="">-->

				<div class="intro-text">
					<br> <br> <br> <br> <br> <br> <br>
					<div class="name wow fadeInLeft">
						<span style="color: #2C3E50">{ </span>취업메이트<span
							style="color: #2C3E50"> };</span>
					</div>
					<div class="skills wow fadeInRight">
						<strong>새로운 취준생은 언제나 환영이야!</strong>
					</div>
					<br> <br> <br> <br>

				</div>
			</div>
		</div>
	</div>
	<i id="moveDown" class="fa fa-chevron-down fa-3x bounce"></i> </section>
	<!-- / #Introduction -->

	<!-- #Portfolio -->
	<section id="portfolio">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2>
					<span style="color: #2C3E50"> < </span>인기 채용<span
						style="color: #2C3E50"> > </span>
				</h2>
				<br> <br>
			</div>
		</div>
		<div class="row">

			<div class="container-fluid">
				<div class="row cards-container">
					<c:forEach items="${list }" var="recruit">
						<div class="col-md-3 portfolio-item wow zoomIn">
							<div class="col s12 m4">
								<div class="card blue darken-1">
									<div class="card-content white-text">

										<span class="card-title"><strong>${recruit.name}</strong></span>
										<br> <br>
										<p style="font-size: 13px">${recruit.title }</p>
										<p style="font-size: 13px">지원자 수: ${recruit.applyCnt }</p>
									</div>
									<div class="card-action">
										<a class="white-text " href="${recruit.href }">자세히 보기</a>
									</div>

								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>
	</section>
	<!-- / #Portfolio -->



	<!-- Footer -->
	<footer>
	<div class="container text-center">
		<div class="row">
			<div class="col-lg-12">Copyright &copy; JobMate Website 2017</div>
		</div>
	</div>
	</footer>
	<!-- / Footer -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>

	<script src="js/index.js"></script>

</body>
</html>