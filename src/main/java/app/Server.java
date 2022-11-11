package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.PatientDao;
import entity.Patient;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1791);
			System.out.println("Ready...");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.print(socket.getInetAddress().getHostAddress());

				new Thread(new Handler(socket)).start();
				System.out.println("Oke socket!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Handler implements Runnable {
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private PatientDao dao;

	public Handler(Socket socket) {
		this.socket = socket;
		dao = new PatientDao();
	}

	@Override
	public void run() {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("OK!");
			while (true) {
				Patient patient = (Patient) in.readObject();
				boolean res = dao.addPatient(patient);
				System.out.println(res);
				out.writeBoolean(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
