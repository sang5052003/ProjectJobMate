<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개서 작성</title>
<head>
    <title>BLUEB</title>

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
</head>
 <body>
 	<form name="form" method="post" action="${ctx }/introduce/form.do" >
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
	  <br>제목<input name="title" type="text" id="title" size="40">
	  <br>내용<br>
			<textarea rows="13" cols="50" id="content" name="content"></textarea>
			<input type="submit" value="저장">
			<input type="reset" value="취소">
	</form>
			
		
</body>
</html>