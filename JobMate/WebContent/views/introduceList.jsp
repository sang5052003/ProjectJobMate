<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개서</title>
<script language="JavaScript">

function check(){
        if (form.select.value == '1') {
            form.category.readOnly = false;
            form.category.value = '';
            form.category.focus();
        }
        else {
            form.category.readOnly = true;
            form.category.value = form.select.value;
        }
    }

</script>
</head>
<body>
<h1>자기소개서 리스트</h1>
<form name="form" action="${ctx }/introduce/list.do"method="post">
		카테고리<select name="select" class="box" id="select" onChange="check();">
			    <option value="" selected>선택하세요</option>
			    <option value="pros">장점</option>
			    <option value="cons">단점</option>
			    <option value="hobby">취미</option>
			    <option value="specility">특기</option>
			    <option value="aspiration">포부</option>
			    <option value="motto">좌우명</option>
			    <option value="1">직접입력</option>
			</select>
	  <input name="category" type="text" class="box" id="category" size="20">
	  <br><select name="selectSearch" id="selectSearch">
	  		<option value="title">제목</option>
	  		<option value="content">내용</option>
	  	</select>
	  <input name="search" type="text" id="search" size="40">
	  <input type="submit" value="검색">
</form>
<button type="button" onclick="javascript:location.href='${ctx}/introduce/form.do?customerID=choi';" class="btn">새 자기소개서 추가</button>
<br><br><br>
<c:choose>

<c:when test="${tIntroduces != null }">
<c:forEach items="${tIntroduces }" var="tIntroduce"><!-- title로 검색 -->
	<table class="section">
		<tr>
			<td>
				<a href="${ctx }/introduce/detail.do?introduceNo=${tIntroduce.introduceNo}">${tIntroduce.title }</a>
			</td>
		</tr>
	</table>
</c:forEach>
</c:when>

<c:when test="${cIntroduces != null }">
<c:forEach items="${cIntroduces }" var="cIntroduce"><!-- category로 검색 -->
	<table class="section">
		<tr>
			<td>
				<a href="${ctx }/introduce/detail.do?introduceNo=${cIntroduce.introduceNo}">${cIntroduce.title }</a>
			</td>
		</tr>
	</table>
</c:forEach>
</c:when>
<c:otherwise>
<c:forEach items="${introduces }" var="introduce"><!-- 전체 -->
	<table class="section">
		<tr>
			<td>
				<a href="${ctx }/introduce/detail.do?introduceNo=${introduce.introduceNo}">${introduce.title }</a>
			</td>
		</tr>
	</table>
</c:forEach>

</c:otherwise>
</c:choose>
</body>
</html>