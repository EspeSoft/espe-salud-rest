package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoMecanico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RiesgoMecanicoRepository extends JpaRepository<RiesgoMecanico, Long> {
    List<RiesgoMecanico> findAllByOrderByNombreAsc();

    Optional<RiesgoMecanico> findByCodigo(Long codigo);
}
