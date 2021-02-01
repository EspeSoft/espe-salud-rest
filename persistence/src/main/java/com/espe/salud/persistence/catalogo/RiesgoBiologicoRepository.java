package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoBiologico;
import com.espe.salud.domain.entities.catalogo.RiesgoFisico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RiesgoBiologicoRepository extends JpaRepository<RiesgoBiologico, Long> {
    List<RiesgoBiologico> findAllByOrderByNombreAsc();
    Optional<RiesgoBiologico> findByCodigo(Long codigo);
}
