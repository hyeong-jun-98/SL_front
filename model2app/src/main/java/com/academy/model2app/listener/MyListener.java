package com.academy.model2app.listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

	// 서버가 가동될 떄 무언가 하고싶을 떄
public class MyListener implements ServletContextListener{
	FileInputStream fis;
	Properties props = new Properties();
	
	
	// 웹 컨테이너가 가동될 때 호출되는 메서드
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context =  sce.getServletContext();		// 
		String path = context.getInitParameter("contextConfigLocation");		// 경로 가져오고
		context.setAttribute("props", props); // 4 컨트롤러의 4번째 일. 저장할 내용이 있으면 넣어준다
		
		try {
			
			fis = new FileInputStream(context.getRealPath(path));  // 실제 물리적 경로로 넣어준다.
			props.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 웹 컨테이너가 중단될 때 호출되는 메서드
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if(fis!=null) {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
