package com.product;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.frame.Dao;

@Repository("pd")
public class ProductDao implements Dao<Integer, Product> {
	
	@Override
	public void insert(Product v) throws Exception {
		System.out.println(v.getId()+"ProductDao Inserted...");
	}

	@Override
	public void update(Product v) throws Exception {
		System.out.println(v.getId()+"ProductDao Updated...");		
	}

	@Override
	public void delete(Integer k) throws Exception {
		System.out.println(k+" ProductDao Deleted...");		
	}

	@Override
	public Product select(Integer k) throws Exception {
		return new Product(1, "jean", 38000);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList();
		list.add(new Product(2, "blackjean", 40000));
		list.add(new Product(3, "T-shirt", 20000));
		list.add(new Product(4, "blackshoes", 50000));
		return list;
	}

}
