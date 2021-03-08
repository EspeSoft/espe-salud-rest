package com.espe.salud.persistence.antecedente;

import com.espe.salud.domain.entities.antecedente.ActividadFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActividadFisicaRepository extends JpaRepository<ActividadFisica, Long> {
    Optional<ActividadFisica> findByCodigo(Long codigo);

    List<ActividadFisica> findByAntecedentePersonalPacienteCodigo(Long idPaciente);
}
