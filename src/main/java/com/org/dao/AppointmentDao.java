package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Appointment;
import com.org.dto.Doctor;

@Repository
public class AppointmentDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");

	public void insertAndUpdateAppointment(Appointment appointment) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();

		em.merge(appointment);

		et.commit();

	}

	public Appointment fetchAppointmentById(int id) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		return em.find(Appointment.class, id);

	}

	public List<Appointment> fetchAll() {
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select d from Appointment d ");
		List<Appointment> list = query.getResultList();

		return list;
	}

	public List<Appointment> verifyAppointmentByEmailAndPassword(String email, String password) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select d frorm Appointment d where d.email=? and d.password=?");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Appointment> list = query.getResultList();

		return list;
	}

	public boolean deleteAppointmentById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Appointment appointment = em.find(Appointment.class, id);

		if (appointment != null) {
			et.begin();
			em.remove(appointment);
			et.commit();
			return true;
		}
		return false;
	}

	public void UpdateAppointment(Appointment appointment ,Doctor doctor, int apId) {
//		appointment.getId();
//		appointment.getName();
//		appointment.getEmail();
//	
//		appointment.getAddress();
//		appointment.getAppointmentDate();
//		appointment.getDiseases();
//		appointment.getPhone();
//		appointment.getGender();
//		appointment.getUser();
//		appointment.getAge();
//		appointment.getDoctor();

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();

		Query query = em.createQuery(
				"UPDATE Appointment e SET e.aadhar = :aadhar, e.address=:address, e.age=:age,e.appointmentDate=:apDate,e.diseases=:diseases,e.email=:email,e.gender=:gender,e.name=:name,e.phone=:phone WHERE e.id = :id ");
query.setParameter("aadhar",	appointment.getAadhar() );
query.setParameter("name",	appointment.getName() );
query.setParameter("email",	appointment.getEmail() );
query.setParameter("address",	appointment.getAddress() );
query.setParameter("apDate",	appointment.getAppointmentDate() );
query.setParameter("diseases",	appointment.getDiseases() );
query.setParameter("phone",	appointment.getPhone() );
query.setParameter("gender",	appointment.getGender() );
query.setParameter("age",	appointment.getAge() );
query.setParameter("id", apId);


int rows = query.executeUpdate();
System.out.println(rows);
		

		et.commit();

	}

}
