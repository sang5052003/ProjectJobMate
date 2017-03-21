<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개서 작성</title>
</head>
 <body>
 	<form action="post">
		<table>
			<tr>
			<td>
			<th>카테고리<th>
			<select id="select">
				<option value="init">=== 선택 ===</option>
				<option value="gmail.com">gmail.com</option>
				<option value="naver.com">naver.com</option>
				<option value="nate.com">nate.com</option>
				<option value="daum.net">daum.net</option>
			</select>
			</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" id="name">
				</td>
			</tr>
			<tr>
				<th>내용<th><br>
				<textarea rows="13" cols="50"></textarea>
		</table>
		<input type="submit" value="저장">
		<input type="reset" value="취소">
	</form>		
</body>
</html>