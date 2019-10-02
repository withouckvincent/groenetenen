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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sun.istack.NotNull;

import be.vdab.groenetenen.adapters.LocalDateAdapter;

@Entity
@Table(name = "filialen")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
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
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate inGebruikName;
	
	@Valid
	@Embedded
	private Adres adres;
	
	@Version
	private long versie;

	@OneToMany(mappedBy = "filiaal")
	@XmlTransient
	@JsonIgnore
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