package com.espe.salud.persistence.odontologia;

import com.espe.salud.domain.entities.odontologia.EnfermedadProblemaActual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnfermedadProblemaActualRepository extends JpaRepository<EnfermedadProblemaActual, Long> {

    Optional<EnfermedadProblemaActual> findByCodigo(Long codigo);

    List<EnfermedadProblemaActual> findByHistoriaId(Long idHistoria);

}
