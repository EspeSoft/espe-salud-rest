package com.espe.salud.persistence.examen;

import com.espe.salud.domain.entities.examen.ExamenInterno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamenInternoRepository extends JpaRepository<ExamenInterno, Long> {
    Optional<ExamenInterno> findByCodigo(Long codigo);
    List<ExamenInterno> findByPacienteCodigo(Long idPaciente);
}
