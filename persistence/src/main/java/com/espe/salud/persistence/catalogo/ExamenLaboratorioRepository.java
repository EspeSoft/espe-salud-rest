package com.espe.salud.persistence.catalogo;

import com.espe.salud.domain.entities.catalogo.ExamenLaboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamenLaboratorioRepository extends JpaRepository<ExamenLaboratorio, Long> {
    Optional<ExamenLaboratorio> findByCodigo(Long codigo);
}
