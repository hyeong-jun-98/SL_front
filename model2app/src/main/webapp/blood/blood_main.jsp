<%@ page contentType="text/html; charset=utf-8"
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
function getResult() {
	var form = document.querySelector("form");
	form.action = "/blood.do";
	form.method="post";
	form.submit();
	
}

</script>
</head>
<body>
	<form>
		<select name ="blood">
			<option>당신의 혈액형을 선택하시오.</option>
			<option value="A">A형</option>
			<option value="B">B형</option>		
			<option value="O">O형</option>		
			<option value="AB">AB형</option>
		</select>
	</form>
		<button onClick="getResult()">결과 보기</button>
	
</body>
</html>