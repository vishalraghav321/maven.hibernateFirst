package hibernateFirst.configuration;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateConfiguration {
	public static SessionFactory getSessionFactory()
	{
		Properties prop = new Properties();
		prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		prop.put(Environment.URL, "jdbc:mysql://localhost:3306/hbm");
		prop.put(Environment.USER, "root");
		prop.put(Environment.PASS, "root");
		prop.put(Environment.HBM2DDL_AUTO, "update");
		prop.put(Environment.SHOW_SQL, "true");
		prop.put(Environment.FORMAT_SQL, "true");
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(prop).build();
		MetadataSources metadataSources = new MetadataSources(ssr);
		metadataSources.addAnnotatedClass(hibernateFirst.entity.Employee.class);
		SessionFactory sf = metadataSources.getMetadataBuilder().build().buildSessionFactory();
		
		
		
		return sf;
	}

}
