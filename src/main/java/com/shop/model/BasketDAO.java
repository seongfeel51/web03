package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.BasketVO;
import com.shop.common.JDBCConnection;

public class BasketDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	public ArrayList<BasketVO> getAdminBasketList() {
		ArrayList<BasketVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from basket";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<BasketVO>();
			while(rs.next()) {
				BasketVO vo = new BasketVO();
				vo.setBno(rs.getInt("bno"));
				vo.setUserid(rs.getString("userid"));
				vo.setGno(rs.getInt("gno"));
				vo.setGcolor(rs.getString("gcolor"));
				vo.setAmount(rs.getInt("amount"));
				vo.setGsize(rs.getString("gsize"));
				vo.setBdate(rs.getString("bdate"));
				list.add(vo);
			}
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
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public ArrayList<BasketVO> getBasketList(String userid) {
		ArrayList<BasketVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from basket where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			list = new ArrayList<BasketVO>();
			while(rs.next()) {
				BasketVO vo = new BasketVO();
				vo.setBno(rs.getInt("bno"));
				vo.setUserid(rs.getString("userid"));
				vo.setGno(rs.getInt("gno"));
				vo.setGcolor(rs.getString("gcolor"));
				vo.setAmount(rs.getInt("amount"));
				vo.setGsize(rs.getString("gsize"));
				vo.setBdate(rs.getString("bdate"));
				list.add(vo);
			}
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
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public BasketVO getBasket(int bno) {
		BasketVO basket = new BasketVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from basket where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				basket.setBno(rs.getInt("bno"));
				basket.setUserid(rs.getString("userid"));
				basket.setGno(rs.getInt("gno"));
				basket.setGcolor(rs.getString("gcolor"));
				basket.setAmount(rs.getInt("amount"));
				basket.setGsize(rs.getString("gsize"));
				basket.setBdate(rs.getString("bdate"));
			}
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
		return basket;
	}
	

	public int addBasket(BasketVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into basket values((select nvl(max(bno), 0)+1 from basket), ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setInt(2, vo.getGno());
			pstmt.setString(3, vo.getGcolor());
			pstmt.setInt(4, vo.getAmount());
			pstmt.setString(5, vo.getGsize());
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
	
	public int editBasket(BasketVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "update basket set gcolor=?, amount=?, gsize=?, bdate=sysdate where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGcolor());
			pstmt.setInt(2, vo.getAmount());
			pstmt.setString(3, vo.getGsize());
			pstmt.setInt(4, vo.getBno());
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
	
	public int delBasket(int bno) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from basket where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
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
