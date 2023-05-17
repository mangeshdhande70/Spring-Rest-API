package in.ineuron.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regNo;
	
	@NonNull
	private Long contactNo;
	
	@ManyToOne(targetEntity = Person.class , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private Person person;

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", contactNo=" + contactNo;
	}
	

}
