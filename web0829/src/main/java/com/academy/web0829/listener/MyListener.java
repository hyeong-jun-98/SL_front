package com.academy.web0829.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("서버 가동 감지했어");
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("서버 종료 감지했어");
	}

}
