package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoExamenSexual;
import com.espe.salud.domain.enums.SexoTipoPlanificacionFamiliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoExamenSexualRepository extends JpaRepository<TipoExamenSexual, Long> {
    Optional<TipoExamenSexual> findByCodigo(Long codigo);

    List<TipoExamenSexual> findAllByOrderByNombreAsc();

    List<TipoExamenSexual> findBySexoOrSexoOrderByNombreAsc(SexoTipoPlanificacionFamiliar ambos, SexoTipoPlanificacionFamiliar sexo);

}
