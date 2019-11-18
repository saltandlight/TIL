package com.mapper;

import java.util.ArrayList;

import com.vo.User;


//dao에서 mybatis로 들어가는 통로 역할함.
public interface UserMapper {
	public void insert(User obj);
	public void delete(String obj);
	public void update(User obj);
	public User select(String obj);
	public ArrayList<User> selectall();
}