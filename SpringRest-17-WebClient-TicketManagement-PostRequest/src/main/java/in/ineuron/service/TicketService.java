package in.ineuron.service;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.model.Passanger;
import in.ineuron.model.TicketBooking;

@Service
public class TicketService {
	
	
	private static final String REST_END_URL = "http://localhost:8090/api/book";

	public void invokeRestApi() {

		WebClient client = WebClient.create();

		Passanger body = new Passanger();
		body.setFirstName("nitin");
		body.setLastName("manjunath");
		body.setJourneyDate(LocalDate.now());
		body.setFrom("bengaluru");
		body.setTo("pune");
		body.setTrainNo("BNG-PUN-1234");

		TicketBooking response = client.post().uri(REST_END_URL).accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(body)).retrieve().bodyToMono(TicketBooking.class).block();

		System.out.println(response);

	}
	

}
