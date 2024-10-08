package com.org.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
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
import com.org.dao.SendingMail;
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
//
@PostMapping("update_appointment")
public ModelAndView updateAppointment(HttpSession session,@ModelAttribute Appointment appointment, @RequestParam int doctorId, @RequestParam int userId) {
	ModelAndView mav = new ModelAndView("user/viewAppointmentUser.jsp");
	
	
	
	int apId = (int) session.getAttribute("appointId");
	
	appointmentDao.UpdateAppointment(appointment,apId);
	

	Appointment appoint = appointmentDao.fetchAppointmentById(apId);
	Doctor doctor = doctorDao.fetchDoctorById(doctorId);
	System.out.println(doctor);
	
	User user = userDao.fetchUserById(userId);
	System.out.println(user);
	
	List<Appointment> doctorList = doctor.getAppointment();
	Appointment list1 = null;
	for(Appointment list: doctorList) {
		
		if(list.getId()==apId) {
			list1=list;
		}
		
	}
	doctorList.remove(list1);
	
	if(doctorList==null) {
		
		 doctorList = new ArrayList<Appointment>();
		doctorList.add(appoint);
	}
	
	else {
		doctorList.add(appoint);
	}
	

	doctor.setAppointment(doctorList);
	System.out.println(doctor);
	doctorDao.insertAndUpdateDoctor(doctor);

	List<Appointment> userList = user.getAppointment();
	Appointment list2= null;
	for(Appointment list: userList) {
		
		if(list.getId()==apId) {
			list2=list;
		}
		
	}
userList.remove(list2);
userList.add(appoint);
	user.setAppointment(userList);
	
	userDao.insertAndUpdateUser(user);
	System.out.println(user);
	
	appoint.setUser(user);
	appoint.setDoctor(doctor);
	appointmentDao.insertAndUpdateAppointment(appoint);
	
	
	
	
	
	
	
	return mav;
}


@GetMapping("/deleteAppoint")



public ModelAndView deleteAppointment(@RequestParam int id) {
	
	ModelAndView  mav = new ModelAndView("user/viewAppointmentUser.jsp");
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

	appointmentDao.insertAndUpdateAppointment(appoint);
	



	
appointmentDao.deleteAppointmentById(id);
	
	
	return mav;
	
	
}


@GetMapping("userForgot")

public ModelAndView userForgot( ) {
	
	ModelAndView mav = new ModelAndView("user/userForgot.jsp");
	
	return mav;
	
	
	

	


	
}


@PostMapping("userSendOtp")

public ModelAndView sendOtp(@RequestParam String email,HttpSession session) throws MessagingException {
	
	Random random =  new Random();
	int r= 1000 + random.nextInt(9000);
	
	String otp = ""+r;
	
	SendingMail mail = new SendingMail();
	mail.mail(otp, email);
	
	
	
	ModelAndView mav = new ModelAndView("user/forgotPage.jsp");
	
	session.setAttribute("otp",otp);
	session.setAttribute("userEmail",email);
	
	

	
	return mav;
	
	
		
	
	
	
}


@PostMapping("userReset")

public ModelAndView sendOtp(@RequestParam String password, @RequestParam String userOtp,HttpSession session)  {
String userEmail= (String) session.getAttribute("userEmail");
String Otp= (String) session.getAttribute("otp");

ModelAndView mav = new ModelAndView("index.jsp");

if(userOtp.equals(Otp)) {
	
	User user = userDao.fetchByEmail(userEmail);
	
	user.setPassword(password);
	
	userDao.insertAndUpdateUser(user);
	
	mav.addObject("msg","password successfully changed");
	
	
}



	
	return mav;
	
	
		
	
	
	
}




}
