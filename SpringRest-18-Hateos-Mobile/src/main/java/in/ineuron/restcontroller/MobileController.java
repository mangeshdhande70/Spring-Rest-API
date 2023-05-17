package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Mobile;
import in.ineuron.model.MobileCompany;
import in.ineuron.service.IMobileService;

@RestController
@RequestMapping(value = "/mobile")
public class MobileController {
	
	@Autowired
	private IMobileService service;
	
	private final String URL_GET_CASES = "http://localhost:8000/cases/getCases/14";
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addMobile(@RequestBody Mobile mobile){
		
		String status = service.addMobile(mobile);
		
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/buy/{company}/{model}")
	public ResponseEntity<Mobile> buyMobile(@PathVariable MobileCompany company , @PathVariable String model){
		
		List<Mobile> list = service.getMobileByCompanyAndModel(company, model);
		
		Mobile mobile = list.get(0);
		
		
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MobileCasesController.class).getCasesByModel(model))
				.withRel("/cases/getCases/"+model);

		
        mobile.add(link);
		
		return new ResponseEntity<Mobile>(mobile , HttpStatus.OK);
	}

}
