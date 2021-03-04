package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.ConsumoNocivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumoNocivoRepository extends JpaRepository<ConsumoNocivo, Long> {
    Optional<ConsumoNocivo> findByCodigo(Long codigo);

    List<ConsumoNocivo> findAllByCodigo(Long codigo);
}
