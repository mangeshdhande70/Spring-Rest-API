package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Passanger;
import in.ineuron.model.TicketBooking;

@RestController
@RequestMapping(value = "/api")
public class TicketController {
	
	@PostMapping(value = "/book")
	public ResponseEntity<TicketBooking> bookTicket(@RequestBody Passanger passanger){
		
		
		TicketBooking ticketBooking = new TicketBooking();
		
		ticketBooking.setJourneyDate(passanger.getJourneyDate());
		ticketBooking.setFirstName(passanger.getFirstName());
		ticketBooking.setLastName(passanger.getLastName());
		ticketBooking.setFrom(passanger.getFrom());
		ticketBooking.setTo(passanger.getTo());
		ticketBooking.setTrainNo(passanger.getTrainNo());
		ticketBooking.setTikcteId(1234L);
		ticketBooking.setTicketAmount(800.0);
		
	
		return new ResponseEntity<TicketBooking>(ticketBooking , HttpStatus.ACCEPTED);
		
		
	}
	
	

}
