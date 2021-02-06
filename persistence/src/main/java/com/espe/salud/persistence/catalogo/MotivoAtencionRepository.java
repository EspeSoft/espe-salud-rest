package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.MotivoAtencion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MotivoAtencionRepository extends JpaRepository<MotivoAtencion, Long> {
    List<MotivoAtencion> findAllByOrderByNombreAsc();
    Optional<MotivoAtencion> findByCodigo(Long codigo);
}
