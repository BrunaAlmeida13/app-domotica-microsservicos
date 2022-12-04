package br.edu.infnet.appdomotica.model.repository;

import br.edu.infnet.appdomotica.model.domain.Luz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LuzRepository extends JpaRepository<Luz, Integer> {

    @Query("from Luz l where l.morador.id = :idMorador")
    Collection<Luz> findAll(Integer idMorador);
}
