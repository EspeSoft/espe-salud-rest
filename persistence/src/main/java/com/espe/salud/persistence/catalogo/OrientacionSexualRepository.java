package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.OrientacionSexual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrientacionSexualRepository extends JpaRepository<OrientacionSexual, Long> {
    List<OrientacionSexual> findAllByOrderByNombreAsc();

    Optional<OrientacionSexual> findByCodigo(Long codigo);
}
