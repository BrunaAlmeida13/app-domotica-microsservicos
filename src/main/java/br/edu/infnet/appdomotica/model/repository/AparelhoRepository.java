package br.edu.infnet.appdomotica.model.repository;

import br.edu.infnet.appdomotica.model.domain.Aparelho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AparelhoRepository extends JpaRepository<Aparelho, Integer> {

    @Query("from Aparelho ap where ap.morador.id = :idMorador")
    Collection<Aparelho> findAll(Integer idMorador);
}
