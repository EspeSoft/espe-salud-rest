package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoErgonomico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RiesgoErgonomicoRepository extends JpaRepository<RiesgoErgonomico, Long> {
    List<RiesgoErgonomico> findAllByOrderByNombreAsc();
    Optional<RiesgoErgonomico> findByCodigo(Long codigo);
    
}
