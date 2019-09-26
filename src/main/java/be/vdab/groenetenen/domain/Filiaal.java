package be.vdab.groenetenen.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.sun.istack.NotNull;

@Entity
@Table(name = "filialen")
public class Filiaal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String naam;
	
	private boolean hoofdFiliaal;
	
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@PositiveOrZero
	@Digits(integer = 10, fraction = 2)
	private BigDecimal waardeGebouw;
	
	@DateTimeFormat(style = "S-")
	@NotNull
	private LocalDate inGebruikName;
	
	@Valid
	@Embedded
	private Adres adres;
	
	@Version
	private long versie;

	@OneToMany(mappedBy = "filiaal")
	
	private Set<Werknemer> werknemers;

	public Set<Werknemer> getWerknemers() {
		return Collections.unmodifiableSet(werknemers);
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public boolean isHoofdFiliaal() {
		return hoofdFiliaal;
	}

	public BigDecimal getWaardeGebouw() {
		return waardeGebouw;
	}

	public LocalDate getInGebruikName() {
		return inGebruikName;
	}

	public Adres getAdres() {
		return adres;
	}
	
	
	
	
	
}