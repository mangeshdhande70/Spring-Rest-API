package in.ineuron.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TicketBooking {
	
	private Long tikcteId;
	private Long trainNo;
	private String from;
	private String destination;
	private LocalDateTime date;
	private Double ticketAmount;
}
