package com.sbs.component;

import java.util.ArrayList;

import com.sbs.frame.Dao;
import com.sbs.vo.Product;

public class ProductDao extends Dao<Integer, Product> {

	@Override
	public void insert(Product v) throws Exception {
		if(v.getId()==200) {
			throw new Exception("E0001");
		}
		System.out.println(v+" Inserted.");
		
	}

	@Override
	public void delete(Integer k) throws Exception {
		if(k==200) {
			throw new Exception("E0002");
		}
		System.out.println(k+" Deleted.");
		
	}

	@Override
	public void update(Product v) throws Exception {
		if(v.getId()==200) {
			throw new Exception("E0003");
		}
		System.out.println(v+" Updated.");
		
	}

	@Override
	public Product select(Integer k) throws Exception {
		Product prd = new Product(k,"T-shirt", 18000);
		return prd;
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product(100, "flower_skirt", 20000));
		list.add(new Product(101, "red One-piece", 38000));
		list.add(new Product(102, "blue jacket", 40000));
		list.add(new Product(103, "red T-shirt", 20000));
		list.add(new Product(104, "yellow T-shirt", 15000));
		return list;
	}

}
