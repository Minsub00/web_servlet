<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// getAttribute : Controller에서 setAttribute로 생성된 값을 이관 받음
	int product_m = (int) request.getAttribute("product_m");
	int product_s = (int) request.getAttribute("product_s");
	int product_p = (int) request.getAttribute("product_p");
	
	int total = (Integer) request.getAttribute("total");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 진행사항</title>
</head>
<%-- out.print : <%%> --%>
<body>
상품금액 : <%=product_m %><br>
할인률 : <%=product_s %>%<br>
적립금 : <%=product_p %><br>
최종 결제 금액 : <%=total %> <br>
<input type="button" value="결제하기">
</body>
</html>