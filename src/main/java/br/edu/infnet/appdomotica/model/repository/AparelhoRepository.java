package br.edu.infnet.appdomotica.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appdomotica.model.domain.Aparelho;

@Repository
public interface AparelhoRepository extends CrudRepository<Aparelho, Integer> {

	@Query("from Aparelho ap where ap.morador.id = :idMorador")
	Collection<Aparelho> findAll(Integer idMorador);
}
