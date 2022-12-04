package br.edu.infnet.appdomotica.model.repository;

import br.edu.infnet.appdomotica.model.domain.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Integer> {

}
