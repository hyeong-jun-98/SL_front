
package com.academy.web0829.board.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	List<Member> list;
	Member member;
	boolean isName = false;			// 실행부가 name 태그를 지나치고 있는 여부를 판단해주는 논리값
	boolean isNation = false;
	
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("문서 시작");
	}
	
	// 시작 태그를 만날 때 호출되는 메서드
	@Override
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.print("<" + tag + ">");
		
		// 시작 태그의 종류에 따라 알맞는 처리를 해야하므로 조건문을 써야한다
		if(tag.equals("members")) {							// 가장 바깥쪽 태그
			list = new ArrayList<Member>();
			
		} else if(tag.equals("member")) {						// 한명의 회원정보를 담을 DTO 준비
			member = new  Member();
			
		} else if(tag.equals("name")) {
			isName = true;
		} else if(tag.equals("nation")) {
			isNation = true;
		} 
		
		
	}
	// 태그 사이의 데이터를 만날 때 호출되는 메서드
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		System.out.print(content);
		
		
		// 지금 지나가는 실행부가
		if(isName) {
			member.setName(content);
			
		} else if(isNation) {
			member.setNation(content);
			
		} 
		
	}
	// 닫는 태그를 만날 때 호출되는 메서드
	@Override
	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.println("</" + tag + ">");
		
		if(tag.equals("name")) {
			isName = false;
		} else if(tag.equals("nation")) {
			isNation = false;
		} else if(tag.equals("member")) {
			list.add(member);
		}
		
		
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("문서 종료! list 사이즈 : " + list);
	}
	
	
}
