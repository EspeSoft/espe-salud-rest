package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoConsumoNocivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoConsumoNocivoRepository extends JpaRepository<TipoConsumoNocivo, Long> {
    Optional<TipoConsumoNocivo> findByCodigo(Long codigo);
    List<TipoConsumoNocivo> findAllByOrderByNombreAsc();
    List<TipoConsumoNocivo> findByNombreStartingWith(String nombre);
}