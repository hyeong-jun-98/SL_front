package web0809.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
public class EditServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String board_id = req.getParameter("board_id");
		String sql = "update board set title = ?, writer = ?, content = ?  where board_id = "  + board_id;
		
		PrintWriter out = resp.getWriter();
		out.print(sql);
	}

}
