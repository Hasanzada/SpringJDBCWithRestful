package az.ruslan.restclient;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import az.ruslan.springJDBC.model.Employee;


public class RestClient {

	public void getAllEmployees() {

		String url = "http://localhost:8080/employees";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Employee[].class);
		HttpStatus statusCode = response.getStatusCode();
		if (statusCode == HttpStatus.OK) {
			Employee[] list = response.getBody();
			if (list != null) {
				for (Employee e : list) {
					System.out.println("ad: " + e.getName() + " soyad: " + e.getSurname() + " yas: " + e.getAge()
							+ " maas: " + e.getSalary());
				}
			}
		}

	}

	public static void getEmployeeById(int id) {
		String url = "http://localhost:8080/employee/{id}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.GET, entity, Employee.class, id);
		Employee e = response.getBody();
		System.out.println(e.getName() + " " + e.getSurname() + " " + e.getAge() + " " + e.getSalary());

	}

	public void addEmployee(Employee emp) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/employee";
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(emp, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}

	public void updateEmployee(Employee emp) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/employee";
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(emp, headers);
		restTemplate.put(url, requestEntity);
	}

	public void deleteEmployee(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/employee/{id}";
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, id);
	}

	public static void main(String[] args) {

		RestClient restClient = new RestClient();
		Employee emp = new Employee();
		//restClient.updateEmployee(emp);
		//restClient.addEmployee(emp);
		//restClient.deleteEmployee(10);
		//restClient.getEmployeeById(3);
		restClient.getAllEmployees();

	}

}
