package com.aca.web0812.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

abstract public class ConnectionManager {
	
	
	public abstract Connection getConnection();		// 커넥션 얻어오기
	
	// db 관련 자원해제
	public abstract void freeConnection(Connection con);		// 접속만 닫을 때
	public abstract void freeConnection(Connection con, PreparedStatement pstmt);		// DML
	public abstract void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs);		// Select
	
	
	
	
	
}
