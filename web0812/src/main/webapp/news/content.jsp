<%@page import="com.aca.web0812.domain.News"%>
<%@page import="com.aca.web0812.news.model.NewsDAO"%>
<%!

NewsDAO newsDAO = new NewsDAO();

%>
<%
	int news_id = Integer.parseInt(request.getParameter("news_id"));	
	News news = newsDAO.select(news_id);
%>




<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;	
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
#comments-list {
	border:1px solid red;
	overflow:hidden;
}

#comments-list * {
	float:left;
}

.title-style {
	width:80%;
}
.writer-style {
	width:10%;
}
.regdate-style {
	width:10%;
}


</style>
<script>

	function regist() {
		var xhttp = new XMLHttpRequest();
		var detail = document.getElementsByName("detail")[0];
		var author = document.getElementsByName("author")[0];
		xhttp.open("POST","/comments/regist");
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("detail=" + detail.value + "&author=" + author.value+"&news_id=<%=news_id%>");
		
		
		xhttp.onreadystatechange=function() {
			if(this.readyState ==4 && this.status==200) {
				console.log("서버가 보낸 문자열 : " + this.responseText);
			}
		}
		
	}




</script>
</head>
<body>

<h3>뉴스기사 상세보기</h3>

<div class="container">

  <form name ="form1">
    <input type="text"  name="title" value="<%=news.getTitle()%>">
    <input type="text"  name="writer"  value="<%=news.getWriter()%>">
    <textarea  name="content" placeholder="내용 작성" style="height:200px"  ><%=news.getContent()%></textarea>

    <input type="button" value="등록" onClick = "regist()">
    <input type="button" value="목록" onClick = "location.href = '/news/list.jsp'/">
  </form>
  <form name ="form2">
  	<input type = "text" name = "detail" placeholder="댓글내용..." style="width:75%">
  	<input type = "text" name = "author" placeholder="작성자..." style ="width:10%">
  	<input type = "button" value = "댓글등록" onClick="regist()">
  
  </form>
	<div id="comments-list">
	<%for(int i = 0; i < 10; i++) { %>
		<div class="title-style">짜짜라라짜짜짜 짜파게티~!</div>
		<div class = "writer-style">리얼 개미</div>
		<div class = "regdate-style">리얼 개미</div>
	<%} %>
	
	</div>  
  
  
</div>

</body>
</html>
