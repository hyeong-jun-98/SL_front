<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
function getResult() {
	var form = document.querySelector("form");
	form.action = "/blood";
	form.method="post";
	form.submit();
	
}

</script>
</head>
<body>
	<form>
		<select name ="blood">
			<option>����� �������� �����Ͻÿ�.</option>
			<option value="A">A��</option>
			<option value="B">B��</option>		
			<option value="O">O��</option>		
			<option value="AB">AB��</option>
		</select>
	</form>
		<button onClick="getResult()">��� ����</button>
	
</body>
</html>