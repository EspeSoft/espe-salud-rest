package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.Discapacidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscapacidadRepository extends JpaRepository<Discapacidad, Long> {
    Optional<Discapacidad> findByCodigo(Long codigo);
}