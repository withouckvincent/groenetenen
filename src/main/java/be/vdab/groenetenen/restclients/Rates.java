package be.vdab.groenetenen.restclients;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Rates {
	
	@JsonProperty("USD") 
	private BigDecimal usd;

	public BigDecimal getUsd() {
		return usd;
	}
	
	

}
