<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>면접답변</title>
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

<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript">
function replyUpdateOpen(replyNo){
	window.name = "parentForm";
	window.open("${ctx}/reply/update.do?replyNo="+replyNo,
	
			"updateForm", "width=570, height=350, resizable = no, scrollbars = no");
}
</script>

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
				<div class="col-md-12 text-right">
					<h3 class="text-center">${question.category }</h3>
					<h1 class="text-center">${question.question }</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="section text-right">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<p class="text-right">
						스크랩하기 <a href="#"><i class="fa fa-2x -o fa-star-o"></i></a>fa-star
					</p>
				</div>
			</div>
		</div>
	</div>
	<form action="${ctx }/reply/register.do" method="post">
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-10">

						<div class="form-group">
							<div class="input-group input-group-lg">
								<input type="text" class="form-control" name=name
									placeholder="내용을 입력해 주세요" value="">
							</div>
						</div>
					</div>
					<input type="hidden" name="questionNo"
						value="${question.questionNo}" />
					<div class="col-md-1">
						<input class="btn btn-lg btn-primary" type="submit" value="댓글입력">
					</div>
				</div>
			</div>

		</div>
	</form>
	<div class="section">
		<div class="container text-center">
			<div class="row">
				<div class="col-md-12">
					<table class="table text-center">
						<thead>
							<tr>

								<th>No</th>
								<th>답변내용</th>
								<th>작성자</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${question.replys}" var="reply"
								varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${reply.content }</td>
									<td>${reply.customerID }</td>
									<c:if test="${loginUser eq reply.customerID}">
										<td><a
											href="${ctx}/reply/delete.do?replyNo=${reply.replyNo}&questionNo=${question.questionNo}">삭제</a></td>
										<td><a href="#"
											onclick="replyUpdateOpen(${reply.replyNo})">수정</a></td>
									</c:if>

								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<hr>
				</div>
			</div>
		</div>
	</div>
	<div class="section text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div>
						<button>&lt;</button>
						<button>1</button>
						<button>2</button>
						<button>3</button>
						<button>&gt;</button>
					</div>
				</div>
			</div>
		</div>
	</div>

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
