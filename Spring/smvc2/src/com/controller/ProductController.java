package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		//데이터와 화면(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi",Navi.productadd);
		mv.addObject("center","product/add");
		mv.setViewName("main2");
		return mv;
	}
	
	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		//데이터와 화면(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi",Navi.productlist);
		mv.addObject("center","product/list");
		mv.setViewName("main2");
		return mv;
	}
	
	
}
