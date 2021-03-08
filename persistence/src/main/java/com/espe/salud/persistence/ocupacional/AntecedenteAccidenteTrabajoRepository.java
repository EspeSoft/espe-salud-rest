package com.espe.salud.persistence.ocupacional;

import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AntecedenteAccidenteTrabajoRepository extends JpaRepository<AntecedenteAccidenteTrabajo, Long> {
    Optional<AntecedenteAccidenteTrabajo> findByCodigo(Long codigo);

    List<AntecedenteAccidenteTrabajo> findByAntecedenteLaboralCodigo(Long idAntecedenteLaboralr);
}
