package be.vdab.groenetenen.services;

import java.util.List;

import be.vdab.groenetenen.domain.Filiaal;

public interface FiliaalService {
	List<Filiaal> findByPostcode(int van, int tot);
}
