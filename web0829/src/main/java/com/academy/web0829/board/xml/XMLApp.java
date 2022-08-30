package com.academy.web0829.board.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLApp {
	SAXParserFactory factory = SAXParserFactory.newInstance(); // SingleTon
	
	public XMLApp() {
		try {
			
			SAXParser saxParser = factory.newSAXParser();		// 파서 준비!
			MyHandler handler = new  MyHandler();
			saxParser.parse(new File("C:/Users/SL/eclipse-workspace/web0829/src/main/java/com/academy/web0829/board/xml/member.xml"), handler);
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		new XMLApp();
		
		
		
	} 

}
