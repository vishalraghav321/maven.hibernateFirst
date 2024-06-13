package hibernateFirst.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernateFirst.configuration.HibernateConfiguration;
import hibernateFirst.entity.Employee;
import jakarta.persistence.Query;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Employee emp = new Employee(5, "Abhishek", "Male", 250000);
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		SessionFactory sessionFactory = new MetadataSources(ssr).getMetadataBuilder().build().buildSessionFactory();
		
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		Query query = session.createQuery("select sum(salary) from TCS_emp");
//		query.setFirstResult(2);
//		query.setMaxResults(3);
		
		Query query = session.createQuery("update TCS_emp set name=:n where id=:i");
//		query.setParameter("n", "Amit Kumar");
//		query.setParameter("i", 2);
//		query.executeUpdate();
		System.out.println(query.getResultList());
//		session.persist(emp);
//		tx.commit();
	}

}
