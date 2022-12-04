package br.edu.infnet.appdomotica.model.repository;

import br.edu.infnet.appdomotica.model.domain.ArCondicionado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ArCondicionadoRepository extends JpaRepository<ArCondicionado, Integer> {

    @Query("from ArCondicionado ac where ac.morador.id = :idMorador")
    Collection<ArCondicionado> findAll(Integer idMorador);
}
