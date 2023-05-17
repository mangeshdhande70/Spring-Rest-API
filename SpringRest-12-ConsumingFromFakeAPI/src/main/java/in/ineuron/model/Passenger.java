package in.ineuron.model;

import java.util.List;

import lombok.Data;

@Data
public class Passenger {
	 private String id;
     private String name;
     private int trips;
     private List<Airline> airline;
     private int __v;
}
