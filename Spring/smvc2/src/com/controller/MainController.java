package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		//데이터와 화면(Model And View)
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("main2");
		return mv;
	}
	
	
	@RequestMapping("/login.mc")
	public ModelAndView login() {
		//데이터와 화면(Model And View)
//		request.setAttribute("navi", Navi.login);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi", Navi.login);
		mv.addObject("center","login/login");
		mv.setViewName("main2");
		return mv;
	}
	
	@RequestMapping("/register.mc")
	public ModelAndView register() {
		//데이터와 화면(Model And View)
//		request.setAttribute("navi", Navi.login);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi", Navi.register);
		mv.addObject("center","register/register");
		mv.setViewName("main2");
		return mv;
	}
	
	@RequestMapping("/aboutus.mc")
	public ModelAndView aboutus() {
		//데이터와 화면(Model And View)
//		request.setAttribute("navi", Navi.login);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi", Navi.aboutus);
		mv.addObject("center","aboutus/aboutus");
		mv.setViewName("main2");
		return mv;
	}
}
