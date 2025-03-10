<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArrayList<String> data = (ArrayList)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매 확인</title>
</head>
<body>
고객명 : <%=data.get(0) %> <br>
연락처 : <%=data.get(1) %> <br>
선택 영화 : <%=data.get(2) %> <br>
예매 일자 : <%=data.get(3) %> <br>
<input type="button" value="확인" onclick="ok()">
</body>
<script>
function ok(){
	alert("예매가 완료되었습니다.");
	location.href = "./reservation.html";
}
</script>
</html>