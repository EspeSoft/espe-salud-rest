package com.espe.salud.persistence.paciente;

import com.espe.salud.domain.entities.paciente.RecordLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordLaboralRepository extends JpaRepository<RecordLaboral, Long> {
    Optional<RecordLaboral> findByCodigo(Long codigo);

    List<RecordLaboral> findAllByCodigo(Long codigo);
}
