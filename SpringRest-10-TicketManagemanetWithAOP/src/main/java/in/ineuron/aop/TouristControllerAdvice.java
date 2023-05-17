package in.ineuron.aop;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvice {

	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> touristNotFoundExcetpionHandler(TouristNotFoundException tne){
		
		System.out.println("TouristControllerAdvice.touristNotFoundExcetpionHandler()");
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTime(LocalDateTime.now());
		errorDetails.setMessage(tne.getMessage());
		errorDetails.setError("404-Not Found");
		
		return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> tourisGlobalExceptionHandler(Exception e){
		
		System.out.println("TouristControllerAdvice.tourisGlobalExceptionHandler()");
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTime(LocalDateTime.now());
		errorDetails.setMessage(e.getMessage());
		errorDetails.setError("Internal Error");
		
		return new ResponseEntity<>(errorDetails , HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
