package com.espe.salud.persistence.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteLaboral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AntecedenteLaboralRepository extends JpaRepository<AntecedenteLaboral, Long> {
    Optional<AntecedenteLaboral> findByCodigo(Long codigo);
}
