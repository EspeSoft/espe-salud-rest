package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.PlanificacionFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanificacionFamiliarRepository extends JpaRepository<PlanificacionFamiliar, Long> {
    Optional<PlanificacionFamiliar> findByCodigo(Long codigo);
    List<PlanificacionFamiliar> findByAntecedentePersonalPacienteCodigo(Long idPaciente);
}