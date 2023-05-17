package in.ineuron.service;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;

public interface IPersoneService {
	
	public Integer savePersonaDetails(Person person);
	
	public String savePhoneNumberWithPersonDetails(Iterable<PhoneNumber> number);
	
	public Iterable<Person> getAllPersonDetails();
	
	public Iterable<PhoneNumber> getAllPersonDetailsByPhone();
	
	
	public String deleteByPerson(Integer id);
	
	public String deletByAllPhoneNumbersOfPerson(int personId);

}
