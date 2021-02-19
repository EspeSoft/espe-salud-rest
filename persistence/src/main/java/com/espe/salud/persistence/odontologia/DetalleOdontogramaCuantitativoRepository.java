package com.espe.salud.persistence.odontologia;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaCompuesto;
import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaCuantitativo;
import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaSimple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetalleOdontogramaCuantitativoRepository extends JpaRepository<DetalleOdontogramaCuantitativo, Long> {
    Optional<DetalleOdontogramaCuantitativo> findByCodigo(Long codigo);
    List<DetalleOdontogramaCuantitativo> findByHistoriaId(Long historiaId);
    Long deleteByHistoriaId(Long historiaId);
}
