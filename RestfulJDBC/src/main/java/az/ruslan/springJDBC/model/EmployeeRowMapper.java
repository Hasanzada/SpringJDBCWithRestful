package az.ruslan.springJDBC.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setId(row.getInt("id"));
		employee.setName(row.getString("name"));
		employee.setSurname(row.getString("surname"));
		employee.setAge(row.getInt("age"));
		employee.setSalary(row.getDouble("salary"));
		
		return employee;
	}

}
