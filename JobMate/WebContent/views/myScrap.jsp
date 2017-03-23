<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>


<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">

<link rel="stylesheet" href="${ctx}/css/style2.css">



</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">

			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#mainnav-navbar-collapse">
					MENU <span class="fa fa-bars color-white"></span>
				</button>
				<!-- Logo -->
				<a class="navbar-brand" href="${ctx }/main.do"><img
					src="${ctx }/image/logowhite.png"></a>
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
							<a class="button buttonBlue ot" href="${ctx }/logout.do">
								로그아웃
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
				<form>
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
				<h2>아이디,비밀번호,이름 입력해주세요.</h2>
				<form>
					<div class="group">
						<input type="text" required></span><span class="bar"></span> <label>ID</label>
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
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<br> <br> <br> <br> <br>
									<h1 class="text-center">내 채용정보</h1>
									<br> <br>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="section text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th>No.</th>
								<th>기업명</th>
								<th>제목</th>
								<th>삭제</th>
							</tr>
						</thead>

						<tbody>


							<c:forEach items="${list }" var="recruit" varStatus="sts">

								<tr>

									<td>${recruit.id }</td>
									<td>${recruit.name }</td>
									<td><a
										href="http://www.saramin.co.kr/zf_user/recruit/recruit-view/idx/${recruit.id }#utm_source=job-search-api&utm_medium=api&utm_campaign=saramin-job-search-api">${recruit.title }</a></td>
									<td><form action="${ctx }/myScrap/remove.do" method="get">
											<!-- <input name="recruitID" type="hidden" value="${recruit.id }">  -->
											<input name="recruitID" type="hidden" value="${recruit.id }">


											<input class="btn btn-xs btn-info btnPlay" type="submit"
												value="삭제">

										</form></td>


								</tr>


							</c:forEach>



						</tbody>

					</table>


				</div>
			</div>
		</div>
	</div>

	<!--  **************내 질문 목록*************** -->

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<br> <br> <br> <br> <br>
									<h1 class="text-center">내 면접질문</h1>
									<br> <br>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="section text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th>No.</th>
								<th>카테 고리</th>
								<th>질문 내용</th>
								<th>삭제</th>
							</tr>
						</thead>

						<tbody>


							<c:forEach items="${qlist }" var="question" varStatus="sts">

								<tr>

									<td>${question.questionNo }</td>
									<td>${question.category }</td>
									<td>${question.question }</td>
									<td><a
										href="http://www.saramin.co.kr/zf_user/recruit/recruit-view/idx/${recruit.id }#utm_source=job-search-api&utm_medium=api&utm_campaign=saramin-job-search-api">${recruit.title }</a></td>
									<td><form action="${ctx }/myScrap/remove.do" method="get">
											<!-- <input name="recruitID" type="hidden" value="${recruit.id }">  -->
											<input name="recruitID" type="hidden" value="${recruit.id }">


											<input class="btn btn-xs btn-info btnPlay" type="submit"
												value="삭제">

										</form></td>


								</tr>


							</c:forEach>



						</tbody>

					</table>


				</div>
			</div>
		</div>
	</div>




</body>

</html>