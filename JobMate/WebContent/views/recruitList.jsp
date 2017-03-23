<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath }</c:set>


<html>

<head>
<meta charset="UTF-8">
<title>취업메이트 - 채용관리</title>
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

<link rel="stylesheet" href="${ctx }/css/style2.css">


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
						<input type="text" required></span><span class="bar"></span> <label>ID</label>
					</div>
					<div class="group">
						<input type="password" required></span><span class="bar"></span>
						<label>Password</label>
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
									<h1 class="text-center">검색</h1>
									<br> <br>
								</div>
							</div>
							<div class="row">
								<div class="col-md-offset-3 col-md-6">

									<div></div>
									<form action="${ctx }/recruit/list.do" method="get">
										<div class="form-group">
											<div>
												지역 : <span><input type="radio" id="seoul"
													value="seoul" name="location"> <label for="seoul">서울
												</label> </span> <span> <input type="radio" id="gyeonggi"
													value="gyeonggi" name="location"> <label
													for="gyeonggi">경기 </label></span> <span><input type="radio"
													id="kwangju" value="kwangju" name="location"> <label
													for="kwangju">광주 </label></span> <span><input type="radio"
													id="daegu" value="daegu" name="location"> <label
													for="daegu">대구 </label> </span> <span><input type="radio"
													id="daejun" value="daejun" name="location"> <label
													for="daejun">대전 </label> </span> <span><input type="radio"
													id="busan" value="busan" name="location"> <label
													for="busan">부산 </label> </span> <span><input type="radio"
													id="ulsan" value="ulsan" name="location"> <label
													for="ulsan">울산 </label> </span> <span><input type="radio"
													id="incheon" value="incheon" name="location"> <label
													for="incheon">인천 </label> </span> <span><input type="radio"
													id="kangwon" value="kangwon" name="location"> <label
													for="kangwon">강원</label> </span> <span><input type="radio"
													id="jeju" value="jeju" name="location"> <label
													for="jeju">제주</label> </span>


											</div>

											<div>
												경력 : <span><input type="checkbox" id="new"
													value="newcomer" name="experience"> <label
													for="seoul">신입 </label> </span> <span> <input
													type="checkbox" id="old" value="experienced"
													name="experience"> <label for="gyeonggi">경력
												</label></span>

											</div>

											<div>
												학력 : <span> <select id="school" name="school">

														<option value="high">고등학교 졸업</option>
														<option value="collage">대학 졸업(2,3년)</option>
														<option value="univarsity">대학교 졸업(4년)</option>
														<option value="master">석사 졸업</option>
														<option value="doctor">박사 졸업</option>
												</select>

												</span>

											</div>
											<br> 기업명:
											<div class="input-group">
												<input type="text" name="searchText" class="form-control"
													placeholder="검색"><span></span> <span
													class="input-group-btn">
													<button class="btn btn-success" type="submit">Search</button>
												</span>
											</div>
										</div>
									</form>
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
								<th>지원자격</th>
								<th>근무조건</th>
								<th>마감일</th>
								<th>스크랩</th>
							</tr>
						</thead>

						<tbody>


							<c:forEach items="${list }" var="recruit" varStatus="sts">

								<tr>

									<td>${recruit.id }</td>
									<td><a href=${recruit.href }>${recruit.name }</a></td>
									<td><a
										href="http://www.saramin.co.kr/zf_user/recruit/recruit-view/idx/${recruit.id }#utm_source=job-search-api&utm_medium=api&utm_campaign=saramin-job-search-api">${recruit.title }</a></td>
									<td>${recruit.requiredEducationLevel }</td>
									<td>${recruit.jobType }/${recruit.location }</td>
									<td>${recruit.expirationTime }</td>

									<td><form action="${ctx }/myScrap/register.do"
											method="get">
											<!-- <input name="recruitID" type="hidden" value="${recruit.id }">  -->
											<input name="recruitID" type="hidden" value="${recruit.id }">
											<input name="name" type="hidden" value="${recruit.name}">
											<input name="title" type="hidden" value="${recruit.title }">

											<input class="btn btn-xs btn-info btnPlay" type="submit"
												value="담기">

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

<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js'></script>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>

<script src="${ctx}/js/index2.js"></script>

</html>