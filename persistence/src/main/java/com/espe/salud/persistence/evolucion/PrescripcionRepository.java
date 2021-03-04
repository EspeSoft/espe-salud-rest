package com.espe.salud.persistence.evolucion;

import com.espe.salud.domain.entities.evolucion.Prescripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrescripcionRepository extends JpaRepository<Prescripcion, Long> {
    Optional<Prescripcion> findByCodigo(Long id);
    List<Prescripcion> findByEvolucionCodigo(String id);
}
