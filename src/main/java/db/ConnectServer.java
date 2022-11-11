package db;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmProperties;

import entity.Doctor;
import entity.Patient;
import entity.Person;
import entity.Treatment;

public class ConnectServer {
	private static ConnectServer instance = null;
	private OgmSessionFactory factory;

	private ConnectServer() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySetting(OgmProperties.ENABLED, true).configure().build();

		factory = new MetadataSources(registry).addAnnotatedClass(Doctor.class).addAnnotatedClass(Patient.class)
				.addAnnotatedClass(Person.class).addAnnotatedClass(Treatment.class).buildMetadata()
				.getSessionFactoryBuilder().unwrap(OgmSessionFactoryBuilder.class).build();
	}
	
	public static ConnectServer getInstance() {
		if(instance == null)
			instance = new ConnectServer();
		return instance;
	}

	public OgmSessionFactory getSessionFactory() {
		return factory;
	}
}
