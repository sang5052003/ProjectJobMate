<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>레시피 목록</h1>
<h2>${cookbook.name }</h2>
<span>${cookbook.description }</span>

<button type="button" onclick="javascript:location.href='${ctx}/introduce/form.do?cookbookId=${cookbook.id }';" class="btn">레시피 등록</button>
<br><br><br>
<c:forEach items="${cookbook.recipes }" var="recipe">
	<table class="section">
		<tr>
			<td>
				<img src="${ctx }/recipe/image.do?recipeId=${recipe.id}" width="128" height="128">
			</td>
		</tr>
		
		<tr>
			<td>
				<a href="${ctx }/recipe/detail.do?recipeId=${recipe.id}">${recipe.name }</a>
				<br>
				(${recipe.time }분/난이도:${recipe.level })
			</td>
		</tr>
	</table>
</c:forEach>
<c:if test="${empty cookbook.recipes }">
	<h2>등록된 레시피가 없습니다.</h2>
</c:if>

</body>
</html>