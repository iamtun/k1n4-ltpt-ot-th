package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import entity.Doctor;
import entity.Patient;
import entity.Treatment;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 1791);
			//out truoc - in sau
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			//Cau 2.a
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
			treatments.add(new Treatment(new Doctor("DT105", "Louise Doran", _phones, certifications, "Cardiologists"),
					"Headaches", Date.from(Instant.parse("2020-04-09T17:00:00.000Z")),
					Date.from(Instant.parse("2020-04-09T17:00:00.000Z"))));
			Patient patient = new Patient("PT-40", "246 College Dr.Middletown, NY 10940", phones, "Steven King",
					Date.from(Instant.parse("1965-06-14T17:00:00.000Z")), treatments);
			
			while(true) {
				System.out.println("OK!");
				out.writeObject(patient);
				boolean rs = in.readBoolean();
				System.out.println(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
