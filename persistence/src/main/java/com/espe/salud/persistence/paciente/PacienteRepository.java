package com.espe.salud.persistence.paciente;

import com.espe.salud.domain.entities.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByCodigo(Long codigo);
    List<Paciente> findAllByCodigo(Long codigo);
}
