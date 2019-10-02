package be.vdab.groenetenen.restservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import be.vdab.groenetenen.domain.Filiaal;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
class FiliaalIdNaam {
	@XmlAttribute
	private long id;
	@XmlAttribute
	private String naam;

	FiliaalIdNaam() {
	} // JAXB heeft een default constructor nodig

	FiliaalIdNaam(Filiaal filiaal) {
		this.id = filiaal.getId();
		this.naam = filiaal.getNaam();
	}
}
