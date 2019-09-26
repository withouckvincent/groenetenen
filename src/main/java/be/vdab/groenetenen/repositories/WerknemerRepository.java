package be.vdab.groenetenen.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.groenetenen.domain.Werknemer;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {

	@Override
	@EntityGraph(Werknemer.MET_FILIAAL)
	//List<Werknemer> findAll(Sort sort);
	Page<Werknemer> findAll(Pageable pageable);

}