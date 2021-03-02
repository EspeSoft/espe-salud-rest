package com.espe.salud.persistence.evolucion;

import com.espe.salud.domain.entities.evolucion.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {

    Optional<Diagnostico> findByCodigo(Long codigo);

    List<Diagnostico> findAllByCodigo(Long codigo);
}
