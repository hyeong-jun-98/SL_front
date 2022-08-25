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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>

	// 댓글 목록 출력하기
function showCommentsListByString(jsonArray) {		// 댓글이 json 형식으로 받아옴
		console.log("넘겨받는 데이터 배열 크기" , jsonArray.length);
	
		// 넘어온 데이터가 문자열이므로 객체처럼 사용할 수 없는 상태  제이슨 형식으로 바꾼다
		var data = JSON.parse(jsonArray);
		console.log("제이슨 객체 수", data.length);
			
		// div 안의 컨텐츠를 js의 DOM을 이용하여 동적으로 출력해본다.
			var commentsList = document.getElementById("comments-list");
		
		// 문자열로 취급하는 방법
		var tag="";
		for(var i =0; i < data.length;i++) {
			tag += "<div class=\"title-style\">짜짜라라짜짜짜 짜파게티~!</div>";
			tag += "<div class = \"writer-style\">리얼 개미</div>";
			tag += "<div class = \"regdate-style\">리얼 개미</div>";
			
		}
	
		commentsList.innerHTML=tag;
}
	
	// DOM 객체로 처리하는 방법
function showCommentsListByDom(jsonArray) {
		
		var data = JSON.parse(jsonArray);
		var commentsList = document.getElementById("comments-list");
		
		// 출력전에 기존 요소들은 삭제하자
		commentsList.innerHTML="";
		
		
		for(var i = 0; i < data.length; i++) {
			var json = data[i];
			var div1 = document.createElement("div");		// title-style
			var div2 = document.createElement("div");		// writer-style
			var div3 = document.createElement("div");		// regdate-style
			
			// 생성된 DOM 요소에 클래스 적용
			div1.className="title-style";
			div2.className="writer-style";
			div3.className="regdate-style";
			
			// div안의 컨텐츠 구성
			div1.innerText=json.detail;
			div2.innerText=json.author;
			div3.innerText=json.writedate;
			
			// 조립
			commentsList.appendChild(div1);
			commentsList.appendChild(div2);
			commentsList.appendChild(div3);
			
		}
		
		
		
}
	
	
	
	
	// 비동기 요청
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
				showCommentsListByDom(this.responseText);		// 출력함수로 전달
				
				
			}
		}
		
	}
	// 비동기 방식으로 댓글 목록 가져오기
function getComments() {
	$.ajax({
		url:"/comments/list?news_id=<%=news_id%>",
		success:function(result) {	// result = responseText
			alert(result);
			showCommentsListbyDom(result);
		}
	});
	
}
function del() {
	
	if(confirm("삭제?")){
		location.href="/news/delete?news_id=<%=news_id%>";
	}
}
	

function init() {
	getComments();
	
	
	
}


</script>
</head>
<body onLoad()="init()">

<h3>뉴스기사 상세보기</h3>

<div class="container">

  <form name ="form1">
    <input type="text"  name="title" value="<%=news.getTitle()%>">
    <input type="text"  name="writer"  value="<%=news.getWriter()%>">
    <textarea  name="content" placeholder="내용 작성" style="height:200px"  ><%=news.getContent()%></textarea>

    <input type="button" value="등록" onClick = "regist()">
    <input type="button" value="목록" onClick = "location.href = '/news/list.jsp'/">
    <input type="button" value="수정" onClick = "edit()">
    <input type="button" value="삭제" onClick = "del()">
  </form>
  <form name ="form2">
  	<input type = "text" name = "detail" placeholder="댓글내용..." style="width:75%">
  	<input type = "text" name = "author" placeholder="작성자..." style ="width:10%">
  	<input type = "button" value = "댓글등록" onClick="regist()">
  
  </form>
	<div id="comments-list">
	
		
	
	
	</div>  
  
  
</div>

</body>
</html>
