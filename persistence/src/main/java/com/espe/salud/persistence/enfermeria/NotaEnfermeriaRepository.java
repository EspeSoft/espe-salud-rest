package com.espe.salud.persistence.enfermeria;

import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotaEnfermeriaRepository extends JpaRepository<NotaEnfermeria, Long> {
    Optional<NotaEnfermeria> findByCodigo(Long codigo);
    List<NotaEnfermeria> findByPacienteCodigoOrderByFechaInicio(Long pacienteCodigo);
    List<NotaEnfermeria> findByUsuarioPidmOrderByFechaInicio(Long pidm);
}
