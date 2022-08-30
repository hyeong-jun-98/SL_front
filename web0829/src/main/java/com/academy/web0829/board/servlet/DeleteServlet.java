package com.academy.web0829.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.web0829.board.repository.BoardDAO;
import com.academy.web0829.domain.Board;

public class DeleteServlet extends HttpServlet {
	BoardDAO boardDAO = new BoardDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int board_id = Integer.parseInt(request.getParameter("board_id"));

		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);

		int result = boardDAO.delete(board_id);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<script>");

		if (result == 0) {
			out.print("alert('삭제실패');");
			out.print("history.back();");
		} else {
			out.print("alert('삭제성공');");
			out.print("location.href='/board/list.jsp'");

		}

		out.print("</script>");

	}
}
