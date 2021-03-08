package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoExamenLaboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoExamenLaboratorioRepository extends JpaRepository<TipoExamenLaboratorio, Long> {
    Optional<TipoExamenLaboratorio> findByCodigo(Long codigo);

    List<TipoExamenLaboratorio> findAllByOrderByNombreAsc();

}
