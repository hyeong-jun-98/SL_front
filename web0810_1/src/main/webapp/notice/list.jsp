<%@page import="com.aca.web0810_1.model.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="com.aca.web0810_1.domain.Board"%>
<%@page contentType="text/html; charset=utf-8" %>
<%
// 직접 쿼리문을 수행하지 말고 이미 만들어 놓은 DAO를 이용한다.
BoardDAO boardDAO = new BoardDAO();
List<Board> boardList= boardDAO.selectAll();



%>

<!DOCTYPE html>
<html>
<head>
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
</style>
<script >

addEventListener("load", function() {
	document.querySelector("button").addEventListener("click", function() {
		location.href = "/notice/write.jsp";
	})
})

</script>

</head>
<body>

<h2>Zebra Striped Table</h2>
<p>For zebra-striped tables, use the nth-child() selector and add a background-color to all even (or odd) table rows:</p>

<table>
  <tr>
    <th width = "5%">No</th>
    <th width = "65%">title</th>
    <th width = "15%">writer</th>
    <th width = "10%">regdate</th>
    <th width = "5%">hit</th>
    
  </tr>
  <%for (int i = 0; i < boardList.size(); i++) { %>
<%Board board = boardList.get(i); %>
  
  <tr>
    <td><%=board.getBoard_id() %></td>
    <td><a href = "/notice/content.jsp?board_id=<%=board.getBoard_id()%>"><%=board.getTitle() %></a></td>
    <td><%=board.getWriter()%></td>
    <td><%=board.getRegdate().substring(0,10) %></td>
    <td><%=board.getHit()%></td>
    
  </tr>
  <%} %>
  
  
  <tr>
    <td colspan = "5">
    	<button>글 등록</button>
    </td>
  </tr>
</table>

</body>
</html>
