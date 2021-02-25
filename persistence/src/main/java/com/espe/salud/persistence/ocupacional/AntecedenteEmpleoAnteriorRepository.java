package com.espe.salud.persistence.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedenteEmpleoAnteriorRepository extends JpaRepository<AntecedenteEmpleoAnterior, Long> {
    Optional<AntecedenteEmpleoAnterior> findByCodigo(Long codigo);
    List<AntecedenteEmpleoAnterior> findByAntecedenteLaboralCodigo(Long idAntecedenteLaboral);
}
