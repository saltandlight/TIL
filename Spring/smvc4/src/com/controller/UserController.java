package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.User;

@Controller
public class UserController {

//	AbstractApplicationContext factory  = 
//			new GenericXmlApplicationContext("myspring.xml");
//	
//	Biz<String, User> userv = (Biz<String, User>) factory.getBean("ubiz");
	@Resource(name="ubiz")
	Biz<String, User> userv;

	@RequestMapping("/useradd.mc")
	public ModelAndView uadd() {
		// 데이터와 화면(Model And View)

		ModelAndView mv = new ModelAndView();
		mv.addObject("navi", Navi.useradd);
		mv.addObject("center", "user/add");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/useraddimpl.mc")
	public ModelAndView useraddimpl(ModelAndView mv, User user) {

		// size를 클래스내에 넣어주는 것=주입해준다.
		try {
			userv.insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/userlist.mc")
	public ModelAndView ulist() {
		ArrayList<User> list = null;
		try {
			list = userv.select();
			for(User u:list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("navi", Navi.userlist);
		mv.addObject("userlist",list);
		mv.addObject("center", "user/list");
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/userdetail.mc")
	public ModelAndView udetail(ModelAndView mv, String id) {
		User user = null;
		System.out.println(id);
		try {
		
			user = userv.select(id);
			System.out.println(user);
			mv.addObject("userdetail", user);
			mv.addObject("center", "user/detail");
			mv.setViewName("main");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/userupdate.mc")
	public ModelAndView uupdate(ModelAndView mv, User user) {
		
		try {
		
		
			mv.addObject("u", user);
			mv.addObject("center", "user/update");
			mv.setViewName("main");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/userdelete.mc")
	public String udel(ModelAndView mv, String id) {

		try {
			userv.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:userlist.mc";
	}

	@RequestMapping("/userupdateimpl.mc")
	public String userupdateimpl(User user) {
		try {
			userv.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:userdetail.mc?id=" + user.getId();
	}

}
