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
		Transaction tx = session.beginTransaction();
		
		Employee emp1 = new Employee();
		emp1.setName("Nishant Raghav");
		emp1.setGender("Male");
		
		Employee emp2 = new Employee();
		emp2.setName("Tarun");
		emp2.setGender("Male");
		
		
		Employee emp3 = new Employee();
		emp3.setName("Abhay");
		emp3.setGender("Male");
		
		
		
		Address a1 = new Address("H-49","Noida");
		Address a2 = new Address("H-403","GZB");
		Address a3 = new Address("H-309","Delhi");
		Address a4 = new Address("H-49A","Noida");
		
		List<Address> emp1add = new ArrayList<>();
		List<Address> emp2add = new ArrayList<>();
		List<Address> emp3add = new ArrayList<>();
		
		emp1add.add(a1);
		emp1add.add(a2);
		emp1.setAddress(emp1add);
		
		emp2add.add(a2);
		emp2add.add(a3);
		emp2.setAddress(emp2add);
		
		emp3add.add(a3);
		emp3add.add(a4);
		emp3.setAddress(emp3add);
		
		List<Employee> a1emp = new ArrayList<>();
		List<Employee> a2emp = new ArrayList<>();
		List<Employee> a3emp = new ArrayList<>();
		List<Employee> a4emp = new ArrayList<>();
		
		a1emp.add(emp1);
		a1.setEmployee(a1emp);
		
		a2emp.add(emp1);
		a2emp.add(emp2);
		a2.setEmployee(a2emp);
		
		a3emp.add(emp2);
		a3emp.add(emp3);
		a3.setEmployee(a3emp);
		
		a4emp.add(emp3);
		a4.setEmployee(a4emp);
		
		session.persist(emp1);
		session.persist(emp2);
		session.persist(emp3);
		
		tx.commit();
	}

}
