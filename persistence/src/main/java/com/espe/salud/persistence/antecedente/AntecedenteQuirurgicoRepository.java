package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteQuirurgico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AntecedenteQuirurgicoRepository extends JpaRepository<AntecedenteQuirurgico,Long> {
    Optional<AntecedenteQuirurgico> findByCodigo(Long codigo);
}