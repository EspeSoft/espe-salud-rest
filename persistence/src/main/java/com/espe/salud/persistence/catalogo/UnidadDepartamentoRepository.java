package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.UnidadDepartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnidadDepartamentoRepository extends JpaRepository<UnidadDepartamento, Long> {
    Optional<UnidadDepartamento> findByCodigo(Long codigo);
    List<UnidadDepartamento> findAllByOrderByNombreAsc();
}
