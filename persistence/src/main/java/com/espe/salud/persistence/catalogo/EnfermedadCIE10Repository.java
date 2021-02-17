package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnfermedadCIE10Repository extends JpaRepository<EnfermedadCIE10, String> {
    Optional<EnfermedadCIE10> findByCodigo(String codigo);
    List<EnfermedadCIE10> findAllByOrderByNombreAsc();
    List<EnfermedadCIE10> findByCodigoStartingWithOrNombreStartingWith(String codigo, String nombre);
}
