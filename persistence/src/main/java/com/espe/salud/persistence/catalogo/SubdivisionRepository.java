package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
    Optional<Subdivision> findByCodigo(Long codigo);
}