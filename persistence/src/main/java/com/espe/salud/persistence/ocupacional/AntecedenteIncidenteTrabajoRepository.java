package com.espe.salud.persistence.ocupacional;

import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import com.espe.salud.domain.entities.ocupacional.AntecedenteIncidenteTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedenteIncidenteTrabajoRepository extends JpaRepository<AntecedenteIncidenteTrabajo, Long> {
    Optional<AntecedenteIncidenteTrabajo> findByCodigo(Long codigo);
    List<AntecedenteIncidenteTrabajo> findByAntecedenteLaboralCodigo(Long idAntecedenteLaboral);
}
