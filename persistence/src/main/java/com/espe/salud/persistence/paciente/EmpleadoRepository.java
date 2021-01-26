package com.espe.salud.persistence.paciente;

import com.espe.salud.domain.entities.paciente.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
