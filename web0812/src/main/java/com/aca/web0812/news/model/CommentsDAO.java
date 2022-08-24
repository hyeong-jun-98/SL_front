package com.aca.web0812.news.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aca.web0812.domain.Comments;
import com.aca.web0812.pool.ConnectionManager;
import com.aca.web0812.pool.PoolManager;

/*
 * DAO 는 테이블마다 1:1 대응하게 생성해야 한다.. 따라서 오라클에 table이 만일 100개라면, DAO도 100개, DTO도 100개이다
 * */

public class CommentsDAO {
	ConnectionManager manager = PoolManager.getinstance(); // 싱글톤으로 얻어와라, 메모리에 올라올 때 등장

	public int insert(Comments comments) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		con = manager.getConnection();
		String sql = "insert into comments (comments_id, detail, author, news_id) values(seq_comments.nextval,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, comments.getDetail());
			pstmt.setString(2, comments.getAuthor());
			pstmt.setInt(3, comments.getNews().getNews_id());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt);

		}

		return result;
	}

	// 모든 레코드 가져오기
	public List selectAll() {
		
		List list = new ArrayList<>();
		

		
		return list;
	}

}
