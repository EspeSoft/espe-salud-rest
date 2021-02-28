package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoDetalleExamenLaboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoDetalleExamenLaboratorioRepository extends JpaRepository<TipoDetalleExamenLaboratorio, Long> {
    Optional<TipoDetalleExamenLaboratorio> findByCodigo(Long codigo);
    List<TipoDetalleExamenLaboratorio> findAllByOrderByNombreAsc();
}
