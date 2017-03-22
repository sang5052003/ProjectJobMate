<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>

  <meta charset="UTF-8">
  <title>취업메이트</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.css'>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css'>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css'>
<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic'>
<link rel="stylesheet" href="css/style.css">

  
</head>

<body>
  <!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
    
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainnav-navbar-collapse">
                MENU <span class="fa fa-bars color-white"></span>
            </button>
            <!-- Logo -->
            <a class="navbar-brand" href="/index.html"><img src="image/logowhite.png"></a>
        </div>

        <!-- Navigation Links -->
        <div class="collapse navbar-collapse" id="mainnav-navbar-collapse">
            <ul class="nav navbar-nav navbar-default">
                
                <li class="page-scroll">
                    <a href="/recruit.html">채용관리</a>
                </li>
                <li class="page-scroll">
                    <a href="${ctx }/introduce/list.do?customerID=choi">자기소개서</a>
                </li>
                <li class="page-scroll">
                    <a href="${ctx }/introduce/spec.do">스펙공유</a>
                </li>
                <li class="page-scroll">
                    <a href="/question.html">면접질문</a>
                </li>
                <li class="page-scroll">
                    <a href="/interview.html">가상면접</a>
                </li>
                <li class="page-scroll">
                    <a href="/myscrap.html">내 스크랩</a>
                </li>
                
            </ul>
            
            
            
            <c:choose>
				<c:when test="${customerID eq null}">
					 <ul class="nav navbar-nav navbar-right">
			                <button type="text" class="button buttonBlue openrb">회원가입
			    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
			  </button>
			            </ul>
			            <ul class="nav navbar-nav navbar-right">
			                <button type="text" class="button buttonBlue openb">로그인
			    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
			  </button>
			            </ul>
				</c:when>
				<c:otherwise>
					</ul>
			            <ul class="nav navbar-nav navbar-right">
			                <button type="text" class="button buttonBlue openb">로그아웃
			    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
			  </button>
			            </ul></c:otherwise>
			</c:choose>
            
            
            
            
            
            
           
             
        </div>
        
    </div>
    <div class="login-modal-overlay">
  
  <div class="login-modal">
    <h1>로그인</h1>
    <h2>아이디,비밀번호를 입력해주세요.</h2>
    <form action="${ctx }/login.do">
      <div class="group">
        <input type="text" required></span><span class="bar"></span>
        <label>ID</label>
      </div>
      <div class="group">
        <input type="password" required></span><span class="bar"></span>
        <label>Password</label>
      </div>
      <button type="submit" class="button buttonBlue">로그인
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
    <form action="${ctx }/customer/form.do" method="post">
      <div class="group">
        <input type="text" id="customerID" name="customerID" required></span><span class="bar"></span>
        <label>ID</label>
      </div>
        
      <div class="group">
        <input type="password" required id="password" name="password"></span><span class="bar"></span>
        <label>Password</label>
      </div>
         <div class="group">
        <input type="password" required id="passwordCheck" name="passwordCheck"></span><span class="bar"></span>
        <label>Password Check</label>
      </div>
        
    <div class="group">
        <input type="text" required id="name" name="name" ></span><span class="bar"></span>
        <label>NAME</label>
      </div>
      <button type="submit" class="button buttonBlue">회원가입
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
                    <div class="name wow fadeInLeft"><span style="color:#2C3E50">{ </span>취업메이트<span style="color:#2C3E50"> };</span></div>
                    <div class="skills wow fadeInRight"><strong>새로운 취준생은 언제나 환영이야!</strong></div>
                     <br> <br> <br> <br>
                     
                </div>
            </div>
        </div>
    </div>
    <i id="moveDown" class="fa fa-chevron-down fa-3x bounce"></i>
</section>
 <!-- / #Introduction -->

<!-- #Portfolio -->
<section id="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Portfolio</h2>
                <p>Some of the things I did</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 portfolio-item wow zoomIn">
                <img src="https://lh3.googleusercontent.com/-0ID1DL4bYac/VWYvNsdHh7I/AAAAAAAAAEM/QaQirN2iSO8/w600-h450-no/portfolio_01.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 portfolio-item wow zoomIn">
                <img src="https://lh3.googleusercontent.com/-cvkoVynjpBk/VWYvNvYdCDI/AAAAAAAAAEA/1JKNpbQ_FPo/w600-h450-no/portfolio_02.jpg" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 portfolio-item wow zoomIn">
                <img src="https://lh3.googleusercontent.com/-nNVWZNtKIwQ/VWYvNyRO2GI/AAAAAAAAAEI/p_Gm7eboXL4/w600-h450-no/portfolio_03.jpg" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 portfolio-item wow zoomIn">
                <img src="https://lh3.googleusercontent.com/-CPazoZxaD7c/VWYvOQ1FzxI/AAAAAAAAAEQ/RcGN_2Mn4mU/w600-h450-no/portfolio_04.jpg" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 portfolio-item wow zoomIn">
                <img src="https://lh3.googleusercontent.com/-3I31BpK6Erw/VlBzaSXFzrI/AAAAAAAAAHc/LiIsF4_mMas/s600-Ic42/portfolio_05.jpg" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 portfolio-item wow zoomIn">
                <img src="https://lh3.googleusercontent.com/-LUqXKkYj7Mk/VlB0PLbyXgI/AAAAAAAAAIc/mcqIZTNRa7c/s600-Ic42/portfolio_06.jpg" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 portfolio-item wow zoomIn">
                <img src="https://lh3.googleusercontent.com/-5S6eU4Rn5mQ/VlBzaVMvjGI/AAAAAAAAAHc/a2AtTAXmoi8/s600-Ic42/portfolio_07.jpg" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 portfolio-item wow zoomIn">
                <img src="https://lh3.googleusercontent.com/-DySEOFLACag/VlBzaau6wrI/AAAAAAAAAHc/YVKSOTERFGM/s600-Ic42/portfolio_08.jpg" class="img-responsive" alt="">
            </div>
        </div>
    </div>
</section>
<!-- / #Portfolio -->

<!-- #Contact -->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Stay Connected</h2>
                <p>Join me on my social networks for all the latest updates and more.</p>
                <ul class="list-inline text-center">
                    <li>
                        <a href="#" class="btn-social btn-outline wow lightSpeedIn"><i class="fa fa-fw fa-facebook"></i></a>
                    </li>
                    <li>
                        <a href="#" class="btn-social btn-outline wow lightSpeedIn"><i class="fa fa-fw fa-twitter"></i></a>
                    </li>
                    <li>
                        <a href="#" class="btn-social btn-outline wow lightSpeedIn"><i class="fa fa-fw fa-linkedin"></i></a>
                    </li>
                    <li>
                        <a href="#" class="btn-social btn-outline wow lightSpeedIn"><i class="fa fa-fw fa-envelope"></i></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>
<!-- / #Contact -->

<!-- Footer -->
<footer>
    <div class="container text-center">
        <div class="row">
            <div class="col-lg-12">
                Copyright &copy; Your Website 2015
            </div>
        </div>
    </div>
</footer>
 <!-- / Footer -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>

    <script src="js/index.js"></script>

</body>
</html>
