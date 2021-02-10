package com.espe.salud.persistence.odontologia;


import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaSimple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetalleOdontogramaSimpleRepository extends JpaRepository<DetalleOdontogramaSimple, Long> {
    Optional<DetalleOdontogramaSimple> findByCodigo(Long codigo);
    List<DetalleOdontogramaSimple> findByHistoriaId(Long historiaId);
    void deleteByHistoriaId(Long historiaId);
}
