<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>취업메이트 - 스펙공유</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  	<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.css'>
	<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css'>
	<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css'>
	<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat:400,700'>
	<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic'>

    <link rel="stylesheet" href="../css/style2.css">

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
           <a class="navbar-brand" href="/index.html"><img src="../image/logowhite.png"></a>
        </div>

        <!-- Navigation Links -->
        <div class="collapse navbar-collapse" id="mainnav-navbar-collapse">
            <ul class="nav navbar-nav navbar-default">
               <li class="page-scroll">
                    <a href="/recruit.html">채용관리</a>
                </li>
                <li class="page-scroll">
                    <a href="/introduce.html">자기소개서</a>
                </li>
                <li class="page-scroll">
                    <a href="/spec.html">스펙공유</a>
                </li>
                <li class="page-scroll">
                    <a href="/question.html">면접질문</a>
                </li>
                <li class="page-scroll">
                    <a href="../views/interview.jsp"><span style="color:#9fe7ff">가상면접</span></a>
                </li>
                <li class="page-scroll">
                    <a href="/myscrap.html">내 스크랩</a>
                </li>
                
            </ul>
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
             
        </div>
        
    </div>
    <div class="login-modal-overlay">
  
  <div class="login-modal">
    <h1>로그인</h1>
    <h2>아이디,비밀번호를 입력해주세요.</h2>
    <form>
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
    <h2>아이디,비밀번호,이름 입력해주세요.</h2>
    <form>
      <div class="group">
        <input type="text" required></span><span class="bar"></span>
        <label>ID</label>
      </div>
        
      <div class="group">
        <input type="password" required></span><span class="bar"></span>
        <label>Password</label>
      </div>
         <div class="group">
        <input type="password" required></span><span class="bar"></span>
        <label>Password Check</label>
      </div>
        
    <div class="group">
        <input type="text" required></span><span class="bar"></span>
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

<!-- #interview -->
<section id="interview">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Stay Connected</h2>
                <p>Join me on my social networks for all the latest updates and more.</p>
                                <h2>Stay Connected</h2>
                <p>Join me on my social networks for all the latest updates and more.</p>
                                <h2>Stay Connected</h2>
                <p>Join me on my social networks for all the latest updates and more.</p>
                                <h2>Stay Connected</h2>
----------------------------------------------------------------------

	
	<form action="../interview.do" method="post" >

		<input type="radio" name="category" id="personality" value="personality"><label for="personality">인성</label>
    	<input type="radio" name="category" id="technology" value="technology"><label for="technology">기술</label>
        <input type="radio" name="category" id="myQuestion" value="myQuestion"> <label for="myQuestion">나만의질문</label> <br><br>
        
        <input type="radio" name="time" id="time1" value="time1"><label for="time1">1분</label>
    	<input type="radio" name="time" id="time2" value="time2"><label for="time2">1분 30초</label>
        <input type="radio" name="time" id="time3" value="time3"><label for="time3">2분</label><br><br>
        
        <input type="radio" name="count" id="one" value="1"><label for="one">1개</label>
    	<input type="radio" name="count" id="two" value="2"><label for="two">2개</label>
        <input type="radio" name="count" id="three" value="3"><label for="three">3개</label>    	
        <input type="radio" name="count" id="four" value="4"><label for="four">4개</label>
        <input type="radio" name="count" id=five value="5"><label for="five">5개</label>
        
         <input class="btn btn-success" type="submit" value="시작하기">

 </form>       
                     
            </div>
        </div>
    </div>
</section>
<!-- / #interview -->



















 <!-- / Footer -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>

    <script src="js/index.js"></script>

</body>
</html>