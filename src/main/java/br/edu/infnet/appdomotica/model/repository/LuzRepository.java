package br.edu.infnet.appdomotica.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appdomotica.model.domain.Luz;

@Repository
public interface LuzRepository extends CrudRepository<Luz, Integer> {

	@Query("from Luz l where l.morador.id = :idMorador")
	Collection<Luz> findAll(Integer idMorador);
	
}
