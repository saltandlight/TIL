package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.User;

public class UserDao extends Dao<String, User>{

	@Override
	public void insert(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertUser);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getPwd());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
		
	}

	@Override
	public void delete(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertDelete);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
		
		
	}

	@Override
	public void update(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertUpdate);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getPwd());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
		
	}

	@Override
	public User select(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		try {
			pstmt = con.prepareStatement(Sql.insertSelect);
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();
			rset.next();
			String uid=rset.getString("ID");
			String upwd=rset.getString("PWD");
			String uname = rset.getString("NAME");
			User user = new User(uid, upwd, uname);
			return user;
		} catch (Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		ArrayList<User> list = new ArrayList<>();
		try {
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
		}finally {
			close(pstmt);
		}return list;
	}
   
	
 }

