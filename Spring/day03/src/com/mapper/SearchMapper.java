package com.mapper;

import java.util.ArrayList;

import com.vo.User;


//dao���� mybatis�� ���� ��� ������.
public interface SearchMapper<K, V> {
	public ArrayList<V> search(K obj);
}



