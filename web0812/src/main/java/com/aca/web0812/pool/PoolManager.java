package com.aca.web0812.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//웹에서의 커넥션 풀로부터 커넥션을 얻기 위한 전담객체 (EE)

public class PoolManager extends ConnectionManager {
	private static PoolManager instance;
	InitialContext context;
	DataSource ds;
	
	private PoolManager() {
		try {
			context = new InitialContext();
			ds =(DataSource) context.lookup("java:comp/env/jdbc/myoracle");		// 검색시작
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static PoolManager getinstance() {
		if(instance == null) {
			instance = new PoolManager();
		}
		return instance;
		
	}

	@Override
	public Connection getConnection() {
		Connection con = null;
		try {
			
			con = ds.getConnection();				// 새로운 접속이 아니라 기존 풀에 있는 커넥션을 빌린것
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

	@Override
	public void freeConnection(Connection con) {		// 반납 (풀로 돌려보냄)
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
