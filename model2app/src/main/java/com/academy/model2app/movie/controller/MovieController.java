package com.academy.model2app.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.model2app.movie.model.MovieManager;

/*
 * 영화에 대한 전문적인 지식을 가진 전담 컨트롤러
 * 요청을 직접 받지 않으므로 서블릿일 필요가 없다.
 * */

	
public class MovieController {
	
	MovieManager manager = new MovieManager();

		// 컨트롤러의 5대 업무 중 3 단계를 수행한다
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String movie = request.getParameter("movie");
		String msg = manager.getAdvice(movie);		// 영화에 대한 판단결과 반환 받기
		
		
		// 4. 결과 저장.
		request.setAttribute("data", msg);
		
		
		
		
		
		
	}
}
