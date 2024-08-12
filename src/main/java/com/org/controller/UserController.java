package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	return mav;
	
	
	
}


@RequestMapping("/insertAndUpdate")
public ModelAndView insertAndUpdateAppointmentData() {
	
	ModelAndView mav = new ModelAndView("user/addAppointment_jstlform.jsp");
	
	Appointment appointment= new Appointment();
	mav.addObject("appointment",appointment);

	
	
	
	

	
	return mav;
	
	
	
	
	
}

@PostMapping("/insertAndUpdate1")
public ModelAndView insertAndUpdateAppointmentData1(@ModelAttribute Appointment appointment) {
	
	ModelAndView mav = new ModelAndView("user/addAppointment_jstlform.jsp");

	appointmentDao.insertAndUpdateAppointment(appointment);
	
	
	
	
	mav.addObject("success","Registration Successful");
	
	return mav;
	
	
	
	
	
}





	
	
}


	
	
	
	

