package in.ineuron.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import in.ineuron.model.Student;

@Controller
@RequestMapping("/api")
public class MyController {
		
	 @Autowired	
	 private RestTemplate restTemplate;
	 
	 
	 // getting details 
	 @GetMapping(value = "/get")
		public ResponseEntity<String> get() {
			
			String url = "http://localhost:9999/stud/get/{id}";
			
			ResponseEntity<String> entity = restTemplate.exchange(url,HttpMethod.GET , null,String.class , 7);
			
			return entity;
		}
	 
	 
	 
	 @GetMapping(value = "/getAll")
		public ResponseEntity<String> getAll() {
			
			String url = "http://localhost:9999/stud/getAll";
			
			ResponseEntity<String> entity = restTemplate.exchange(url,HttpMethod.GET , null,String.class);
			
			return entity;
		}

	 
	// adding data by writing json  
	@PostMapping(value = "/add")
	public ResponseEntity<?> addStudent(){
		
		String uri = "http://localhost:9999/stud/add";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String json = "{\r\n"
				+ "    \"name\": \"Akash\",\r\n"
				+ "    \"address\": \"Nanda Phata\"\r\n"
				+ "}";
		
		HttpEntity<String> request = new HttpEntity<>( json , headers);
		ResponseEntity<String> entity = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		return entity;
	}
	 
	
	@PostMapping(value = "/addByReq")
	public ResponseEntity<?> addStudentcBy(@RequestBody Student student){
		
		String uri = "http://localhost:9999/stud/add";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String json = "{\r\n"
				+ "    \"name\": \"Akash\",\r\n"
				+ "    \"address\": \"Nanda Phata\"\r\n"
				+ "}";
		
		HttpEntity<String> request = new HttpEntity<>( json , headers);
		ResponseEntity<String> entity = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		return entity;
	}
	
	
	
}
