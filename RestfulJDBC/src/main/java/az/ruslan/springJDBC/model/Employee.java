package az.ruslan.springJDBC.model;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * model class
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String surname;
	private int age;
	private double salary;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public Employee() {
		
	}
	
	//for update in restclient
	public Employee(int id, String name, String surname, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
	}
	
	
	//for insert in restclient
	public Employee(String name, String surname, int age, double salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", salary=" + salary
				+ "]";
	}
	
	
	
}
