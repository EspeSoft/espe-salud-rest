package com.espe.salud.persistence.paciente;

import com.espe.salud.domain.entities.paciente.RecordLaboral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordLaboralRepository extends JpaRepository<RecordLaboral, Long> {
    Optional<RecordLaboral> findByCodigo(Long codigo);
}
