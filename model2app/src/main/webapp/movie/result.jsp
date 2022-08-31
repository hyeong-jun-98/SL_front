<%@ page contentType="text/html; charset=utf-8"
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<%
	String msg = (String) request.getAttribute("data");
	
%>
선택한 영화에 대한 판단 : 
<%=msg %>


</body>
</html>