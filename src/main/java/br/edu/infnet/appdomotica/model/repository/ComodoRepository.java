package br.edu.infnet.appdomotica.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appdomotica.model.domain.Comodo;

@Repository
public interface ComodoRepository extends CrudRepository<Comodo, Integer> {

	@Query("from Comodo c where c.morador.id = :idMorador")
	Collection<Comodo> findAll(Integer idMorador);
}
