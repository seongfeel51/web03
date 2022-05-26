package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import com.shop.common.JDBCConnection;
import com.shop.common.MemberVO;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	public int addMember(MemberVO vo) { //회원가입
<<<<<<< HEAD
		String pw = Base64.getEncoder().encodeToString(vo.getUserpw().getBytes());
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, sysdate, ?, 100, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, pw);
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getAddr1());
			pstmt.setString(6, vo.getAddr2());
			pstmt.setString(7, vo.getPostcode());
			pstmt.setString(8, vo.getBirth());
=======
		String pw = Base64.getEncoder().encodeToString(vo.getPw().getBytes());
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into member values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, pw);
			pstmt.setString(3, vo.getM_name());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
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
	
	public int editMember(MemberVO vo) {  //회원정보수정
<<<<<<< HEAD
		String pw = Base64.getEncoder().encodeToString(vo.getUserpw().getBytes());
		try {
			conn = JDBCConnection.getConnection();
			sql = "update member set userpw=?, email=?, tel=?, addr1=?, addr2=?, postcode=?, birth=? where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getAddr1());
			pstmt.setString(5, vo.getAddr2());
			pstmt.setString(6, vo.getPostcode());
			pstmt.setString(7, vo.getBirth());
			pstmt.setString(8, vo.getUserid());
=======
		String pw = Base64.getEncoder().encodeToString(vo.getPw().getBytes());
		try {
			conn = JDBCConnection.getConnection();
			sql = "update member set pw=?, email=?, phone=? where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone());
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
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
	
	public int delMember(String uid) { //회원탈퇴
		try {
			conn = JDBCConnection.getConnection();
<<<<<<< HEAD
			sql = "delete from member where userid=?)";
=======
			sql = "delete from member where id=?)";
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
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
	
	public int login(MemberVO vo) {  //로그인
		byte[] pwc; 
		try {
			conn = JDBCConnection.getConnection();
<<<<<<< HEAD
			sql = "select * from member where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pwc = Base64.getDecoder().decode(rs.getString("userpw"));
				String pw = new String(pwc);
				if(vo.getUserpw().equals(pw)) { //복호화하여 비교
					cnt = 1;
					rs.close();
					pstmt.close();
					sql = "update member set visited=visited+1 where userid=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, vo.getUserid());
					pstmt.executeUpdate();
=======
			sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pwc = Base64.getDecoder().decode(rs.getString("pw"));
				String pw = new String(pwc);
				if(vo.getPw().equals(pw)) { //복호화하여 비교
					cnt = 1;
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
				} else {
					cnt = 0;
				}
			} else {
				cnt = 0;
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
<<<<<<< HEAD
			JDBCConnection.close(pstmt, conn);
=======
			JDBCConnection.close(rs, pstmt, conn);
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
		}
		return cnt;
	}
	
	public int idCheck(String uid) { //아이디 중복체크
		try {
			conn = JDBCConnection.getConnection();
<<<<<<< HEAD
			sql = "select * from member where userid=?";
=======
			sql = "select * from member where id=?";
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = 1;
			} else {
				cnt = 0;
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
		return cnt;
	}
	
	public ArrayList<MemberVO> getMemberList() {  //관리자 회원목록 보기
		ArrayList<MemberVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
<<<<<<< HEAD
			sql = "select userid, userpw, email, tel, addr1, addr2, postcode, to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as cdate, birth, userpoint, visited from member";
=======
			sql = "select * from member";
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<MemberVO>();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
<<<<<<< HEAD
				vo.setUserid(rs.getString("userid"));
				vo.setUserpw(rs.getString("userpw"));
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setAddr1(rs.getString("addr1"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setPostcode(rs.getString("postcode"));
				vo.setRegdate(rs.getString("cdate"));
				vo.setBirth(rs.getString("birth"));
				vo.setUserpoint(rs.getInt("userpoint"));
				vo.setVisited(rs.getInt("visited"));
=======
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setM_name(rs.getString("m_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
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
	
	public MemberVO getMember(String uid) { //관리자 회원정보 상세보기
		byte[] pwc;
		MemberVO member = new MemberVO();
		try {
			conn = JDBCConnection.getConnection();
<<<<<<< HEAD
			sql = "select userid, userpw, email, tel, addr1, addr2, postcode, to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as cdate, to_char(birth, 'yyyy-MM-dd HH24:mi:ss') as birthday, userpoint, visited from member where userid=?";
=======
			sql = "select * from member where id=?";
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
<<<<<<< HEAD
				member.setUserid(rs.getString("userid"));
				pwc = Base64.getDecoder().decode(rs.getString("userpw"));
				String pw = new String(pwc);
				member.setUserpw(pw);
				member.setEmail(rs.getString("email"));
				member.setTel(rs.getString("tel"));
				member.setAddr1(rs.getString("addr1"));
				member.setAddr2(rs.getString("addr2"));
				member.setPostcode(rs.getString("postcode"));
				member.setRegdate(rs.getString("cdate"));
				member.setBirth(rs.getString("birthday"));
				member.setUserpoint(rs.getInt("userpoint"));
				member.setVisited(rs.getInt("visited"));
=======
				member.setId(rs.getString("id"));
				pwc = Base64.getDecoder().decode(rs.getString("pw"));
				String pw = new String(pwc);
				member.setPw(pw);
				member.setM_name("m_name");
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
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
		return member;
	}
<<<<<<< HEAD
	
	public ArrayList<MemberVO> JSONMemberList() {  //관리자 회원목록을 JSON으로 내보내기
		ArrayList<MemberVO> list = null;
		byte[] pwc;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select userid, userpw, email, tel, addr1, addr2, postcode, to_char(regdate, 'yyyy-MM-dd HH24:mi:ss') as cdate, birth, userpoint, visited from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<MemberVO>();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setUserid(rs.getString("userid"));
				pwc = Base64.getDecoder().decode(rs.getString("userpw"));
				String pw = new String(pwc);
				vo.setUserpw(pw);
				vo.setEmail(rs.getString("email"));
				vo.setTel(rs.getString("tel"));
				vo.setAddr1(rs.getString("addr1"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setPostcode(rs.getString("postcode"));
				vo.setRegdate(rs.getString("cdate"));
				vo.setBirth(rs.getString("birth"));
				vo.setUserpoint(rs.getInt("userpoint"));
				vo.setVisited(rs.getInt("visited"));
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
=======
>>>>>>> b7d450496dd3d584f766ae0700f436e2f800ada8
}