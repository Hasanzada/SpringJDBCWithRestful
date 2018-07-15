package az.ruslan;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import az.ruslan.springJDBC.model.Employee;



public class RestClient {

	public void getEmployeeById() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/employee/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Employee.class, 1);
		Employee employee = responseEntity.getBody();
		System.out.println("Id:" + employee.getId() + ", name:" + employee.getName() + ", Surname:"
				+ employee.getSurname() + "Age" + employee.getAge() + "salary" + employee.getSalary());
	}

	/*public void getArticleByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/article/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Article> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Article.class, 1);
		Article article = responseEntity.getBody();
		System.out.println("Id:" + article.getArticleId() + ", Title:" + article.getTitle() + ", Category:"
				+ article.getCategory());
	}
 
	 */

}
