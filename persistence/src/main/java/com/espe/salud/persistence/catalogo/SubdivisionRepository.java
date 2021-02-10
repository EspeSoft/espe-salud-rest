package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.Subdivision;
import com.espe.salud.domain.enums.TipoSubdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
    Optional<Subdivision> findByCodigo(Long codigo);
    List<Subdivision> findAllByOrderByNombreAsc();

    List<Subdivision> findByPaisCodigoAndTipoOrderByNombreAsc(Long idPais, TipoSubdivision tipo);
    List<Subdivision> findByPadreCodigoAndTipoOrderByNombreAsc(Long idPadre, TipoSubdivision tipo);
}