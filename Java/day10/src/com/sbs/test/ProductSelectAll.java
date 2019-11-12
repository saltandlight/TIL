package com.sbs.test;

import java.util.ArrayList;

import com.sbs.component.ProductBiz;
import com.sbs.frame.Biz;
import com.sbs.vo.Product;

public class ProductSelectAll {

	public static void main(String[] args) {
	  
		Biz<Integer, Product> biz = new ProductBiz();
		ArrayList<Product> list =null;
		try {
			list = biz.get();
			for(Product u:list) {
				System.out.println(u);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
