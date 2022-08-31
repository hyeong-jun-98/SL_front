package com.academy.model2app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어떠한 종류의 컨트롤이건 상관없이 모든 컨트롤러의 최상위 객체를 정의한다.
// MovieController, BloodController건 모두 같은 자료형이다.
// 대신 어플리케이션의 모든 컨트롤러가 반드시 구현해야 할 메서드를 강제시키자.


public interface Controller {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
	public String getViewPage();

}
