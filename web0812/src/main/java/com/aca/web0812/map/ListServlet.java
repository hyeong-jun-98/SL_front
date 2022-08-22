package com.aca.web0812.map;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aca.web0812.domain.HotSpot;
import com.aca.web0812.model.HotSpotDAO;

public class ListServlet extends HttpServlet {

	public void init() throws ServletException {

	}

	HotSpotDAO hotSpotDAO = new HotSpotDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		List<HotSpot> list = hotSpotDAO.selectAll();
		// 아래처럼 생고생하지 않는다. 라이브러리를 이용한다. GSON..
		// 추후 스프링 사용 시 아래의 코드가 아닌 그냥 자동으로 제이슨 배열을 생성해준다.
		out.print("[");
		for (int i = 0; i < list.size(); i++) {
			HotSpot dto = list.get(i);
			
			out.print("{");
			out.print(" \"hotspot\" :"+dto.getHotspot_id()+",");
			out.print(" \"lati\" :"+dto.getLati()+",");
			out.print(" \"longi\" :"+dto.getLongi()+",");
			out.print(" \"icon\" :\""+dto.getIcon()+"\",");
			out.print(" \"content\" :\""+dto.getContent()+"\"");

			if (i < list.size() - 1) {
				out.print("},");
			} else {
				out.print("}");
			}
		}

		out.print("]");

	}
}
