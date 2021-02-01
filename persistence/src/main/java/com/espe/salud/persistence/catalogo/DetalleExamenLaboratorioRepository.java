package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.DetalleExamenLaboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleExamenLaboratorioRepository extends JpaRepository<DetalleExamenLaboratorio, Long> {
    Optional<DetalleExamenLaboratorio> findByCodigo(Long codigo);
}
