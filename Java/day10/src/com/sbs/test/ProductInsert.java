package com.sbs.test;

import com.sbs.component.ProductBiz;
import com.sbs.frame.Biz;
import com.sbs.vo.Product;

public class ProductInsert {

	public static void main(String[] args) {
		Biz<Integer, Product> biz = new ProductBiz();
		Product prd1= new Product(400, "speaker1", 50000);
		try {
			biz.register(prd1);
		}catch(Exception e) {
			System.out.println("Insert Error");
			System.out.println(e.getMessage());
		}

	}

}
