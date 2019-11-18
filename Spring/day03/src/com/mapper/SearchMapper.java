package com.mapper;

import java.util.ArrayList;

import com.vo.User;


//dao에서 mybatis로 들어가는 통로 역할함.
public interface SearchMapper<K, V> {
	public ArrayList<V> search(K obj);
}



