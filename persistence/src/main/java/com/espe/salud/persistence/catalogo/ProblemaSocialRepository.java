package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.ProblemaSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProblemaSocialRepository extends JpaRepository<ProblemaSocial, Long> {
    Optional<ProblemaSocial> findByCodigo(Long codigo);

    List<ProblemaSocial> findAllByOrderByNombreAsc();
}
