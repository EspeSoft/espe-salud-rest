package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoQuimico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RiesgoQuimicoRepository extends JpaRepository<RiesgoQuimico, Long> {
    List<RiesgoQuimico> findAllByOrderByNombreAsc();

    Optional<RiesgoQuimico> findByCodigo(Long codigo);
}
