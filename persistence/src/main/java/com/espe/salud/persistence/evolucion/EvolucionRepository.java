package com.espe.salud.persistence.evolucion;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvolucionRepository extends JpaRepository<Evolucion, String> {
    Optional<Evolucion> findByCodigo(String codigo);
}
