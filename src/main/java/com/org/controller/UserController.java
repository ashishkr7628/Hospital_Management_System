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
import com.org.dao.DoctorDao;
import com.org.dao.UserDao;
import com.org.dto.Appointment;
import com.org.dto.Doctor;
import com.org.dto.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private AppointmentDao appointmentDao;
	
	
	
	@Autowired
	private DoctorDao doctorDao;

	@PostMapping("/user_register")
	public ModelAndView user_register(@ModelAttribute User user) {

		ModelAndView mav = new ModelAndView("user_register.jsp");

		userDao.insertAndUpdateUser(user);

		mav.addObject("success", "Registered Successfully");
		System.out.println(user);

		return mav;
	}

	@PostMapping("/user_login")
	public ModelAndView user_login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		List<User> list = userDao.verifyUserByEmailAndPassword(email, password);

		if (list.isEmpty()) {
			ModelAndView mav = new ModelAndView("user_login.jsp");
			mav.addObject("failed", "Invalid Email or Password");
			return mav;
		}

		ModelAndView mav = new ModelAndView("user/user_homepage.jsp");

		session.setAttribute("userId", list.get(0).getId());
		session.setAttribute("userName", list.get(0).getName());
		int userId = (int) session.getAttribute("userId");
		User user = userDao.fetchUserById(userId);
		mav.addObject("user", user);

		return mav;

	}

	@GetMapping("/view_user")
	public ModelAndView user_view(HttpSession session) {

		ModelAndView mav = new ModelAndView("user/user_homepage.jsp");
		int userId = (int) session.getAttribute("userId");
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

	@RequestMapping("updateAppoint")

	public ModelAndView updateAppointment(HttpSession session, @RequestParam int id) {

		ModelAndView mav = new ModelAndView("user/update_Appointment.jsp");
		
		session.setAttribute("appointId", id);

		
		
		
		

		int userId = (int) session.getAttribute("userId");
		User user = userDao.fetchUserById(userId);
		List<Appointment> appointment = user.getAppointment();

		Appointment appoint = getAppointment(appointment, id);

		session.setAttribute("appointId", id);
		mav.addObject("appoint", appoint);
		System.out.println(appoint);
		

		return mav;

	}

Appointment getAppointment(List<Appointment> appointment,int id) {
	
	Appointment ap= new Appointment();
for( Appointment appoint: appointment) {
	
	if(appoint.getId()==id) {
		
		
		ap=appoint;
	}
		
	
	
}
return ap;

	
	
	
}

@PostMapping("update_appointment")
public ModelAndView updateAppointment(HttpSession session,@ModelAttribute Appointment appointment, @RequestParam int doctorId, @RequestParam int userId) {
	ModelAndView mav = new ModelAndView("user/viewAppointmentUser.jsp");
	DoctorDao dao =new DoctorDao(); 
	Doctor doctor = dao.fetchDoctorById(doctorId);
	System.out.println("hiii");
	System.out.println(appointment.toString());
	
	int apId = (int) session.getAttribute("appointId");
	
	appointmentDao.UpdateAppointment(appointment,doctor,apId);
	
	
	
	return mav;
}


@GetMapping("/deleteAppoint")



public ModelAndView deleteAppointment(@RequestParam int id) {
	
	ModelAndView  mav = new ModelAndView("view_user");
	Appointment appoint = appointmentDao.fetchAppointmentById(id);
	Doctor doctor = appoint.getDoctor();
	User user = appoint.getUser();
	
	List<Appointment> doctorList = doctor.getAppointment();
	Appointment list1 = null;
	for(Appointment list: doctorList) {
		
		if(list.getId()==id) {
			list1=list;
		}
		
	}
	doctorList.remove(list1);

	doctor.setAppointment(doctorList);
	doctorDao.insertAndUpdateDoctor(doctor);

	List<Appointment> userList = user.getAppointment();
	Appointment list2= null;
	for(Appointment list: userList) {
		
		if(list.getId()==id) {
			list2=list;
		}
		
	}
userList.remove(list2);
	user.setAppointment(userList);
	userDao.insertAndUpdateUser(user);

	
	appoint.setDoctor(null);
	appoint.setUser(null);
	System.out.println(appoint);
	appointmentDao.insertAndUpdateAppointment(appoint);
	



	
appointmentDao.deleteAppointmentById(id);
	
	
	return mav;
	
	
}



}
