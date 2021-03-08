package com.espe.salud.persistence.enfermeria;

import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActividadEnfermeriaRepository extends JpaRepository<ActividadEnfermeria, Long> {

    Optional<ActividadEnfermeria> findByCodigo(Long codigo);

    List<ActividadEnfermeria> findByUsuarioPidm(Long pidm);
}
