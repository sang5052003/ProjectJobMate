<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개서 작성</title>

</head>
 <body>
 	<form action="${ctx }/introduce/update.do" method="post">
 	<input type="hidden" name="introduceNo" value="${introduce.introduceNo }">
		<table>
			<tr>
			
			<th>카테고리<th>
			<select id="select" name="select">
				<option value="" selected>선택하세요</option>
				<option value="pros">장점</option>
				<option value="cons">단점</option>
				<option value="hobby">취미</option>
				<option value="speciality">특기</option>
				<option value="aspiration">포부</option>
				<option value="motto">좌우명</option>
				<option value="custom">직접입력</option>
			</select>
			
			</tr>
			
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="title" name="title">
				</td>
			</tr>
			
			<tr>
				<th>내용<th><br>
				<textarea rows="13" cols="50" id="content" name="content"></textarea>
		</table>
		<input type="submit" value="확인">
		<input type="reset" value="취소">
	</form>		
</body>