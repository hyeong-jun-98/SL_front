package com.academy.model2app.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.model2app.movie.model.MovieManager;

public class MovieController미사용 extends HttpServlet{
	
	MovieManager manager = new MovieManager();
	
	@Override		// 1. 요청 받는다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청을 받는다
		// 2. 요청을 분석한다.
		// 3. 알맞는 로직 객체에 일 시킨다
		// 4. 알맞는 결과 페이지로 전달할 것이 있다면 결과를 저장해 놓는다.
		// 5. 결과 페이지 보여주기.
		
		request.setCharacterEncoding("utf-8");
		String movie = request.getParameter("movie");
		
		
		// 3. 일 시킨다
		String msg = manager.getAdvice(movie);
		
		// 4. 결과 저장
//		HttpSession session = request.getSession();
//		session.setAttribute("data", msg);
		// 세션을 이용하면 브라우저를 닫지 않는 한 세션이 유지되어 데이터를 보관할 수 있지만
		// 세션 이외의 방법이 있다면 이용 안 할 이유가 없다.
		// 현실의 113,이메일 포워딩처럼 서버측의 특정 자원으로 현재 요청을 포워딩하는 기술을 지원하며 이때 사용되는 객체가 바로
		// RequestDispatcher
		
		request.setAttribute("data", msg);		// request는 요청이 끊기면 사라지지만 긍정적으로 보면 요청이 끊기기 전까지는 살아있다.
		RequestDispatcher dis = request.getRequestDispatcher("/movie/result.jsp");		// 포워딩 객체
		dis.forward(request, response);		// 포워딩 실행
		
		
		// 5. 알맞는 뷰 페이지 보여주기
//		response.sendRedirect("/movie/result.jsp");
		
		
	}

}
