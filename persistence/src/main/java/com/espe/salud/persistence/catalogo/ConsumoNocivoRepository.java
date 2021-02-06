package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.ConsumoNocivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumoNocivoRepository extends JpaRepository<ConsumoNocivo, Long> {
    Optional<ConsumoNocivo> findByCodigo(Long codigo);
}