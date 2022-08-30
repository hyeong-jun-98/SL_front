package com.academy.web0829.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// mybatis의 설정 정보는 요청 있을 때마다 xml을 읽을 필요가 없고
// 프로그램이 가동되면 한번만 불러와 사용하면 좋을 거 같다.. (클래스로 뺀다.)

public class ConfigManager {
	private static  ConfigManager instance;
	SqlSessionFactory sqlSessionFactory;

	public ConfigManager() {

		try { 
			// mybatis를 위한 서정 파일인데 서블릿에 넣으면 파일을 읽을 때마다 불러오기 때문에 너무 무거우니까
			// 따로 클래스를 하나 만들어서 설정을 딱 한 번만 하도록 위함이다.
			
			String resource = "com/academy/web0829/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// mybatis를 이용하면, 기존에 jdbc에서 sql 수행 시 사용했던 PrepareStatement를 사용하는게 아니라
			// 대신 SqlSession 이라는 객체를 이용한다. 아래의 SqlSessionFactory는 SqlSession을 관리 및 반환해주는 객체
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	// mybatis
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// sqlSessionFactory로부터 SqlSession을 얻어갈 수 잇도록 메서드를 정의해두자 (얻기)
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	// 얻어간 sqlSession 닫기
	public void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
	public static ConfigManager getInstance() {		// 싱글톤 패턴
		if(instance == null) {
			instance = new ConfigManager();
		} else {
			
		}
		return instance;
	}

}
