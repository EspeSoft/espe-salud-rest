package com.espe.salud.persistence.catalogo;


import com.espe.salud.domain.entities.catalogo.DescripcionActividadEnfermeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DescripcionActividadEnfermeriaRepository extends JpaRepository<DescripcionActividadEnfermeria, Long> {
    Optional<DescripcionActividadEnfermeria> findByCodigo(Long codigo);

    List<DescripcionActividadEnfermeria> findAllByOrderByNombreAsc();
}
