package com.academy.model2app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.model2app.blood.controller.BloodController;
import com.academy.model2app.movie.controller.MovieController;

// 모든 요청을 1:1 대응하는 컨트롤러를 전면에 내세우면 유지보수가 떨어지니다
public class DispatcherServlet extends HttpServlet {

	// 모든 요청을 이 서블릿이 일단 받아야한다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	// 클라이언트의 요청이 어떤 방식이건 요청을 받기위해 공통 메서드에서 컨트롤러의 요청 처리를 진행
	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println("클라이언트 요청 시 추출한 uri : " + uri);

		Controller controller = null;
		// 요청 분석
		if (uri.equals("/movie.do")) {

			// 영화 전담자인 MovieController에게 업무를 맡긴다..
			controller = new MovieController();

		} else if (uri.equals("/blood.do")) {

			controller = new BloodController();

		}

		controller.execute(request, response);
		// 5. 알맞는 뷰 페이지 보여주기
		RequestDispatcher dis = request.getRequestDispatcher(controller.getViewPage());
		dis.forward(request, response);

	}

}
