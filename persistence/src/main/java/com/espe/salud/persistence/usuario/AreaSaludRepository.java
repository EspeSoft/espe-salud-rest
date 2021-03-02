package com.espe.salud.persistence.usuario;

import com.espe.salud.domain.entities.usuario.AreaSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaSaludRepository extends JpaRepository<AreaSalud, Long> {
    Optional<AreaSalud> findByCodigo(Long pidm);
    List<AreaSalud> findAllByOrderByNombreAsc();
}
