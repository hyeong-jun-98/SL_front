package com.aca.web0812.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aca.web0812.model.HotSpotDAO;

public class SelectServlet  extends HttpServlet{
	// 방금 입력된 레코드 한 건 가져오기

	HotSpotDAO dao;
	
	public void init() throws ServletException {
		dao = new HotSpotDAO();
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HotSpot dto = dao.select();
//		response.setContentType("text/html;charset-utf-8");
//		PrintWriter out = response.getWriter();
//		
//		out.print("{");
//		out.print(" \"hotspot\" :"+dto.getHotspot_id()+",");
//		out.print(" \"lati\" :"+dto.getLati()+",");
//		out.print(" \"longi\" :"+dto.getLongi()+",");
//		out.print(" \"icon\" :\""+dto.getIcon()+"\",");
//		out.print(" \"content\" :\""+dto.getContent()+"\"");
//		out.print("}");
//		
		
	}
}
