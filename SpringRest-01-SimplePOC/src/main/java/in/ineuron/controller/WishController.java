package in.ineuron.controller;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wish")
public class WishController {
	
	
	@GetMapping(value = "/msg")
	@ResponseBody    // the resopnse will not given to view resolver directly send to client
	public ResponseEntity<String> generateWishMesg(){
		
		
		LocalDateTime localDateTime = LocalDateTime.now();
		int hour = localDateTime.getHour();
		
		String body = null;
		
		if (hour < 12) {
			body = "Good Morning";
		}else if (hour < 16) {
			body = "Good Afternoon";
		}
		else if (hour<20) {
			body = "Good Eve";
		}else {
			body = "Good Night";
		}
		
		
		ResponseEntity<String> entity = new ResponseEntity<>(body , HttpStatus.OK);
		
		return entity;
		
	}

}
