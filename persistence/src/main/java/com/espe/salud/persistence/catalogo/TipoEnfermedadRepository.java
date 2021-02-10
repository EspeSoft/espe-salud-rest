package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoEnfermedadRepository extends JpaRepository<TipoEnfermedad, Long> {
    Optional<TipoEnfermedad> findByCodigo(Long codigo);
}