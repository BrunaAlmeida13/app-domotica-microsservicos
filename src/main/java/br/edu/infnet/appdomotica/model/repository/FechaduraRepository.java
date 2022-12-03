package br.edu.infnet.appdomotica.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appdomotica.model.domain.Fechadura;

@Repository
public interface FechaduraRepository extends CrudRepository<Fechadura, Integer> {

	@Query("from Fechadura f where f.morador.id = :idMorador")
	Collection<Fechadura> findAll(Integer idMorador);
}
