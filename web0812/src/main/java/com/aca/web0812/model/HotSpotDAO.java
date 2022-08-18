package com.aca.web0812.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aca.web0812.domain.HotSpot;
//
// 오직 hotspot 테이블에 대한 CRUD를 담당하는 DAO객체
public class HotSpotDAO {
	String url = "jdbc:mysql://localhost:3306/javastudy?useUnicode=true&characterEncoding=utf8";
	String user = "root";
	String pass = "1234";

	public int insert(HotSpot hotspot) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into hotspot (lati, longi, icon, content) values (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1, hotspot.getLati());
			pstmt.setFloat(2, hotspot.getLongi());
			pstmt.setString(3, hotspot.getIcon());
			pstmt.setString(4, hotspot.getContent());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

}
