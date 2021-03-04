package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.Plurinacionalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlurinacionalidadRepository extends JpaRepository<Plurinacionalidad, Long> {
    Optional<Plurinacionalidad> findByCodigo(Long codigo);

    List<Plurinacionalidad> findAllByOrderByNombreAsc();
}
