package com.espe.salud.persistence.ocupacional;

import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRiesgoPuestoActualRepository extends JpaRepository<FactorRiesgoPuestoActual, Long> {
    Optional<FactorRiesgoPuestoActual> findByCodigo(Long codigo);
}
