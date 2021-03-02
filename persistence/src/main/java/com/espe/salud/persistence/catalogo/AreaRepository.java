package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findAllByOrderByNombreAsc();
    Optional<Area> findByCodigo(Long codigo);
    List<Area> findByRegionCodigo(Long idRegion);
}
