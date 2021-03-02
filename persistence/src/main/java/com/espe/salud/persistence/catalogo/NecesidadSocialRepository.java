package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.NecesidadSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NecesidadSocialRepository extends JpaRepository<NecesidadSocial, Long> {
    List<NecesidadSocial> findAllByOrderByNombreAsc();

    Optional<NecesidadSocial> findByCodigo(Long codigo);
}
