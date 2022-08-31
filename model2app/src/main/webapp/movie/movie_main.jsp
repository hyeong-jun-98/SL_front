<%@ page  contentType="text/html; charset=utf-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
function getResult() {
	var form = document.querySelector("form");
	form.action = "/movie.do";
	form.method="post";
	form.submit();
	
}

</script>
</head>
<body>
	<form>
		<select name ="movie">
			<option>최신에 본 영화를 선택하시오.</option>
			<option value="이상한 변호사 우영우">이상한 변호사 우영우</option>
			<option value="오징어 게임">오징어 게임</option>		
			<option value="탑건 메버릭">탑건 메버릭</option>		
			<option value="헐크">헐크</option>
		</select>
	</form>
		<button onClick="getResult()">결과 보기</button>
	
</body>
</html>