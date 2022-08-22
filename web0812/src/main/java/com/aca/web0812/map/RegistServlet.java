package com.aca.web0812.map;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aca.web0812.domain.HotSpot;
import com.aca.web0812.model.HotSpotDAO;

// 클라이언트의 요청을 처리하는 서블릿
public class RegistServlet extends HttpServlet {

	// 클라이언트가 비동기 요청을 하면, 하ㅕㄴ 전체를 바꾸려는 것이 아니라
	/// 데이터만을 교환하기 위함이므로, 기존 동기방식처럼 html 페이지 전체를 보내지말고,
	// 데이터만을 응답정보로 보내는게 올바르다..
	HotSpotDAO hotSpotDAO;

	public void init() throws ServletException {
		hotSpotDAO = new HotSpotDAO();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String lati = req.getParameter("lati");
		String longi = req.getParameter("longi");
		String icon = req.getParameter("icon");
		String content = req.getParameter("content");
		HotSpot hotSpot = new HotSpot();

		int result = hotSpotDAO.insert(hotSpot);
		// 4개의 파라미터를 하나로 모아서 전달할 DTO 생성

		hotSpot.setLati(Float.parseFloat(lati));
		hotSpot.setLongi(Float.parseFloat(longi));
		hotSpot.setIcon(icon);
		hotSpot.setContent(content);

		hotSpotDAO.insert(hotSpot);

		System.out.println(lati);
		System.out.println(longi);
		System.out.println(icon);
		System.out.println(content);

		/*
		 * 응답을 html로 잡지말고 insert한 결과가 성공 실패린지 여부 메세지 즉 복합된 결과를 보내고자 할 때 xml, json이 쓰인다
		 */

		/*
		 * 성공여부 코드 (0,1), 메세지('등록')
		 * 
		 */
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String resData = null;

		if (result == 0) {
			resData = "{";
			resData += " \"code\":0,";
			resData += " \"msg\" : \"데이터 등록 실패\"";
			resData += "}";
		} else {
			resData = "{";
			resData += " \"code\":1,";
			resData += " \"msg\" : \"데이터 등록 성공\"";
			resData += "}";
		}
		out.print(resData);

	}

}
