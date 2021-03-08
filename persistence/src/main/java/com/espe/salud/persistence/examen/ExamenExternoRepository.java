package com.espe.salud.persistence.examen;

import com.espe.salud.domain.entities.examen.ExamenExterno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamenExternoRepository extends JpaRepository<ExamenExterno, Long> {
    Optional<ExamenExterno> findByCodigo(Long codigo);

    List<ExamenExterno> findByPacienteCodigo(Long idPaciente);
}
