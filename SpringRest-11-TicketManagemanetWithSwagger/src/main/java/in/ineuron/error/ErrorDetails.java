package in.ineuron.error;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
	
	private LocalDateTime time;
	private String message;
	private String error;

}
