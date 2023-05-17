package in.ineuron.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Airline;
import in.ineuron.model.Passenger;
import in.ineuron.model.PassengerData;
import in.ineuron.model.Student;

@Controller
@RequestMapping("/stud")
public class MyController {
		

	@GetMapping(value = "/data")
	public ResponseEntity<String> get() {
		
		String jsonData = "http://localhost:9999/stud/get/{id}";
		
		
		System.out.println(jsonData);
		
		
		RestTemplate restTemplate = new RestTemplate();
		String res = restTemplate.getForObject(jsonData, String.class);
		
		System.out.println(res);
		
		Student student = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			student = objectMapper.readValue(res, Student.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(student);
		
		
		return new ResponseEntity<>(res , HttpStatus.OK);
	}
		
	@GetMapping(value = "/pass")
	public ResponseEntity<PassengerData> getPassenger(){
		
		
		String uri = "https://api.instantwebtools.net/v1/passenger?page=0&size=10";
		
		RestTemplate restTemplate = new RestTemplate();
		
		PassengerData passengerData = restTemplate.getForObject(uri, PassengerData.class);
		
		System.out.println(passengerData);
		
		return new ResponseEntity<PassengerData>(passengerData , HttpStatus.OK);
		
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
