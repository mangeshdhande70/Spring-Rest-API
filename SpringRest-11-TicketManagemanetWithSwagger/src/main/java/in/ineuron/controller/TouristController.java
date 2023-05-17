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
import io.swagger.annotations.ApiOperation;

@RestController // combination of @Controller + @ResponseBody
@RequestMapping(value = "/api/tourist")
public class TouristController {

	@Autowired
	private ITouristService service;

	@PostMapping(value = "/reg")
	@ApiOperation("For Tourist Registration")
	public ResponseEntity<String> register(@RequestBody Tourist tourist) {
			String register = service.register(tourist);
			return new ResponseEntity<String>(register, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	@ApiOperation("For Getting All Tourists List")
	public ResponseEntity<?> fetchAll() {
			List<Tourist> list = service.fetchAll();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
			
	}

	@GetMapping(value = "/byid/{id}")
	@ApiOperation("For Getting one Tourist Details by Providing ID")
	public ResponseEntity<?> fetchById(@PathVariable("id") Integer id) {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
	}
	
	
    @PutMapping(value = "/modify")
    @ApiOperation("For Updating details of Tourist")
	public ResponseEntity<String> updateTouristDetails(@RequestBody Tourist tourist) {
			String updateTouristDetails = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(updateTouristDetails, HttpStatus.OK);
	}
    
    
    @PatchMapping(value = "/updateBudget/{id}/{hike}")
    @ApiOperation("For Updating only Budeget")
    public ResponseEntity<String> updateBudget(@PathVariable("id") Integer id ,@PathVariable("hike") Float hikePer ){
			String update = service.updateBudgetById(id, hikePer);
			return new ResponseEntity<String>(update , HttpStatus.OK);
    	
    }

}
