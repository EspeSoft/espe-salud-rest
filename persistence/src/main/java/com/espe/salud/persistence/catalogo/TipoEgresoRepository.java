package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEgreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoEgresoRepository extends JpaRepository<TipoEgreso, Long> {
    List<TipoEgreso> findAllByOrderByNombreAsc();

    Optional<TipoEgreso> findByCodigo(Long codigo);
}
