<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String word = (String) request.getAttribute("subject"); // null, "" : O
	// String word = request.getAttribute("abc").toString(); // "" : O, null : X
	// String word = String.valueOf(request.getAttribute("abc")); // null, "" : O
	
	String etc[] = (String[]) request.getAttribute("etc"); 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과값</title>
</head>
<body>
선택하신 과목 : <%=word %> <br>
배우고 싶은 과목 : <%
int w = 0;
while(w<etc.length){ // Controller에서 원시배열로 받은 값을 반복문으로 View에서 처리
	out.print(etc[w] + ", ");
	w++;
}
%>
</body>
</html>