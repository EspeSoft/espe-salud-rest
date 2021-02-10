package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.CodigoCIE10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodigoCIE10Repository extends JpaRepository<CodigoCIE10, Long> {
    Optional<CodigoCIE10> findByCodigo(Long codigo);
    List<CodigoCIE10> findAllByOrderByNombreAsc();
}
