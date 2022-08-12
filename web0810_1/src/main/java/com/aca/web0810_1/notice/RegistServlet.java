package com.aca.web0810_1.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class RegistServlet extends HttpServlet {

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

		// 사실 접속이라는 행위는 내부적으로 상당히 많은 절차와 인증을 거쳐야 하는 어려운 작업이다.
		// 이 시점부터는 절대로 자바 클래스 안에 추후 변경이 가능성이 큰 자원의 정보는 기재하지 않는다 (하드코딩 금지.)
		// 검색을 담당하는 검색객체 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			InitialContext ctx = new InitialContext();

			// DataSource 바로 커넥션 풀링을 구현한 객체이다.
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle"); // 매개변수로 검색어를 대입한다.

			con = ds.getConnection();
			String sql = "insert into board(board_id, title, writer, content) values (seq_board.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);

			int result = pstmt.executeUpdate(); // 실행
			
			out.print("<script>");
			if (result == 0) {
				out.print("alert('등록실패');");
				out.print("history.back();");
			} else {
				out.print("alert('등록성공');");
				out.print("location.href='/notice/list.jsp';");
			}
			out.print("</script>");

		} catch (NamingException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
