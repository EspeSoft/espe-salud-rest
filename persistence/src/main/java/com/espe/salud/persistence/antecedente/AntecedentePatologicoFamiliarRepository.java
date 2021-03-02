package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AntecedentePatologicoFamiliarRepository extends JpaRepository<AntecedentePatologicoFamiliar, Long> {
    Optional<AntecedentePatologicoFamiliar> findByCodigo(Long codigo);
}