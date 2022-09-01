package com.academy.model2app.blood.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.model2app.blood.model.BloodManager;
import com.academy.model2app.controller.Controller;

public class BloodController implements Controller{
	
	BloodManager manager = new BloodManager();
	
	public void execute (HttpServletRequest request, HttpServletResponse response) {
		
		// 3단계 일 시키기
		String blood = request.getParameter("blood");
		String msg = manager.getAdvice(blood);
		
		// 4단계 저장하기
		request.setAttribute("data", msg);
		
		
	}
	
	public String getViewName() {
		
		return "/blood/result";
	}

}
