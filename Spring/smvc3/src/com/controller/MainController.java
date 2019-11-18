package com.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vo.User;

@Controller
public class MainController {
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		//데이터와 화면(Model And View)
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	
	@RequestMapping("/login.mc")
	public ModelAndView login() {		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi", Navi.login);
		mv.addObject("center","login/login");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/loginimpl.mc")
	public ModelAndView loginimpl(ModelAndView mv,
			HttpServletRequest request,
			HttpSession session) {
		String id=request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id.equals("qqq") && pwd.equals("111")) {
			User user = new User(id,pwd,"james");
			session.setAttribute("loginuser", user);
			mv.addObject("center","login/loginok");
		}else {
			mv.addObject("center","login/loginfail");
		}
		mv.setViewName("main");
		return mv;
	}	
	@RequestMapping("/logout.mc")
	public ModelAndView logout(ModelAndView mv,
			HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/register.mc")
	public ModelAndView register() {
		//데이터와 화면(Model And View)
//		request.setAttribute("navi", Navi.login);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi", Navi.register);
		mv.addObject("center","register/register");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/aboutus.mc")
	public ModelAndView aboutus() {
		//데이터와 화면(Model And View)
//		request.setAttribute("navi", Navi.login);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi", Navi.aboutus);
		mv.addObject("center","aboutus/aboutus");
		mv.setViewName("main");
		return mv;
	}
}
