package in.ineuron.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.model.CurrencyConvert;

@RestController
@RequestMapping(value = "/api")
public class CurrencyConvertController {
	
	
	public void invokedRestAPISynch(String from , String to){
		
		System.out.println("Synchrounous Restcall is started");
		
		String url = "http://localhost:8080/api/get/from/{from}/to/{to}";
		
		WebClient webClient = WebClient.create();
		
		CurrencyConvert currencyConvert = webClient.get().
				uri(url, from , to).
				accept(MediaType.APPLICATION_JSON).
				retrieve().
				bodyToMono(CurrencyConvert.class).
				block();
		
		System.out.println(currencyConvert);
		
		System.out.println("Synchrounous Restcall is started");
	}
	
	
public void invokedRestAPIASynch(String from , String to){
		
		System.out.println("Asynchrounous Restcall is started");
		
		String url = "http://localhost:8080/api/get/from/{from}/to/{to}";
		
		WebClient webClient = WebClient.create();
		
		webClient.get().
				uri(url, from , to).
				accept(MediaType.APPLICATION_JSON).
				retrieve().
				bodyToMono(CurrencyConvert.class).
				subscribe(CurrencyConvertController::getResponse);
		
		
		System.out.println("Asynchrounous Restcall is started");
	}

 public static void getResponse(CurrencyConvert currencyConvert) {
	 
	 System.out.println(currencyConvert);
	 
 }



}
