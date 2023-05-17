package in.ineuron.controller;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Product;

@Controller
public class MyController {
	
	public void convertPojoToJson() throws JsonProcessingException {
		
		Product product = new Product();
		
		Product product2 = getProduct(product);
		
		System.out.println("Data in java form :: "+product2);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonData = objectMapper.writeValueAsString(product2);
		System.out.println("Data in Json :: "+jsonData);
	
	}
	
	
	public static Product getProduct(Product product) {
		
		product.setId(5);
		product.setName("PEN");
		product.setPrice(10.5f);
		
		return product;
		
	}

}
