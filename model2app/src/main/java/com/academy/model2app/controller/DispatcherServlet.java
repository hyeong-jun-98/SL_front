package com.academy.model2app.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모든 요청을 1:1 대응하는 컨트롤러를 전면에 내세우면 유지보수가 떨어지니다
public class DispatcherServlet extends HttpServlet {
	

	Properties props;
	
	// 생성자 or init()
	
	@Override
	public void init(ServletConfig config) throws ServletException {		// 서블릿이 호출될 때 초기화되는 메서드
		props = (Properties) config.getServletContext().getAttribute("props");
	}

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
		
		// 주의 검색 결과는 객체 컨트롤러 자체가 아닌 단지 문자열이가. 그 경로이다. (String)
		String controllerClassName = props.getProperty(uri);		// /movie.do or /blood.do
		
		// 결국 String 경로를 이용하여 실제 클래스의 인스턴스를 생성하는 법이다.
		try {
			// 문자열인 경로를 실제 클래스의 인스턴스로 생성한다.  그러나 아직 인스턴스는 올라오지 않았다. **new 하지 않았다.**
			Class controllerClass = Class.forName(controllerClassName);		
			controller = (Controller) controllerClass.newInstance(); 	// 예전버전
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		// 요청 분석
//		if (uri.equals("/movie.do")) {
//
//			// 영화 전담자인 MovieController에게 업무를 맡긴다..
//			controller = new MovieController();
//
//		} else if (uri.equals("/blood.do")) {
//
//			controller = new BloodController();
//
//		}

		controller.execute(request, response);		// 동생이 심은거
		
		// 5. 알맞는 뷰 페이지 보여주기
		// 포워딩 하기 전에 매핑 파일에서 검색한 후 (실제 jsp를 얻기위해)  동생은 키 값을 주기때문.
		
		String viewName = controller.getViewName();		// 키 값을 가져와서 viewName		/notice/result/write
		String viewPage = props.getProperty(viewName);		// value 값을 viewPage		/notice/list.jsp
		if(controller.isFoward() == true) {
			RequestDispatcher dis = request.getRequestDispatcher(viewPage);
			dis.forward(request, response);		// 형님이 자원 전달  -> list.jsp로 전달		데이터를 갱신할 때는 바로 가지말고 한 번 끊었다가 가야한다. 항상 foward가 좋은 게 아니다. 	
															// 가져갈 것이 있으면 포워딩을 한다 (request에 담아서) 글 쓸 때는 가져갈 것이 없음.
		} else {
			// 리다이렉트 : 요청을 끊고 브라우저로 하여금 지정한 url로 다시 들어오게 한다. 새로 들어올때는 .do로 들어온다.
			response.sendRedirect(viewPage);
		}
	}
	
//	// destroy() 생명주기가 끝날 때 호출되는 메서드
//	@Override
//	public void destroy() {
//		
//		if(fis!=null) {
//			try {
//				fis.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}

}
