package be.vdab.groenetenen.restclients;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
class USDRate {
	private Rates rates;

	public Rates getRates() {
		return rates;
	}
	
	
}
