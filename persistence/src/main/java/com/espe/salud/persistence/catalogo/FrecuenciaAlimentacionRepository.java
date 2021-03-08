package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.FrecuenciaAlimentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FrecuenciaAlimentacionRepository extends JpaRepository<FrecuenciaAlimentacion, Long> {
    List<FrecuenciaAlimentacion> findAllByOrderByNombreAsc();

    Optional<FrecuenciaAlimentacion> findByCodigo(Long codigo);
}
