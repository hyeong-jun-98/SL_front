package com.academy.model2app.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.academy.model2app.domain.Notice;
import com.academy.model2app.mybatis.MybatisConfigManager;

public class NoticeDAO {
	
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();  // sqlSession을 주고 쿼리문을 수행시켜주기 때문
	
	public int insert(Notice notice ) {
		int result = 0;
		SqlSession sqlSession = configManager.getSqlSession();
		result = sqlSession.insert("Notice.insert", notice);
		sqlSession.commit();
		configManager.closeSqlSession(sqlSession);
		
		return result;
	}
	
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = configManager.getSqlSession();
		list = sqlSession.selectList("Notice.selectAll");
		configManager.closeSqlSession(sqlSession);
		
		return list;
	}

}
