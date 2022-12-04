package br.edu.infnet.appdomotica.model.repository;

import br.edu.infnet.appdomotica.model.domain.Fechadura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FechaduraRepository extends JpaRepository<Fechadura, Integer> {

    @Query("from Fechadura f where f.morador.id = :idMorador")
    Collection<Fechadura> findAll(Integer idMorador);
}
