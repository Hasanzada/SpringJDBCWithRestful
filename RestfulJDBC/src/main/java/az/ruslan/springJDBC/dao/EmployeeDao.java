package az.ruslan.springJDBC.dao;

import java.util.List;

import az.ruslan.springJDBC.model.Employee;

public interface EmployeeDao {

	void insert(Employee employee);

	void update(Employee employee);

	void delete(int employeeId);

	Employee getEmployeeById(int employeeId);

	List<Employee> getAllEmployees();

	boolean employeeExists(String name, String surname, int age, double salary);
}
