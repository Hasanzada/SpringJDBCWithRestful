package az.ruslan.springJDBC.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import az.ruslan.springJDBC.model.Employee;
import az.ruslan.springJDBC.model.EmployeeRowMapper;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Employee employee) {
		String sql = "insert into employee(name,surname,age,salary) values(?,?,?,?)";
		Object params[] = { employee.getName(), employee.getSurname(), employee.getAge(), employee.getSalary() };
		jdbcTemplate.update(sql, params);

		// Fetch article id
		sql = "SELECT id FROM employee WHERE name = ? and surname=? and age=? and salary=?";
		int employeeId = jdbcTemplate.queryForObject(sql, Integer.class, employee.getName(), employee.getSurname(),
				employee.getAge(), employee.getSalary());

		// Set article id
		employee.setId(employeeId);
	}

	@Override
	public void update(Employee employee) {
		Object params[] = { employee.getName(), employee.getSurname(), employee.getAge(), employee.getSalary(),
				employee.getId() };
		jdbcTemplate.update("update employee set name = ?,surname = ?,age = ?,salary = ? where id = ?", params);

	}

	@Override
	public void delete(int employeeId) {
		Object params[] = { employeeId };
		jdbcTemplate.update("delete from employee where id = ?", params);

	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		String sql = "select * from employee where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, employeeId);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {

		String sql = "select * from employee";
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public boolean employeeExists(String name, String surname, int age, double salary) {
		String sql = "SELECT count(*) FROM employee WHERE name = ? and surname=? and age = ? and salary=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, name, surname, age, salary);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	
	}

	
	
}
