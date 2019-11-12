package com.sbs.component;

import java.util.ArrayList;

import com.sbs.frame.Biz;
import com.sbs.frame.Dao;
import com.sbs.vo.Product;

public class ProductBiz extends Biz<Integer, Product> {

	Dao<Integer, Product> dao;
	
	public ProductBiz() {
		dao=new ProductDao();
	}

	@Override
	public void register(Product v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.insert(v);
			//insert에서 에러 발생-> 트랜잭션 엔드가 실행 안 됨-> 정상적 종료가 되지 않은 상태
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //결국에 실행되면 얘를 실행한다는 뜻
		}
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		transactionStart();
		try {
			dao.delete(k);
			//insert에서 에러 발생-> 트랜잭션 엔드가 실행 안 됨-> 정상적 종료가 되지 않은 상태
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //결국에 실행되면 얘를 실행한다는 뜻
		}
		
	}

	@Override
	public void modify(Product v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);
			//insert에서 에러 발생-> 트랜잭션 엔드가 실행 안 됨-> 정상적 종료가 되지 않은 상태
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //결국에 실행되면 얘를 실행한다는 뜻
		}
		
	}

	@Override
	public Product get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<Product> get() throws Exception {
		return dao.select();
	}

}
