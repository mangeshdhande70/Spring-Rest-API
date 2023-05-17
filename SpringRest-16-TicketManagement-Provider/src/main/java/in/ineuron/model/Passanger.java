package in.ineuron.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Passanger {
	private String firstName;
	private String lastName;
	private String trainNo;
	private String from;
	private String to;
	private LocalDate journeyDate;
}
