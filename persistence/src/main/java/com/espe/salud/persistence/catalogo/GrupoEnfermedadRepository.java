package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoEnfermedadRepository extends JpaRepository<GrupoEnfermedad, String> {
    Optional<GrupoEnfermedad> findByCodigo(String codigo);

    List<GrupoEnfermedad> findAllByOrderByNombreAsc();
}
