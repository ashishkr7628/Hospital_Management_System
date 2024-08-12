package com.org.controller;

import java.util.List;

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
	public ModelAndView adminLogin(@RequestParam("email")String email, @RequestParam("password")String password) {
		List<Admin> list = adminDao.verifyAdminByEmailAndPassword(email, password);
		
		if(list.isEmpty()) {
			
			ModelAndView mav = new ModelAndView("admin_login.jsp");
			mav.addObject("failed","Invalid Email or Password");
			return mav;
		
		
		}
		
		ModelAndView mav = new ModelAndView("admin/admin_homepage.jsp");
		return mav;
		
		
		
		
	}
	
	
	@RequestMapping("/viewdoctor")
	
	public ModelAndView viewDoctor() {
		
		ModelAndView mav = new ModelAndView("admin/addDoctor_jstlform.jsp");
		
		Doctor doctor= new Doctor();
		mav.addObject("doctor",doctor);
		
		
		return mav;
	}
	
	@PostMapping("hospital_management_system/addAndInsertDoctor")
	
	public ModelAndView addAndInsertDoctor(@ModelAttribute Doctor doctor) {
		
		ModelAndView mav = new ModelAndView("../admin/admin_homepage.jsp");
		
		doctorDao.insertAndUpdateDoctor(doctor);
		mav.addObject("success", "Registration Successful");
	
		mav.addObject("doctor",doctor);
		
		
		return mav;
	}
	

	@PostMapping("/add_specialist")
	public ModelAndView admin_register(@ModelAttribute Specialist specialist) {
		
		
		
		ModelAndView mav = new ModelAndView("/doctor/add_specialist.jsp");
		specialistDao.insertAndUpdateSpecialist(specialist);
	
		
;
		
		mav.addObject("success","Registered Successfully");
		return mav;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	 
	  
	  
	  
}