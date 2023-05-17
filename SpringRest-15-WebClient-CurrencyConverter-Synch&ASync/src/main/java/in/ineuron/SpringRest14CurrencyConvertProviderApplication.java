package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.controller.CurrencyConvertController;

@SpringBootApplication
public class SpringRest14CurrencyConvertProviderApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRest14CurrencyConvertProviderApplication.class, args);
	
	
		
		System.out.println("\n\n____________________synchornous_______________________");
		CurrencyConvertController bean = context.getBean(CurrencyConvertController.class);
	
		bean.invokedRestAPISynch("USD", "INR");
		
		
		System.out.println("\n\n_______________****************__________________________");
		
		System.out.println("____________________Asynchornous_______________________");
		bean.invokedRestAPIASynch("USD", "INR");
		
		
		
	}

}
