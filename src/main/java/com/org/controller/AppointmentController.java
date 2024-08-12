package com.org.controller;

import java.util.ArrayList;
import java.util.List;

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
public class AppointmentController {

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private UserDao userDao;
	
	
	
@PostMapping("/add_appointment")

public ModelAndView addAppointment(@ModelAttribute Appointment appointment, @RequestParam int doctorId, @RequestParam int userId ) {
	ModelAndView mav = new ModelAndView("user/user_homepage.jsp");
	
	Doctor doctor= doctorDao.fetchDoctorById(userId);
	
	appointment.setDoctor(doctor);
	List<Appointment> listOfAppointment = doctor.getAppointment();
	listOfAppointment.add(appointment);
	doctor.setAppointment(listOfAppointment);
	
	User user = userDao.fetchUserById(userId);
	List<Appointment> list = user.getAppointment();
	
	if(list==null) {
		
		 list = new ArrayList<Appointment>();
		list.add(appointment);
	}
	
	else {
		list.add(appointment);
	}
	user.setAppointment(list);
	appointment.setUser(user);
	
	appointmentDao.insertAndUpdateAppointment(appointment);
	return mav;
	
}

@GetMapping("/view_appoint")

public ModelAndView view_appointment() {
	ModelAndView mav = new ModelAndView("user/viewAppointmentUser.jsp");
	return mav;
	
	
}




@GetMapping("/updateAccept")


public ModelAndView updateAccept(@RequestParam int id) {
	
	
ModelAndView mav = new ModelAndView("doctor/viewAppointmentDoctor.jsp");


Appointment appoint = appointmentDao.fetchAppointmentById(id);
appoint.setStatus("accepted");

appointmentDao.insertAndUpdateAppointment(appoint);

return mav;
	
	
	
	
	
	
	
}



@GetMapping("/updateReject")


public ModelAndView updateReject(@RequestParam int id) {
	
	ModelAndView mav = new ModelAndView("doctor/viewAppointmentDoctor.jsp");
	
	
	Appointment appoint = appointmentDao.fetchAppointmentById(id);
	
	appoint.setStatus("rejected");
	
	appointmentDao.insertAndUpdateAppointment(appoint);
	
	return mav;
	
	
	
	
	
	
}
//	@PostMapping("/add_appointment")
//	public ModelAndView addAppointment(@ModelAttribute Appointment appointment, @RequestParam int doctorId,
//			@RequestParam int userId) {
//		ModelAndView mav = new ModelAndView("user/user_home.jsp");
//
//		Doctor doctor = doctorDao.fetchDoctorById(doctorId);
//
//		appointment.setDoctor(doctor);
////		doctor.setAppointment(appointment);
//		List<Appointment> listOfAppointments = doctor.getAppointment();
//		listOfAppointments.add(appointment);
//		doctor.setAppointment(listOfAppointments);
//
//		User user = userDao.fetchUserById(userId);
//		List<Appointment> list = user.getAppointment();
//		if(list == null) {
//			list = new ArrayList<Appointment>();
//			list.add(appointment);
//		}
//		else
//			list.add(appointment);
//
//		user.setAppointment(list);
//		appointment.setUser(user);
//
//		appointmentDao.insertAndUpdateAppointment(appointment);
//
//		return mav;
//	}
//
//	@GetMapping("/temp_add_appointment")
//	public ModelAndView temp_add_appointment() {
//		ModelAndView mav = new ModelAndView("user/add_appointment.jsp");
//		return mav;
//	}
//
//	@GetMapping("/view_apnmnt")
//	public ModelAndView view_appointment() {
//		ModelAndView mav = new ModelAndView("user/view_appointment.jsp");
//		return mav;
//	}
//
//	@GetMapping("/updateAccept")
//	public ModelAndView updateAccept(@RequestParam int id) {
//		ModelAndView mav = new ModelAndView("doctor/doctor_home.jsp");
//		Appointment appointment = appointmentDao.fetchAppointmentById(id);
//
//		appointment.setStatus("accepted");
//
//		appointmentDao.insertAndUpdateAppointment(appointment);
//
//		return mav;
//	}

}
