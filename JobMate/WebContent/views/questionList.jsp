<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css"> -->
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">


</head>

<body>
	<%@ include file="/header/header.jspf"%>

	<br><br><br><br><br><br><br><br><br><br>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<form action="${ctx }/question/list.do" method="post">
						<div class="form-group">
							<div class="input-group">
								<select
									class="form-control" name="selCategory">
									<option value="both">전체</option>
									<option value="personality">인성면접</option>
									<option value="technology">기술면접</option>
								</select>
								<input type="text" name="search" class="form-control" placeholder="검색어 입력">
								<input type="hidden" name="pageNum" value="0"/> <!-- 검색시 첫번째 페이지 -->
								<span class="input-group-btn"> <input class="btn btn-success"
									type="submit" value="검색"/>

								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<form role="form" action="${ctx }/question/register.do" method="post">
						<div class="form-group">
							<div class="input-group">
								<select class="form-control" name="selCategory">
									<option value="personality">인성면접</option>
									<option value="technology">기술면접</option>
								</select>
								<input type="hidden" name="curPageNum" value="${curPageNum }"> <!-- 현재 페이지 기억 -->
								 <input type="text" name="question" class="form-control"
									placeholder="내용을 입력해 주세요"> <span
									class="input-group-btn"> <input class="btn btn-success" id="registerBtn"
									type="submit" value="등록"/>

								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container text-center">
			<div class="row">
				<div class="col-md-12">
					<table class="table text-center">
						<thead>
							<tr>
								<th>스크랩</th>
								<th>No</th>
								<th>카테고리</th>
								<th>질문내용</th>
								<th>작성자</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="question" varStatus="sts">
								<tr>
									<c:choose>
										<c:when test="${loginUser.customerID eq question.customerID }">
											<td><a href="#"><i class="fa fa-2x -o fa-star"></i></a></td>
										</c:when>
										<c:otherwise>
											<td><a href="#"><i class="fa fa-2x -o fa-star-o"></i></a></td>
										</c:otherwise>
									</c:choose>

									<td>${sts.count }</td>

									<td>${question.question }</td>
									<td>${question.customerID }</td>

									<c:choose>
										<c:when test="${loginUser.customerID eq question.customerID }">
											<td>
												<input type="button" value="삭제" onClick="location.href='${ctx }/question/delete.do?questionNo=${question.questionNo }&curPageNum=${curPageNum }'"/> <!-- 현재페이지 기억 -->

											</td>
										</c:when>
										<c:when test="${loginUser.customerID eq loginUser.adminID }">
											<td>
												<input type="button" value="삭제" src="${ctx }/question/delete.do?questionNo=${question.questionNo }&curPageNum=${curPageNum }"/> <!-- 현재페이지 기억 -->

											</td>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>

								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="section text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div>

						<!-- <button>&lt;</button> -->
						<a class="btn btn-xs btn-info btnPlay"
							href="${ctx }/question/list.do?pageNum=${curPageNum - 1 }">&lt;</a>
						<!-- do로 넘겨줌 pageNum -->
						<a class="btn btn-xs btn-info btnPlay"
							href="${ctx }/question/list.do?pageNum=0">1</a>
						<!-- do로 넘겨줌 pageNum -->
						<!-- 무조건 있는 1페이지 -->
						<c:forEach items="${sizeList }" var="element" varStatus="sts">
							<a class="btn btn-xs btn-info btnPlay"
								href="${ctx }/question/list.do?pageNum=${sts.count }">${sts.count + 1 }</a>
							<!-- do로 넘겨줌 pageNum -->
							<%-- <input type="button">${sts.count + 1 }</button> --%>
						</c:forEach>
						<a class="btn btn-xs btn-info btnPlay"
							href="${ctx }/question/list.do?pageNum=${curPageNum + 1 }">&gt;</a>
						<!-- do로 넘겨줌 pageNum -->
						<!-- <button>&gt;</button> -->

					</div>
				</div>
			</div>
		</div>
	</div>
	

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#registerBtn").click(function(){
            if($("input[name='question']").val() == ""){
//                 $("input[name='question']").css("border", "1px solid red").after("<span>내용을 입력해 주세요</span>");
//                 $("span").css("color", "red").fadeOut(2000);
                alert("글자를 입력해 주세요");
                return false;
            }
            else{
            }
         });
	});
</script>
	

</body>

</html>