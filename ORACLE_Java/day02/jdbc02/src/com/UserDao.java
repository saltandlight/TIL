package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.User;

public class UserDao extends Dao<String, User> {
//constructor  없으면 상위 클래스의 constructor 호출됨
	@Override
	public void insert(User v) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.insertUser);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally { //반드시 실행하는 라인
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void delete(String k) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.insertDelete);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally { //반드시 실행하는 라인
			close(pstmt);
			close(con);
		}
		
	}

	@Override
	public void update(User v) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.insertUpdate);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally { //반드시 실행하는 라인
			close(pstmt);
			close(con);
		}
		
	}

	@Override
	public User select(String k) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rset=null;
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.insertSelect);
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
			rset.next();
			String uid=rset.getString("ID");
			String upwd=rset.getString("PWD");
			String uname = rset.getString("NAME");
			User user = new User(uid, upwd, uname);
			return user;
		} catch (Exception e) {
			throw e;
		} finally { //반드시 실행하는 라인
			close(pstmt);
			close(con);
		}
		
	}
	
	

	@Override
	public ArrayList<User> select() throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rset=null;
		ArrayList<User> list = new ArrayList<>();
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.insertSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String uid=rset.getString("ID");
				String upwd=rset.getString("PWD");
				String uname = rset.getString("NAME");
//				System.out.println(uid+" "+upwd);
				list.add(new User(uid, upwd, uname));
			}
			
		} catch (Exception e) {
			throw e;
		} finally { //반드시 실행하는 라인
			close(pstmt);
			close(con);
		}return list;
	}

}
