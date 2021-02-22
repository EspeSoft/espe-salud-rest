package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudioComplementarioRepository extends JpaRepository<EstudioComplementario, Long> {
    Optional<EstudioComplementario> findByCodigo(Long codigo);
    List<EstudioComplementario> findByPacienteCodigoOrderByFechaEstudioDesc(Long idPaciente);
}
