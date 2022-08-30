package com.academy.web0829.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.web0829.board.repository.BoardDAO;
import com.academy.web0829.domain.Board;
//
public class RegistServlet  extends HttpServlet{
	BoardDAO boardDAO = new BoardDAO();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		int result = boardDAO.insert(board);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<script>");
		
		
		if(result == 0) {
			out.print("alert('등록실패');");
			out.print("history.back();");
		} else {
			out.print("alert('등록성공');");
			out.print("location.href='/board/list.jsp';");
			
		}

		out.print("</script>");
		
//		// 쿼리문이 들어있는 BoardMapper.xml를 이용한다.
//		String resource = "com/academy/web0829/mybatis/config.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// mybatis를 이용하면 쿼리문을 수행하기 위한 객체인 sqlsession 객체를 이용하여 sql 문을 호출할 수 있다.
//		SqlSession sqlSession = Factory.openSession();
//		int result = sqlSession.insert("babo.insert", board);
//		sqlSession.commit();
//		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		if(result > 0) {
//			out.print("등록성공");
//		}  else {
//			out.print("등록실패");
//		}
//		
		
	}

}
