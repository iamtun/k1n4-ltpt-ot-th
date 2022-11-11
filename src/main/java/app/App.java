package app;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import dao.PatientDao;
import entity.Doctor;
import entity.Patient;
import entity.Treatment;

public class App {
	public static void main(String[] args) {
		PatientDao dao = new PatientDao();
//		//Cau 2.a
		Set<String> phones = new HashSet<String>();
		phones.add("(515) 123-4567");

		Set<String> _phones = new HashSet<String>();
		_phones.add("(650) 505-3876");
		_phones.add("(650) 507-9833");

		Set<String> certifications = new HashSet<String>();
		certifications.add("CPhT");
		certifications.add("CCS-P");
		certifications.add("CCMA");

		Set<Treatment> treatments = new HashSet<Treatment>();
		treatments.add(new Treatment(new Doctor("DT104", "Louise Doran", _phones, certifications, "Cardiologists"),
				"Headaches", Date.from(Instant.parse("2020-04-09T17:00:00.000Z")),
				Date.from(Instant.parse("2020-04-09T17:00:00.000Z"))));
		Patient patient = new Patient("PT-66", "246 College Dr.Middletown, NY 10940", phones, "Steven King",
				Date.from(Instant.parse("1965-06-14T17:00:00.000Z")), treatments);

		System.out.println(dao.addPatient(patient));

		// Cau 2.b
		Patient patient2 = dao.getPatient("PT-3");
		System.out.println(patient2);
	}
}
