package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.RelacionEspe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelacionEspeRepository extends JpaRepository<RelacionEspe, Long> {
    List<RelacionEspe> findAllByOrderByNombreAsc();

    Optional<RelacionEspe> findByCodigo(Long codigo);
}
