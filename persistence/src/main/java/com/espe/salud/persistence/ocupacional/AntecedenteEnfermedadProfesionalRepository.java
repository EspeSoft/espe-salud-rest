package com.espe.salud.persistence.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEnfermedadProfesional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AntecedenteEnfermedadProfesionalRepository extends JpaRepository<AntecedenteEnfermedadProfesional, Long> {
    Optional<AntecedenteEnfermedadProfesional> findByCodigo(Long codigo);
}
