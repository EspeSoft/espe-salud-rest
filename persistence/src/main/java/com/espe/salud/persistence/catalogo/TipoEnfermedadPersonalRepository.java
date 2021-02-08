package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEnfermedadPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoEnfermedadPersonalRepository extends JpaRepository<TipoEnfermedadPersonal, Long> {
    Optional<TipoEnfermedadPersonal> findByCodigo(Long codigo);
}
