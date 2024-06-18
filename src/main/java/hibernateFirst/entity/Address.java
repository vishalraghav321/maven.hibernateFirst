package hibernateFirst.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity 
public class Address {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	private String state;
	@OneToOne(mappedBy = "address")
	private Employee employee;
	
	public Address(int id, String city, String state, Employee employee) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.employee = employee;
	}

	public Address() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + "]";
	}
	
	
}
