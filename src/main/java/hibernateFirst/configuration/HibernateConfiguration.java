package hibernateFirst.configuration;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.JdbcSettings;

public class HibernateConfiguration {
	public static SessionFactory getSessionFactory()
	{
		Properties prop = new Properties();
		prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		prop.put(JdbcSettings.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/new_schema");
		prop.put(JdbcSettings.JAKARTA_JDBC_USER, "root");
		prop.put(JdbcSettings.JAKARTA_JDBC_PASSWORD, "root");
		prop.put(Environment.HBM2DDL_AUTO, "create");
		prop.put(Environment.SHOW_SQL, "true");
		prop.put(Environment.FORMAT_SQL, "true");
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(prop).build();
		MetadataSources metadataSources = new MetadataSources(ssr);
		metadataSources.addAnnotatedClass(hibernateFirst.entity.Employee.class);
		metadataSources.addAnnotatedClass(hibernateFirst.entity.Address.class);
		SessionFactory sf = metadataSources.getMetadataBuilder().build().buildSessionFactory();
		return sf;
	}

}
