package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;

import in.ineuron.controller.MyController;

@SpringBootApplication
public class SpringRest08JsonToPojoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRest08JsonToPojoApplication.class, args);
		
		MyController controller = context.getBean(MyController.class);
		
		try {
			controller.convertPojoToJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
