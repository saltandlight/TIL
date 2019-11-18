package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Product;

@Repository("pbiz")
public class ProductBiz implements Biz<Integer, Product> {

	@Resource(name="pd")
    Dao<Integer, Product> dao;	
	
	public void setDao(Dao<Integer, Product> dao) {
		this.dao = dao;
	}
	
	@Override
	public void insert(Product v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void update(Product v) throws Exception {
		dao.update(v);		
	}

	@Override
	public void delete(Integer k) throws Exception {
		dao.delete(k);
		//Thread.sleep(5000);
	}

	@Override
	public Product select(Integer k) throws Exception {
		
		return dao.select(k);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		return dao.select();
	}

}
