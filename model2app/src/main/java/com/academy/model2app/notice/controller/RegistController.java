package com.academy.model2app.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.model2app.controller.Controller;
import com.academy.model2app.domain.Notice;
import com.academy.model2app.model.repository.NoticeDAO;

// 1,2는 형님이 실시한다
// 3번째 단계를 실시한다 -> 알맞는 모델 객체에게 일 시키기
// 4.  저장할 것이 있다면 저장한다. (DML일 경우 생략한다.)

public class RegistController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);

		int result = noticeDAO.insert(notice);		// 일 시키기.
		
		
	}

	@Override
	public String getViewName() {
		
		return "/notice/result/write" ;
	}

	@Override
	public boolean isFoward() {
			// 등록하고 유지할 것이 없기 때문에 포워딩을 할 필요가 없다, 데이터를 유지할 필요가 없다 request를 죽여도 된다. 응답을 해버리고
			// 응답을 하는순간 서버와 클라이언트 연결이 끊기고 클라이언트는 새로운 주소로 들어온다.
		return false;
	}

}
