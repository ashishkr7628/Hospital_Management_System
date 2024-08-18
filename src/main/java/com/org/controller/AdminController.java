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

import com.org.dao.AdminDao;
import com.org.dao.DoctorDao;
import com.org.dao.SpecialistDao;
import com.org.dto.Admin;
import com.org.dto.Doctor;
import com.org.dto.Specialist;
@Controller
public class AdminController {
	
	@Autowired
	
	private AdminDao adminDao;
	
	@Autowired
	
	private DoctorDao doctorDao;
	
	@Autowired
	private SpecialistDao specialistDao;
	
	@PostMapping("/admin_register")
	public ModelAndView admin_register(@ModelAttribute Admin admin) {
		
		ModelAndView mav = new ModelAndView("admin_register.jsp");
		adminDao.insertAndUpdateAdmin(admin);
		mav.addObject("success","Registered Successfully");
		return mav;
		
	}
	
	
	@PostMapping("/admin_login")
	public ModelAndView adminLogin(HttpSession session,@RequestParam("email")String email, @RequestParam("password")String password) {
		List<Admin> list = adminDao.verifyAdminByEmailAndPassword(email, password);
		
		if(list.isEmpty()) {
			
			ModelAndView mav = new ModelAndView("admin_login.jsp");
			mav.addObject("failed","Invalid Email or Password");
			return mav;
		
		
		}
		
		ModelAndView mav = new ModelAndView("admin/admin_homepage.jsp");
		
		String name = list.get(0).getName();
		
		session.setAttribute("name", name);
		
		
		return mav;
		
		
		
		
	}
	
	
	
	
	

	@PostMapping("/add_specialist")
	public ModelAndView admin_register(@ModelAttribute Specialist specialist,HttpSession session) {
		ModelAndView mav;
		
		if(session.getAttribute("name")!=null) {
		
		 mav = new ModelAndView("/doctor/add_specialist.jsp");
		specialistDao.insertAndUpdateSpecialist(specialist);
	
		
;
		
		mav.addObject("success","Registered Successfully");
		
		}
		else {
			mav=new ModelAndView("admin_login.jsp");
		}
		return mav;
		
	}
	
	
	
	@RequestMapping("/admin_logout")
	
	public ModelAndView adminLogout(HttpSession session) {
		
		session.removeAttribute("name");
		ModelAndView mav = new ModelAndView("admin_login.jsp");
		
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	 
	  
	  
	  
}