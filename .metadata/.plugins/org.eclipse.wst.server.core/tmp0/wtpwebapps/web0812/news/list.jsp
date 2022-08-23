
<%
int totalRecord = 26; // 모든 레코드 수
int pageSize = 10; // 한페이지에 보여줄 레코드 수
int totalPage = (int) Math.ceil((float) totalRecord / pageSize); // 페이지 정하는 수
int blockSize = 10;

int currentPage = 1;

if (request.getParameter("currentPage") != null) {
	currentPage = Integer.parseInt(request.getParameter("currentPage")); // 현재 페이지  ()
}

int firstPage= (currentPage - (currentPage - 1))  + (blockSize * ((currentPage - 1) / blockSize));

int lastPage = firstPage + (blockSize -1);


int num = totalRecord - pageSize * (currentPage - 1);		// 페이지 당 시작 번호 1 page 26, 2 page 16

%>
<%="totalRecord : " + totalRecord + "<br>"%>
<%="pageSize : " + pageSize + "<br>"%>
<%="totalPage : " + (int) Math.ceil((float) totalRecord / pageSize) + "<br>"%>
<!-- 올림 후 정수 변환 -->
<%="blockSize : " + blockSize + "<br>"%>
<!--블록 사이즈 -->
<%="currentPage : " + currentPage + "<br>"%>
<%="firstPage : " + firstPage + "<br>"%>
<%="lastPage : " + lastPage + "<br>"%>
<!--블록 사이즈 -->
<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
.page-style {
	font-size:20px;
	font-weight:bold;
	color:red;


}

</style>
</head>
<body>

	<!-- 하나의 페이지에 너무 많은 데이터가 있을경우 원하는 크기로 분리하여 보여주는 기법을 페이징(Paging)이라고 한다. 페이징 처리는 결국 데이터에대한 산수계산이므로 개발자마다 스스로의 로직을 가지고 있어야한다. -->
	<table>
		<tr>
			<th width="5%">No</th>
			<th width="70%">기사제목</th>
			<th width="10%">작성자</th>
			<th width="10%">작성일</th>
			<th width="5%">조회수</th>
		</tr>
		<%for (int i = 1; i <= pageSize; i++) {%>
		<%if(num<1) break; %>
		<tr>
			<td><%=num-- %></td>
			<td>Smith</td>
			<td>50</td>
			<td>50</td>
			<td>50</td>
		</tr>
		<%
		}
		%>

		<tr>
			<td colspan="5" style="text-align: center">
				<!-- 페이지 출력 -->
				
				<%if(firstPage-1>0)  {%> 
				<a href = "/news/list.jsp?currentPage=<%=firstPage-1%>">◀</a>
				<%} else { %>
				<a href="javascript:alert('이전 페이지가 없습니다.');">◀</a> 
				<%} %>
				<%for (int i = firstPage; i <= lastPage; i++) { %>
				<%if(i > totalPage) break; %>
				<a href="/news/list.jsp?currentPage=<%=i%>"<%if(i==currentPage){ %> class="page-style"<%} %>>[<%=i%>] </a><!-- 페이지 눌러서 사이트 이동--> 
			<% } %>
			<%if(lastPage + 1 <=totalPage)  {%> 
			<a href = "/news/list.jsp?currentPage=<%=lastPage+1%>">▶</a>
			<%} else { %>
			<a href="javascript:alert('마지막 페이지입니다.');">▶</a>
			<%} %>
			</td>

		</tr>
		<tr>
		<td colspan = "5"><button onClick="location.href='/news/regist.jsp'/">뉴스 작성</button></td>
		
		
		
		</tr>
	</table>

</body>
</html>

