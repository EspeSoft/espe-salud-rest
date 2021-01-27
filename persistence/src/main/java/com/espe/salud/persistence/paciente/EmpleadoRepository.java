package com.espe.salud.persistence.paciente;

import com.espe.salud.domain.entities.paciente.Empleado;
import com.espe.salud.domain.entities.paciente.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByCodigo(Long codigo);
}
