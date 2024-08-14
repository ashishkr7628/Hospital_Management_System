package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.AppointmentDao;
import com.org.dao.UserDao;
import com.org.dto.Appointment;
import com.org.dto.User;

@Controller
public class UserController  {
	
	
@Autowired
	 private UserDao userDao;

@Autowired
private AppointmentDao appointmentDao;
	
@PostMapping("/user_register")
public ModelAndView user_register(@ModelAttribute User user) {
	
	ModelAndView mav = new ModelAndView("user_register.jsp");
	
	userDao.insertAndUpdateUser(user);
	
	mav.addObject("success","Registered Successfully");
	System.out.println(user);
	
	return mav;
}

@PostMapping("/user_login")
public ModelAndView user_login(@RequestParam("email") String email,@RequestParam("password")String password,HttpSession session) {
	
	
	List<User> list = userDao.verifyUserByEmailAndPassword(email, password);
	
	if(list.isEmpty()) {
		ModelAndView mav = new ModelAndView("user_login.jsp");
		mav.addObject("failed","Invalid Email or Password");
		return mav;
	}
	
	ModelAndView mav = new ModelAndView("user/user_homepage.jsp");
	
	session.setAttribute("userId",list.get(0).getId());
	session.setAttribute("userName",list.get(0).getName());
	int userId =(int)session.getAttribute("userId");
	User user = userDao.fetchUserById(userId);
	mav.addObject("user", user);

	return mav;
	
	
	
}




@GetMapping("/view_user")
public ModelAndView user_view(HttpSession session) {
	
	ModelAndView mav = new ModelAndView("user/user_homepage.jsp");
	int userId =(int)session.getAttribute("userId");
	User user = userDao.fetchUserById(userId);
	mav.addObject("user", user);
	return mav;
}

@RequestMapping("/user_logout")

public ModelAndView adminLogout(HttpSession session) {
	
	session.removeAttribute("userName");
	ModelAndView mav = new ModelAndView("user_login.jsp");
	
	
	return mav;
}










	
	
}


	
	
	
	

