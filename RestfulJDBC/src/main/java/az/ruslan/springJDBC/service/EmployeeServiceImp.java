package az.ruslan.springJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import az.ruslan.springJDBC.dao.EmployeeDao;
import az.ruslan.springJDBC.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {

		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public synchronized boolean addEmployee(Employee emp) {
		if (employeeDao.employeeExists(emp.getName(), emp.getSurname(), emp.getAge(), emp.getSalary())) {
			return false;
		} else {
			employeeDao.insert(emp);
			return true;
		}

	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeDao.delete(employeeId);

	}

}
