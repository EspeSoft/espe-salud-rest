package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.EstudioComplementario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudioComplementarioRepository extends JpaRepository<EstudioComplementario, Long> {
    Optional<EstudioComplementario> findByCodigo(Long codigo);
}
