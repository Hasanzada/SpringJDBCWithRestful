package az.ruslan.springJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import az.ruslan.springJDBC.model.Employee;
import az.ruslan.springJDBC.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Employee emp = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping("employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@PostMapping("employee")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee, UriComponentsBuilder builder) {
		boolean b = employeeService.addEmployee(employee);
		if (b == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@PutMapping("employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@DeleteMapping("employee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
