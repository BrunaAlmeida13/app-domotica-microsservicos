package br.edu.infnet.appdomotica.model.repository;

import br.edu.infnet.appdomotica.model.domain.Comodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ComodoRepository extends JpaRepository<Comodo, Integer> {

    @Query("from Comodo c where c.morador.id = :idMorador")
    Collection<Comodo> findAll(Integer idMorador);
}
