package in.ineuron;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.service.IPersoneService;

@SpringBootApplication
public class SpringRest21AssociationBiDirectionalApplication implements CommandLineRunner {

	@Autowired
	private IPersoneService service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRest21AssociationBiDirectionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//		saveChildToParent();
		
//		saveOperationParentToChilde();
		
		
		//Load Operation from parent to child [One TO Many] by default Lazy
//		getAllPersonsByPersonCall();
		
		
		//Load Operation from child to Parent [Many To One ] by default Eager
//		getAllPersonsByPhoneNumberCall();
		
		
		//Delete By Person(Parent)
//		deletByChild();
		
		
		//Delete By Person Id(Child)
		deletByChild();

		
	}
	
	//Save Operation parent to child
	public void saveOperationParentToChilde() {
		
		
				PhoneNumber p1 = new PhoneNumber(7030765414L);
				PhoneNumber p2 = new PhoneNumber(9922445489L);
				
				Person person = new Person("Akash", 26);
				
				p1.setPerson(person);
				p2.setPerson(person);
				
				
				Set<PhoneNumber> phonset = Set.of(p1,p2);
				person.setPhoneNumbers(phonset);
	
				String status = service.savePhoneNumberWithPersonDetails(phonset);
				
				System.out.println(status);
		
	}
	
	
	//Save Operation child to parent
	public void saveChildToParent() {
		Person person = new Person("Ankit", 25);
		
		
		PhoneNumber p1 = new PhoneNumber(9999999999L);
		PhoneNumber p2 = new PhoneNumber(8888888888L);
		
	
		p1.setPerson(person);
		p2.setPerson(person);
		
		Set<PhoneNumber> phoneNumbers = Set.of(p1, p2);
		
		person.setPhoneNumbers(phoneNumbers);
		
		
		
		Integer id = service.savePersonaDetails(person);
		
		System.out.println("Person Details saved with id :: "+id);
	}
	
	
	//Load Operation from parent to child [One TO Many] by default Lazy
	public void getAllPersonsByPersonCall() {
		

		service.getAllPersonDetails().forEach(perosn -> {
			System.out.println("Parent :: "+perosn);
			Set<PhoneNumber> numbers = perosn.getPhoneNumbers();
			numbers.forEach(num -> {
				System.out.println(num);
			});
		});
		
	}
	
	
	//Load Operation from child to Parent [Many To One ] by default Eager
	public void getAllPersonsByPhoneNumberCall() {
			
			service.getAllPersonDetailsByPhone().forEach(phone -> {
				System.out.println(phone.getPerson());
				System.out.println("Parent :: "+phone);	
			});
			
		}
	
	
	// Delete info by Parent
	public void deletByParent() {
		System.out.println(service.deleteByPerson(1));
	}
	
	
	   // Delete info by Child
	public void deletByChild() {
			System.out.println(service.deletByAllPhoneNumbersOfPerson(2));
		}
	
	
	


}