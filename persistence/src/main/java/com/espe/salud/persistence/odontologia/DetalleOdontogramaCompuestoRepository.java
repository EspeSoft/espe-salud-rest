package com.espe.salud.persistence.odontologia;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaCompuesto;
import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaSimple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetalleOdontogramaCompuestoRepository extends JpaRepository<DetalleOdontogramaCompuesto, Long> {
    Optional<DetalleOdontogramaCompuesto> findByCodigo(Long codigo);
    List<DetalleOdontogramaCompuesto> findByHistoriaId(Long historiaId);


    Long deleteByHistoriaId(Long historiaId);
}
