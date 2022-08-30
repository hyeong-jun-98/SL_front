package com.academy.web0829.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.academy.web0829.domain.Board;
import com.academy.web0829.mybatis.ConfigManager;

public class BoardDAO {
	ConfigManager configManager = ConfigManager.getInstance();

	// 데이터 한 건 넣기
	public int insert(Board board) {
		
		SqlSession sqlSession = configManager.getSqlSession(); // mybatis 쿼리 수행 객체

		int result = 0;

		// 여기서 sql문 작성하지 말고 XML에 작성된 쿼리문을 호출한다
		result = sqlSession.insert("Board.insert", board);
		sqlSession.commit();	// DML만 commit을 해준다
		configManager.closeSqlSession(sqlSession);
		
		return result;
	}
	
	
	// 목록 가져오기
public List selectAll() {
	SqlSession sqlSession = configManager.getSqlSession();
	List list = null;
	list = sqlSession.selectList("Board.selectAll");
	configManager.closeSqlSession(sqlSession);
	return list;
}

	// 한 건 가져오기
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSqlSession();
		Board board = null;
		board = sqlSession.selectOne("Board.select", board_id);
		configManager.closeSqlSession(sqlSession);
		
		
		return board;
		
	}
	
	// 삭제하기 
	
	public int delete(int board_id) {
		SqlSession sqlSession = configManager.getSqlSession();
		int result = 0;
		result = sqlSession.delete("Board.delete", board_id);
		sqlSession.commit();
		configManager.closeSqlSession(sqlSession);
		
		return result;
	}
	
	
	
	// 수정하기
	public int update(Board board) {
		SqlSession sqlSession = configManager.getSqlSession();
		int result = 0;
		result = sqlSession.update("Board.update", board);
		sqlSession.commit(); 	// DML에만 commit()을 해준다.
		configManager.closeSqlSession(sqlSession);
		
		
		return result;
		
	}
	
	
}
