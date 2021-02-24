package com.espe.salud.persistence.ocupacional;

import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActividadExtralaboralRepository extends JpaRepository<ActividadExtralaboral, Long> {
    Optional<ActividadExtralaboral> findByCodigo(Long codigo);
}
