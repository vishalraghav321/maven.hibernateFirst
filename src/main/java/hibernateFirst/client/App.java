package hibernateFirst.client;

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
import jakarta.persistence.Query;

public class App {

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setName("Shivam");
		emp.setGender("Male");
		
		Address address = new Address();
		address.setCity("Noida");
		address.setState("UP");
		
		emp.setAddress(address);
		address.setEmployee(emp);
		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		SessionFactory sessionFactory = new MetadataSources(ssr).getMetadataBuilder().build().buildSessionFactory();
		
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(address);
		session.persist(emp);

		tx.commit();
		
		Employee em1 = session.get(Employee.class, 1);
		System.out.println(em1.toString());
		session.close();
//		sessionFactory.close();
		
		
//		Query query = session.createQuery("select sum(salary) from TCS_emp");
//		query.setFirstResult(2);
//		query.setMaxResults(3);
		
//		Query query = session.createQuery("update TCS_emp set name=:n where id=:i");
//		query.setParameter("n", "Amit Kumar");
//		query.setParameter("i", 2);
//		query.executeUpdate();
//		System.out.println(query.getResultList());
//		session.persist(emp);

	}

}
