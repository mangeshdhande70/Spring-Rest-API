package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.model.Passanger;
import in.ineuron.model.TicketBooking;

@RestController
@RequestMapping(value = "/api")
public class TicketController {
	
	@GetMapping(value = "/bk")
	public ResponseEntity<TicketBooking> bookTicket(){
		
		
		System.out.println("Synchronous call Started");
		
		String url = "http://localhost:8080/api/book";
		
		WebClient webClient = WebClient.create();
		
	    TicketBooking ticketBooking = webClient.
		get().uri(url).retrieve().bodyToMono(TicketBooking.class).block();
		

		System.out.println("Synchronous call Stopped");
		
		return new ResponseEntity<TicketBooking>(ticketBooking , HttpStatus.ACCEPTED);
		
		
	}
	
	

}
