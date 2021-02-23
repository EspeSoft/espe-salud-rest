package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoActividadEnfermeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoActividadEnfermeriaRepository extends JpaRepository<TipoActividadEnfermeria, Long> {
    Optional<TipoActividadEnfermeria> findByCodigo(Long codigo);
    List<TipoActividadEnfermeria> findAllByOrderByNombreAsc();
//    List<TipoActividadEnfermeria> findByNombreStartingWith(String nombre);
}
