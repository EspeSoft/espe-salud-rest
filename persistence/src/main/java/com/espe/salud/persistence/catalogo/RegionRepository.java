package com.espe.salud.persistence.catalogo;


import com.espe.salud.domain.entities.catalogo.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findAllByOrderByNombreAsc();
    Optional<Region> findByCodigo(Long codigo);

}
