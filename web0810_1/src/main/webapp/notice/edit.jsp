<%@page import="com.aca.web0810_1.model.BoardDAO"%>
<%@page import="com.aca.web0810_1.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    %>
    <%request.setCharacterEncoding("utf-8"); %>
   	<jsp:useBean id="board" class ="com.aca.web0810_1.domain.Board"/>
    <jsp:setProperty property="*" name="board"/>
    <%! BoardDAO boardDAO = new BoardDAO(); %>
    
    <%
    
    	//
    
    // 넘겨받은 파라미터를 이용하여 DB에 update (BoardDAO)
    // update board set title=?, writer=?, content=?, where board_id=?'
     int result = boardDAO.update(board);
    
    
    out.print("<script>");
    if(result == 0) {
    	out.print("alert('수정실패');");
    	out.print("history.back()");
    } else {
    	out.print("alert('수정성공');");
    
    	out.print("location.href='/notice/content.jsp?board_id=" +board.getBoard_id()+ "';");
    }
    out.print("</script>");
    		

    
    %>