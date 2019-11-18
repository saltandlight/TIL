package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/useradd.mc")
	public ModelAndView uadd() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/add");
		return mv;
	}
	
	@RequestMapping("/userlist.mc")
	public ModelAndView ulist() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/list");
		return mv;
	}
	
	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/add");
		return mv;
	}
	
	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/list");
		return mv;
	}
	
	
}
