package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.NivelInstruccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NivelInstruccionRepository extends JpaRepository<NivelInstruccion, Long> {
    Optional<NivelInstruccion> findByCodigo(Long codigo);
    List<NivelInstruccion> findAllByOrderByNombreAsc();
}
