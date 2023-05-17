package in.ineuron.model;

import java.util.List;

import lombok.Data;

@Data
public class PassengerData {
	
	    private int totalPassengers;
	    private int totalPages;
	    private List<Passenger> data;

}
