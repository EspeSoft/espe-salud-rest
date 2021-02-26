package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AntecedentePersonalRepository extends JpaRepository<AntecedentePersonal, Long> {
    Optional<AntecedentePersonal> findByCodigo(Long codigo);
    Optional<AntecedentePersonal> findByPacienteCodigo(Long idPaciente);
}
