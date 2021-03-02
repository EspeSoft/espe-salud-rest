package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoFisico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RiesgoFisicoRepository extends JpaRepository<RiesgoFisico, Long> {
    List<RiesgoFisico> findAllByOrderByNombreAsc();

    Optional<RiesgoFisico> findByCodigo(Long codigo);
}
