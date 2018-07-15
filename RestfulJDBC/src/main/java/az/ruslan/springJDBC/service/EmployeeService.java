package az.ruslan.springJDBC.service;

import java.util.List;

import az.ruslan.springJDBC.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int employeeId);

	boolean addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(int employeeId);

}
