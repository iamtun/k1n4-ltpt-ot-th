package dao;


import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import db.ConnectServer;
import entity.Patient;

public class PatientDao {
	private OgmSessionFactory factory;

	public PatientDao() {
		super();
		this.factory = ConnectServer.getInstance().getSessionFactory();
	}
	
	public boolean addPatient(Patient patient) {
		OgmSession session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			session.save(patient);
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		
		return false;
	}
	
	public Patient getPatient(String patientId) {
		OgmSession session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		
		try {
			transaction.begin();
			
//			String query = "db.patients.find({_id: '"+ patientId + "'})";
//			Patient patient = session.createNativeQuery(query, Patient.class).getSingleResult();
			Patient patient = session.find(Patient.class, patientId);
			transaction.commit();
			return patient;
		} catch (Exception e) {
			transaction.rollback();
		}
		
		return null;
	}
}
