package com.aca.web0812.news;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aca.web0812.domain.Comments;
import com.aca.web0812.domain.News;
import com.aca.web0812.news.model.CommentsDAO;
import com.google.gson.Gson;

// 댓글 둥록 요청을 처리하는 서블릿

public class CommentsRegist extends HttpServlet {
	CommentsDAO commentsDAO = new CommentsDAO();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String detail = request.getParameter("detail");
		String author = request.getParameter("author");
		String news_id = request.getParameter("news_id");
		
		//DTO에 담기
		Comments comments = new Comments();
		comments.setDetail(detail);
		comments.setAuthor(author);
	
		News news = new News();
		news.setNews_id(Integer.parseInt(news_id));		// 정수형으로 형변환
		comments.setNews(news);
		
		commentsDAO.insert(comments);
		
		
		
		// 클라이언트가 비동기 방식으로 요청을 한다는 것은 전페 HTMl 디자인을 바꾸겠다는게 아니라 현재 디자인 페이지는 유지하되
		// 오직 데이터만 주고받기 위함이다.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 이 뉴스 기사에 딸려있는 댓글 가져오기
		List<Comments> commentsList = commentsDAO.selectAll(news.getNews_id());
		
		// 클라이언트에게 등록과 동시에, 지금까지 누적된 댓글 목록을 보내주자.
		// 아래와 같이 json 표기를 문저열로 처리할 경우 개고생
		//	=>	GSON 이용
		
		// 목록 가져오기
		
		
		Gson gson = new Gson();
		String result = gson.toJson(commentsList);
		out.print(result);
		
		
	}

}
