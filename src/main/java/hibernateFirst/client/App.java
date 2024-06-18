package hibernateFirst.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernateFirst.configuration.HibernateConfiguration;
import hibernateFirst.entity.Address;
import hibernateFirst.entity.Employee;


public class App {


	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee emp = new Employee();
		emp.setName("Tarun");
		emp.setGender("Male");
		
		List<Address> address = new ArrayList<>();
		Address a1 = new Address("S-850","GZB");
		Address a2 = new Address("H-399","GZB");
		Address a3 = new Address("F-49A","Delhi");
		Address a4 = new Address("H-403","Noida");

		address.add(a1);
		address.add(a2);
		address.add(a3);
		address.add(a4);
		
		a1.setEmployee(emp);
		a2.setEmployee(emp);
		a3.setEmployee(emp);
		a4.setEmployee(emp);
		
		emp.setAddress(address);
		
		Transaction tx = session.beginTransaction();
//		session.persist(a1);
//		session.persist(a2);
//		session.persist(a3);
//		session.persist(a4);
	
		session.persist(emp);
		
		tx.commit();

		Employee e1 = session.get(Employee.class, 1);
		System.out.println(e1.toString());
		System.out.println(e1.getAddress());
		session.close();
	}

}
