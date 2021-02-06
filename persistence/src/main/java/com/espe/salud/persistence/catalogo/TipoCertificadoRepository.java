package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoCertificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoCertificadoRepository extends JpaRepository<TipoCertificado, Long>{
    Optional<TipoCertificado> findByCodigo(Long codigo);
    List<TipoCertificado> findAllByOrderByNombreAsc();

}
