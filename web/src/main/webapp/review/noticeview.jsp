<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	

%>
<!DOCTYPE html>
<html>
<style>
.n {
	width: 500px;
	height : 300px;
	border : 1px solid black;
	overflow : hidden;
}
</style>
<head>
<meta charset="UTF-8">
<title>게시판 내용 확인</title>
</head>
<body>
제목 :<%=request.getAttribute("subject") %> <br>
글쓴이 : <%=request.getAttribute("writer") %><br>
내용 : <%=request.getAttribute("wtext") %><br>
</body>
</html>