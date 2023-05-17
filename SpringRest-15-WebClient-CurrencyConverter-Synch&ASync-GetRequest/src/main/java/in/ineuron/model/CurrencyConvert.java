package in.ineuron.model;

import lombok.Data;

@Data
public class CurrencyConvert {
	
	private String from;
	private String to;
	private Double exchangeRatio;

}
