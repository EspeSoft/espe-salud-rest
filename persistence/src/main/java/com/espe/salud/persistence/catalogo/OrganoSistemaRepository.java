package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.OrganoSistema;
import com.espe.salud.domain.entities.catalogo.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganoSistemaRepository extends JpaRepository<OrganoSistema, Long>{
    List<OrganoSistema> findAllByOrderByNombreAsc();
    Optional<OrganoSistema> findByCodigo(Long codigo);
}
