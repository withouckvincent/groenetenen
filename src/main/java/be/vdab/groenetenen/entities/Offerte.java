package be.vdab.groenetenen.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import be.vdab.groenetenen.adapters.LocalDateAdapter;

@Entity
@Table(name = "offertes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Offerte implements Serializable {
	public interface Stap1 {
	}

	public interface Stap2 {
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Stap 1 variabelen
	
	@NotBlank(groups = Stap1.class)
	private String voornaam;
	@NotBlank(groups = Stap1.class)
	private String familienaam;
	@NotNull(groups = Stap1.class)
	@Email(groups = Stap1.class)
	private String emailAdres;
	
	// Stap 2 variabelen
	
	@NotNull(groups = Stap2.class)
	@Positive(groups = Stap2.class)
	@NumberFormat
	private Integer oppervlakte;
	
	
	@DateTimeFormat(style = "S-")
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate aangemaakt = LocalDate.now();
	
	public long getId() {
		return id;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public String getEmailAdres() {
		return emailAdres;
	}
	public Integer getOppervlakte() {
		return oppervlakte;
	}
	public LocalDate getAangemaakt() {
		return aangemaakt;
	}
	

}
