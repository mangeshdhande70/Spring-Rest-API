package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("rawtypes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mobile extends RepresentationModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private MobileCompany company;
	
	private String model;
	
	private Double price;
	
	@Enumerated(EnumType.STRING)
	private MobileColor color;
	

}
