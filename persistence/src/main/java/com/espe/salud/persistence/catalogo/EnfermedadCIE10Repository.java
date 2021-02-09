package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnfermedadCIE10Repository extends JpaRepository<EnfermedadCIE10, Long> {
    Optional<EnfermedadCIE10> findByCodigo(Long codigo);
    List<EnfermedadCIE10> findAllByOrderByNombreAsc();
}
