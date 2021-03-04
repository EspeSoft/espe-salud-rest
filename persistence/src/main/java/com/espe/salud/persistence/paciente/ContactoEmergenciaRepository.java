package com.espe.salud.persistence.paciente;

import com.espe.salud.domain.entities.paciente.ContactoEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactoEmergenciaRepository extends JpaRepository<ContactoEmergencia, Long> {
    Optional<ContactoEmergencia> findByCodigo(Long codigo);
    List<ContactoEmergencia> findByPersonaPacienteCodigo(Long codigo);
}
