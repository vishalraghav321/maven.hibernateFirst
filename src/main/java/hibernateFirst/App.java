package hibernateFirst;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateFirst.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee emp = new Employee(1,"Vishal","Male",250000);
		
		
	}

}
