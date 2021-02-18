package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoCultural;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupoCulturalRepository extends JpaRepository<GrupoCultural,Long> {

    Optional<GrupoCultural> findByCodigo(Long codigo);
}
