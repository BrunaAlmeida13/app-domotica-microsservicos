package br.edu.infnet.appdomotica.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appdomotica.model.domain.Morador;

@Repository
public interface MoradorRepository extends CrudRepository<Morador, Integer> {

}
