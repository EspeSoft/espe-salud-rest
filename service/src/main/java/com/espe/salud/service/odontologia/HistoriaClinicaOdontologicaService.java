package com.espe.salud.service.odontologia;

import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import com.espe.salud.dto.odontologia.HistoriaClinicaOdontologicaDTO;

import java.util.List;
import java.util.Optional;

public interface HistoriaClinicaOdontologicaService {

    HistoriaClinicaOdontologicaDTO save(HistoriaClinicaOdontologicaDTO historiaClinicaOdontologicaDTO, Long idPaciente);

    boolean delete(Long id);

    HistoriaClinicaOdontologicaDTO update(HistoriaClinicaOdontologicaDTO historiaClinicaOdontologicaDTO);

    List<HistoriaClinicaOdontologicaDTO> findAll();

    Optional<HistoriaClinicaOdontologicaDTO> findByPaciente(Long idPaciente);

    Optional<HistoriaClinicaOdontologicaDTO> findById(Long idPaciente);

    HistoriaClinicaOdontologicaDTO toDTO(HistoriaClinicaOdontologica historiaClinicaOdontologica);

    HistoriaClinicaOdontologica toEntity(HistoriaClinicaOdontologicaDTO dto);

}
