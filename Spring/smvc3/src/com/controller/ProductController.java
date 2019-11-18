package com.controller;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Product;

@Controller
public class ProductController {
	
	@Resource(name="pbiz")
	Biz<Integer,Product> biz;
	
	
	
	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi",Navi.productadd);
		mv.addObject("center","product/add");
		mv.setViewName("main");
		return mv;
	}
	
	
	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		ArrayList<Product> list= null;
		
		try {
			list=biz.select();
			for(Product prd:list) {
				System.out.println(prd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("plist", list);
		mv.addObject("navi",Navi.productlist);
		mv.addObject("center","product/list");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/productaddimpl.mc")
	public ModelAndView paddimpl(ModelAndView mv,
			Product product) {
	
		String imgname=product.getMf().getOriginalFilename();
		product.setImgname(imgname);
		
		try {
			biz.insert(product);
			Util.saveFile(product.getMf());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(product);
		mv.setViewName("main");
		return mv;
	}
}
