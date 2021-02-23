package com.espe.salud.persistence.odontologia;

import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoriaClinicaOdontologicaRepository extends JpaRepository<HistoriaClinicaOdontologica, Long> {

    Optional<HistoriaClinicaOdontologica> findByCodigo(Long codigo);

    HistoriaClinicaOdontologica findByPacienteCodigo(Long idPaciente);

}
