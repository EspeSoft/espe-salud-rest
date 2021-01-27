package com.espe.salud.persistence.paciente;

import com.espe.salud.domain.entities.paciente.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByCodigo(Long codigo);
}
