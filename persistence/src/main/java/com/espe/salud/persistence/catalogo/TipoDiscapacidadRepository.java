package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoDiscapacidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoDiscapacidadRepository extends JpaRepository<TipoDiscapacidad, Long> {
    Optional<TipoDiscapacidad> findByCodigo(Long codigo);
    List<TipoDiscapacidad> findAllByOrderByNombreAsc();
}
