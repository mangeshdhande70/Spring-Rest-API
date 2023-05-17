package in.ineuron.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import in.ineuron.model.Airline;
import in.ineuron.model.Passenger;
import in.ineuron.model.PassengerData;

@Controller
@RequestMapping("/api")
public class MyController {
		
	 @Autowired	
	 private RestTemplate restTemplate;
	 
	 
	 @GetMapping(value = "/data")
		public ResponseEntity<String> get() {
			
			String jsonData = "http://localhost:9999/stud/get/{id}";
			
			ResponseEntity<String> entity = restTemplate.getForEntity(jsonData, String.class, Map.of("id" , 3));
			
			return entity;
		}
	 
	@PostMapping(value = "/add")
	public ResponseEntity<?> addStudent(){
		
		String uri = "http://localhost:9999/stud/add";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String json = "{\r\n"
				+ "    \"name\": \"Diksha\",\r\n"
				+ "    \"address\": \"Charli\"\r\n"
				+ "}";
		
		HttpEntity<String> request = new HttpEntity<>( json , headers);
		
		restTemplate.postForEntity(uri, request, String.class);
		
		
		return new ResponseEntity<String>(json , HttpStatus.CREATED);
	}
	 
	 
	 
		
	@GetMapping(value = "/pass")
	public ResponseEntity<?> getPassenger(){
		
		
		String uri = "https://api.instantwebtools.net/v1/passenger?page=0&size=10";
		
	    restTemplate = new RestTemplate();
		
//		PassengerData passengerData = restTemplate.getForObject(uri, PassengerData.class);
//		System.out.println(passengerData);
		
//	return new ResponseEntity<PassengerData>(passengerData , HttpStatus.OK);
	    
	    ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
	    
	    System.out.println(entity.getBody());
	    System.out.println(entity.getStatusCode());
	    System.out.println(entity.getClass());
	    System.out.println(entity.getHeaders());
		
	    return new ResponseEntity<String>(entity.getBody(), HttpStatus.OK);

		
	}
	
	@GetMapping(value = "/getWeb")
	public String getWeb(Model model) {
		
        String uri = "https://api.instantwebtools.net/v1/passenger?page=0&size=10";
		
		RestTemplate restTemplate = new RestTemplate();
		
		PassengerData passengerData = restTemplate.getForObject(uri, PassengerData.class);
		
		System.out.println(passengerData);
		
		List<Passenger> data = passengerData.getData();
		
		Passenger passenger = data.get(0);
		List<Airline> airline = passenger.getAirline();
		Airline airline2 = airline.get(0);
		String website = airline2.getWebsite();
		
		System.out.println(website);
		
		model.addAttribute("web", website);
		
		return "web";
		
		
		
	}
	
}
