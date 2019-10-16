package be.vdab.groenetenen.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import be.vdab.groenetenen.constraints.Postcode;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	private String straat;
	@NotBlank
	private String huisNr;
	@NotNull
	//@Range(min = 1000, max = 9999)
	@Postcode
	private int postcode;
	@NotBlank
	private String gemeente;

	
	public String getStraat() {
		return straat;
	}
	public String getHuisNr() {
		return huisNr;
	}
	public int getPostcode() {
		return postcode;
	}
	public String getGemeente() {
		return gemeente;
	}
	
}