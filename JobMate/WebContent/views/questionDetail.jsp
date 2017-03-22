<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
function cmUpdateOpen(comment_num){
	window.name = "parentForm";
	window.open("reply/update.do?num="+comment_num,
	
			"updateForm", "width=570, height=350, resizable = no, scrollbars = no");
}
</script>

</head>

<body>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-right">
					<h3 class="text-center">인성면접</h3>
					<h1 class="text-center">삶의 좌우명은?</h1>
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
										<td><a href="#" onclick="cmUpdateOpen(${reply.replyNo})">수정</a></td>
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
</body>

</html>
