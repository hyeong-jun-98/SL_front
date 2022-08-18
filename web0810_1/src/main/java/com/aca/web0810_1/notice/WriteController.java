package com.aca.web0810_1.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aca.web0810_1.domain.Board;
import com.aca.web0810_1.model.BoardDAO;

public class WriteController extends HttpServlet {
	BoardDAO boardManager;

	// 이 서블릿 클래스가 최초의 접속자에 의해 인스턴스화 될 때 딱 한 번 호출되는 생명주기 메서드
	@Override
	public void init() throws ServletException {
		boardManager = new BoardDAO();

	}
//
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 클라이언트가 전송해 온 파라미터 받기
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 넘어온 파랕미터를 이용하여 DB에 insert하여 직접이 아닌 중립적 객체를 이용할 것이다.
		//insert()에서 사용하고 있는 각각의 매개변수는 사실 하나의 게시물을 구성하는 데이터이다.
		// 따라서 객체지향 관점으로본다면 하나의 게시물은 하나의 레코드에 해당하므로, 게시물을 담을 수 있는 클래스를 정의하여
		// 인스턴스 생성 후 변수들을 보관해놓는 기법을 이용한다. 이때 정의되는 클래스는
		// 로직을 박성하기 위함이 아니라 오직 데이터만을 담고 가지고 다니는 용도로 하여
		// Data Transfer Object (DTO), Value Obj (VO)
		
		Board board = new Board();

		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
	
		int result = boardManager.insert(board);

		out.print("<script>");
		if (result == 0) {
			out.print("alert('등록실패');");
			out.print("history.back();");
		} else {
			out.print("alert('등록성공');");
			out.print("location.href='/notice/list.jsp';");
		}
		out.print("</script>");

	}

}
