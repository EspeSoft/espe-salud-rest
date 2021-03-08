package com.espe.salud.persistence.evolucion;

import com.espe.salud.domain.entities.evolucion.Reposo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReposoRepository extends JpaRepository<Reposo, Long> {
    Optional<Reposo> findByCodigo(Long codigo);
    List<Reposo> findAllByCodigo(Long codigo);
}
