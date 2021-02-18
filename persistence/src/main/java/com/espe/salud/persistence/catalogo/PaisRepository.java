package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    Optional<Pais> findByCodigo(Long codigo);
    List<Pais> findAllByOrderByNombreAsc();
}