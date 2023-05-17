package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.CurrencyConvert;

@RestController
@RequestMapping(value = "/api")
public class CurrencyConvertController {
	
	
	@GetMapping(value = "/get/from/{from}/to/{to}")
	public ResponseEntity<CurrencyConvert> converter(@PathVariable String from , @PathVariable String to){
		
		
		CurrencyConvert convert = new CurrencyConvert();
		
		convert.setFrom(from);
		convert.setTo(to);
		convert.setExchangeRatio(82.0);
		
		
		return new ResponseEntity<CurrencyConvert>(convert , HttpStatus.OK);
		
	}

}
