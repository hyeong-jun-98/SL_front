package com.academy.web0829.emp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.academy.web0829.mybatis.ConfigManager;

public class EmpDAO {

	ConfigManager manager = ConfigManager.getInstance();

	
	public List selectAll() {			// EmpMapper의 selectAll 쿼리문을 List 형태로 가져오기 
		
		SqlSession sqlSession = manager.getSqlSession();
		List list = null;
		list = sqlSession.selectList("Emp.selectAll");
		manager.closeSqlSession(sqlSession);

		return list;
	}

}
