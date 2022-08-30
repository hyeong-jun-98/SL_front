package com.academy.web0829.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class Pager {

	private int totalRecord; // 총 레코드 수
	private int pageSize = 10; // 페이지 당 보여질 레코드 수
	private int totalPage;
	private int blockSize = 10; // 블럭 당 보여질 페이지 수
	private int currentPage = 1;
	private int firstPage;
	private int lastPage;
	private int curPos; // 페이지 당 시작 index (커서의 위치)
	private int num; // 게시물 시작 번호

	// 공식을 대입하기 위한 메서드
	public void init(List list, HttpServletRequest request) {
		totalRecord = list.size();
		totalPage = (int) Math.ceil((float) totalRecord / pageSize);
		if(request.getParameter("currentPage")!= null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage - (currentPage - 1) % blockSize;
		lastPage = firstPage + (blockSize -1);
		curPos = (currentPage - 1) * pageSize;
		num = totalRecord - curPos;

	}
}
