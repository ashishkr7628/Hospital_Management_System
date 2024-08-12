package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.DoctorDao;
import com.org.dao.SpecialistDao;
import com.org.dao.UserDao;
import com.org.dto.Doctor;
import com.org.dto.Specialist;
import com.org.dto.User;

@Controller
public class DoctorController {
	
	
	@Autowired
	 private SpecialistDao specialistDao;
	
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	
	private UserDao userDao;
	
	
	@PostMapping("/doctor_login")
	public ModelAndView user_login(@RequestParam("email") String email,@RequestParam("password")String password,HttpSession session) {
		
	
		List<Doctor> list = doctorDao.verifyDoctorByEmailAndPassword(email, password);

		
		if(list.isEmpty()) {
			ModelAndView mav = new ModelAndView("doctor_login.jsp");
			mav.addObject("failed","Invalid Email or Password");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("doctor/doctor_homepage.jsp");
		
		session.setAttribute("doctorId",list.get(0).getId());
		return mav;
		
		
		
	}

@GetMapping("/temp_Doctor")
	
	public ModelAndView tempDoctor() {
		
		ModelAndView mav = new ModelAndView("doctor/addAndUpdateDoctor.jsp");
		
		Doctor d = new Doctor();
		mav.addObject("doctor",d);
		List<Specialist> listOfSpecialist  = specialistDao.fetchAll();
		mav.addObject("list", listOfSpecialist);
		return mav;

		
	}
	
	
	
	
	@PostMapping("/registerAndUpdateDoctor")
	
	public ModelAndView registerAndUpdateDoctor(@ModelAttribute Doctor doctor) {
		doctorDao.insertAndUpdateDoctor(doctor);
		
		ModelAndView mav= new ModelAndView("admin/admin_homepage.jsp");
		mav.addObject("success","Done!");
		
		return mav;
	}
	
	@GetMapping("fetchAllDoctor")
	
	public ModelAndView fetchAllDoctor() {
		List<Doctor> listOfDoctors = doctorDao.fetchAll();
		ModelAndView mav = new ModelAndView("doctor/fetchAllDoctor.jsp");
		mav.addObject("list",listOfDoctors);
		return mav;
	}
	
	@GetMapping("updateDoctor")
	
	public ModelAndView UpdateDoctor(@RequestParam("id") int id) {
		
	Doctor doctor = doctorDao.fetchDoctorById(id);
	

	 
	ModelAndView mav = new ModelAndView("doctor/addAndUpdateDoctor.jsp");
	
	
	mav.addObject("doctor",doctor);
	return mav;
			
				}
	
	@GetMapping("deleteDoctor")
	
	public ModelAndView deleteDoctor(@RequestParam("id") int id) {
		
		ModelAndView mav = new ModelAndView("admin/admin_homepage.jsp");
		
		doctorDao.deleteDoctorById(id);
		
		return mav;
	}
	
	

	

	
	
	

	
}
