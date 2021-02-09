package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoProcedimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoProcedimientoRepository extends JpaRepository<TipoProcedimiento, Long> {

    Optional<TipoProcedimiento> findByCodigo(Long codigo);
}
