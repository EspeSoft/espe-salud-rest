package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteGinecologico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AntecedenteGinecologicoRepository extends JpaRepository<AntecedenteGinecologico,Long> {
    Optional<AntecedenteGinecologico> findByCodigo(Long codigo);
}