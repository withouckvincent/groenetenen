package be.vdab.groenetenen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.groenetenen.domain.Filiaal;

public interface FiliaalRepository extends JpaRepository<Filiaal, Long> {
	List<Filiaal> findByAdresPostcodeBetweenOrderByAdresPostcode(int van, int tot);
}