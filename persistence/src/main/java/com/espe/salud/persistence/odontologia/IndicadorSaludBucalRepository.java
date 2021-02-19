package com.espe.salud.persistence.odontologia;

import com.espe.salud.domain.entities.odontologia.IndicadorSaludBucal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IndicadorSaludBucalRepository extends JpaRepository<IndicadorSaludBucal, Long> {

    Optional<IndicadorSaludBucal> findByCodigo(Long codigo);

    List<IndicadorSaludBucal> findByHistoriaCodigo(Long idHistoria);

}
