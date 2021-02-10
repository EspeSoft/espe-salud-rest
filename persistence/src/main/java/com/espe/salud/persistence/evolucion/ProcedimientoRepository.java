package com.espe.salud.persistence.evolucion;

import com.espe.salud.domain.entities.evolucion.Procedimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProcedimientoRepository extends JpaRepository<Procedimiento , Long> {
    Optional<Procedimiento> findByCodigo(Long codigo);
    List<Procedimiento> findAllByCodigo(Long codigo);
}
