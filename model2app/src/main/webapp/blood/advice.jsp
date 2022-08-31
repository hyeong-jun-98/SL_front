<%@page import="com.academy.model2app.blood.model.BloodManager"%>
<%@ page contentType="text/html; charset=utf-8"%>

    <!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String msg = (String) session.getAttribute("data");


%>
당신이 선택한 혈액형에 대한 결과 판단 : 
	<%=msg %>
</body>
</html>