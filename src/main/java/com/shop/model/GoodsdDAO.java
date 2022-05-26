package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.common.GoodsVO;
import com.shop.common.JDBCConnection;

public class GoodsdDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	public int addGoods(GoodsVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into goods values((select nvl(max(gno), 0)+1 from goods), ?, ?, ?, ?, ?, ?, ?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGcategory());
			pstmt.setString(2, vo.getGname());
			pstmt.setInt(3, vo.getGprice());
			pstmt.setString(4, vo.getGcolor());
			pstmt.setInt(5, vo.getAmount());
			pstmt.setString(6, vo.getGcontent());
			pstmt.setString(7, vo.getGimage());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
}
