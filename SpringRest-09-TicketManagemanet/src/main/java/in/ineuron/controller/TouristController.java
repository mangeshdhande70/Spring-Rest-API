package in.ineuron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristService;

@RestController // combination of @Controller + @ResponseBody
@RequestMapping(value = "/api/tourist")
public class TouristController {

	@Autowired
	private ITouristService service;

	@PostMapping(value = "/reg")
	public ResponseEntity<String> register(@RequestBody Tourist tourist) {

		try {
			String register = service.register(tourist);
			return new ResponseEntity<String>(register, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Sorry some internal server error! please try after sometimg",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/all")
	public ResponseEntity<?> fetchAll() {

		try {
			List<Tourist> list = service.fetchAll();
			if (!list.isEmpty())
				return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
			else
				return new ResponseEntity<String>("No Data", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/byid/{id}")
	public ResponseEntity<?> fetchById(@PathVariable("id") Integer id) {

		try {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
    @PutMapping(value = "/modify")
	public ResponseEntity<String> updateTouristDetails(@RequestBody Tourist tourist) {

		try {
			String updateTouristDetails = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(updateTouristDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
    
    
    @PatchMapping(value = "/updateBudget/{id}/{hike}")
    public ResponseEntity<String> updateBudget(@PathVariable("id") Integer id ,@PathVariable("hike") Float hikePer ){
    	
    	try {
			String update = service.updateBudgetById(id, hikePer);
			return new ResponseEntity<String>(update , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage() , HttpStatus.NOT_FOUND);
		}
    	
    	
    }

}
