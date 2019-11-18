package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	
	
	@RequestMapping("/useradd.mc")
	public ModelAndView uadd() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi",Navi.useradd);
		mv.addObject("center","user/add");
		mv.setViewName("main2");
		return mv;
	}
	
	@RequestMapping("/userlist.mc")
	public ModelAndView ulist() {
		//�����Ϳ� ȭ��(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi",Navi.userlist);
		mv.addObject("center","user/list");
		mv.setViewName("main2");
		return mv;
	}
	
	
}
