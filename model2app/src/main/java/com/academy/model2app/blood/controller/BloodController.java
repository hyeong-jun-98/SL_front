package com.academy.model2app.blood.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academy.model2app.blood.model.BloodManager;

/* 아래의 클래스는 MVC 중 C를 정의한다.
 * 컨트롤러란? M과 V를 분리시켜 개발하기 위한 중재자를 의미한다
 *  
 *  컨트롤러의 5대임무
 *  1. 요청을 받아야한다.
 *  2. 요청을 분석한다.
 *  3. 알맞는 비즈니스 로직 객체에게 일 시킨다. 
 *  4. 결과인 View에 전달할 것이 있을 경우 결과를 저장해놓는다. (임시로 저장해놓는다)
 *  5. 알맞는 뷰를 이용하여 결과 보여주기.
 *  
 * */

public class BloodController extends HttpServlet {

	BloodManager manager = new BloodManager();

	@Override 	// 1. 요청을 받는다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		// 클라이언트가 선택한 파라미터를 분석하여 적절한 결과 보여주기
		request.setCharacterEncoding("utf-8");
		String blood = request.getParameter("blood");
		
		// 3. 알맞는 로직 객체에게 일 시킨다.
		String msg = manager.getAdvice(blood);
		
		// 4. 결과 페이지로 가져갈 것이 있을 경우 결과를 저장해놓아야 한다
		HttpSession session = request.getSession();		// 세션은 request로부터 가져올 수 있음
		session.setAttribute("data", msg);
		
		// 5. 알맞는 뷰를 이용하여 결과 보여주기  (페이지 이동)
		response.sendRedirect("/blood/advice.jsp");   			// 클라이언트 브라우저로 하여금 지정한 url로 재접속을 명령함
		
		
	}

}
