package br.edu.infnet.appdomotica.model.repository;

import br.edu.infnet.appdomotica.model.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {

    @Query("from Responsavel r where r.morador.id = :userid")
    List<Responsavel> obterLista(Integer userid);
}
