package com.sbs.frame;

import java.util.ArrayList;

public abstract class Dao<K,V> {
	public abstract void insert(V v) 
		throws Exception;
	public abstract void delete(K k)
		throws Exception;
	public abstract void update(V v)
		throws Exception;
	public abstract V select(K k)
			throws Exception;
	public abstract ArrayList<V> select()
			throws Exception;
	//network가 끊어질 수도 있고 db에 문제가 생길 수도 있음.
}
