<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String mid = (String) request.getAttribute("mid");
	String cnum = (String) request.getAttribute("mnum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=mid %> <br>
쿠폰번호 : <%=cnum %><br>
광고 수신 동의함
</body>
</html>