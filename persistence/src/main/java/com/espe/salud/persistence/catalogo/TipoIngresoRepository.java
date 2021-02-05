package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoIngreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoIngresoRepository extends JpaRepository<TipoIngreso, Long> {
    List<TipoIngreso> findAllByOrderByNombreAsc();
    Optional<TipoIngreso> findByCodigo(Long codigo);
}
