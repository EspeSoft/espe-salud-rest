package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoPlanificacionFamiliar;
import com.espe.salud.domain.enums.SexoTipoPlanificacionFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoPlanificacionFamiliarRepository extends JpaRepository<TipoPlanificacionFamiliar, Long> {
    List<TipoPlanificacionFamiliar> findAllByOrderByNombreAsc();
    Optional<TipoPlanificacionFamiliar> findByCodigo(Long codigo);
    List<TipoPlanificacionFamiliar> findBySexoOrSexoOrderByNombreAsc(SexoTipoPlanificacionFamiliar ambos, SexoTipoPlanificacionFamiliar sexo);
}
