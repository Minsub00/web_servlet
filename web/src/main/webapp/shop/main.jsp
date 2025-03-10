<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession hs = request.getSession();
	String mid = (String)hs.getAttribute("mid");
	String mnm = (String)hs.getAttribute("mnm");
	if(mid != null || mnm != null){
		out.print("<script>alert('이미 로그인 하셨습니다.');</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 메인 화면</title>
</head>
<body>
<% if(mid == null || mnm == null){ %>
<input type="button" value="로그인">
<%} else{ %>
[<%=mid %>] <%=mnm %> 님 환영합니다.<input type="button" value="로그아웃" onclick="logout()">
<% } %>
</body>
<script>
function logout(){
	location.href='./logout.jsp';
}
</script>
</html>