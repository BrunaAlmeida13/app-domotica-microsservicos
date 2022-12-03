package br.edu.infnet.appdomotica.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appdomotica.model.domain.ArCondicionado;

@Repository
public interface ArCondicionadoRepository extends CrudRepository<ArCondicionado, Integer> {

	@Query("from ArCondicionado ac where ac.morador.id = :idMorador")
	Collection<ArCondicionado> findAll(Integer idMorador);
}
