package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.service.TicketService;

@SpringBootApplication
public class SpringRest16TicketManagementProviderApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRest16TicketManagementProviderApplication.class, args);
	
		TicketService bean = context.getBean(TicketService.class);
		
		bean.invokeRestApi();
	
		
	}

}
