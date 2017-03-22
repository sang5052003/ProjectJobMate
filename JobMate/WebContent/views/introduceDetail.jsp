<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개서 상세보기</title>
	
</head> 
<body> 
	<table class="board_view"> 
		<colgroup> <col width="15%"/> 
			<col width="35%"/> 
			<col width="15%"/> 
			<col width="35%"/> 
		</colgroup> 
	<caption style="background-color: #ccc">자기소개서 상세</caption> 
	<tbody> 
		<tr>
			 <th scope="row">글 번호</th> 
			 <td>${introduce.introduceNo }</td> 
			 
		</tr> 
		<tr> 
			<th scope="row">제목</th> 
			<td colspan="3">${introduce.title }</td> 
		</tr> 
		<tr> 
			<td colspan="4" style="border: 1px solid #ccc; height : 100px;">${introduce.content }</td> 
		</tr> 
	</tbody> 
	</table> 
	<a href="${ctx }/introduce/update.do?introduceNo=${introduce.introduceNo}" class="btn" id="update">수정</a> 
	<a href="${ctx }/introduce/delete.do?introduceNo=${introduce.introduceNo}" class="btn" id="delete">삭제</a>
</body>
</html>
