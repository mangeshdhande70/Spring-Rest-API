package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.MobileCases;
import in.ineuron.service.IMobileCaseService;

@RestController
@RequestMapping(value = "/cases")
public class MobileCasesController {
	
	@Autowired
	private IMobileCaseService service;
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addMobile(@RequestBody MobileCases mobileCases){
		
		String status = service.addMobileCases(mobileCases);
		
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getCases/{model}")
	public ResponseEntity<List<MobileCases>> getCasesByModel(@PathVariable String model){
		
		List<MobileCases> list = service.getByModel(model);
		
		return new ResponseEntity<List<MobileCases>>(list , HttpStatus.OK);
	}

}
