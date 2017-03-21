<%@page import="jobmate.common.exception.JMRuntimeException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>취업메이트</title>
</head>
<body>

<header>에러 메시지</header>
<br>

<h1><%= exception.getMessage() %></h1>

<%
	String redirectURL = null;
	if(exception instanceof JMRuntimeException){ // import됨
		JMRuntimeException ex = (JMRuntimeException)exception;
	
		redirectURL = ex.getRedirectURL();
	}
	
	if(redirectURL !=null && redirectURL.length() > 0 ){
%>
		<button onclick="javascript:location.href='<%=redirectURL %>'">확인</button><br>
<% 		
	}else{
%>
		<button onclick="javascript:history.back();">확인</button> 
<!-- 		로그인 누르는 창으로 돌아감 -->
<% 
	}
%>


</body>
</html>