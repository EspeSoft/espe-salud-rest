package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.IdentidadGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IdentidadGeneroRepository extends JpaRepository<IdentidadGenero, Long> {
    List<IdentidadGenero> findAllByOrderByNombreAsc();
    Optional<IdentidadGenero> findByCodigo(Long codigo);
}
