package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoPsicosocial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RiesgoPsicosocialRepository extends JpaRepository<RiesgoPsicosocial, Long> {
    List<RiesgoPsicosocial> findAllByOrderByNombreAsc();
    Optional<RiesgoPsicosocial> findByCodigo(Long codigo);
}
