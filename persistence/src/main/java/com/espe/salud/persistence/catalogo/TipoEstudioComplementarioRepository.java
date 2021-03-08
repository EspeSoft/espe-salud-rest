package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEstudioComplementario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoEstudioComplementarioRepository extends JpaRepository<TipoEstudioComplementario, Long> {
    List<TipoEstudioComplementario> findAllByOrderByNombreAsc();

    Optional<TipoEstudioComplementario> findByCodigo(Long codigo);
}
