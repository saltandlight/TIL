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
			//insert���� ���� �߻�-> Ʈ����� ���尡 ���� �� ��-> ������ ���ᰡ ���� ���� ����
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //�ᱹ�� ����Ǹ� �긦 �����Ѵٴ� ��
		}
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		transactionStart();
		try {
			dao.delete(k);
			//insert���� ���� �߻�-> Ʈ����� ���尡 ���� �� ��-> ������ ���ᰡ ���� ���� ����
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //�ᱹ�� ����Ǹ� �긦 �����Ѵٴ� ��
		}
		
	}

	@Override
	public void modify(Product v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);
			//insert���� ���� �߻�-> Ʈ����� ���尡 ���� �� ��-> ������ ���ᰡ ���� ���� ����
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd(); //�ᱹ�� ����Ǹ� �긦 �����Ѵٴ� ��
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
