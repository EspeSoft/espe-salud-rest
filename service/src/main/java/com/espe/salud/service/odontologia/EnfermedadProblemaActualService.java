package com.espe.salud.service.odontologia;

import com.espe.salud.domain.entities.odontologia.EnfermedadProblemaActual;
import com.espe.salud.dto.odontologia.EnfermedadProblemaActualDTO;

import java.util.List;
import java.util.Optional;

public interface EnfermedadProblemaActualService {

    EnfermedadProblemaActualDTO save(EnfermedadProblemaActualDTO enfermedadProblemaActualDTO);

    boolean delete(Long id);

    EnfermedadProblemaActualDTO update(EnfermedadProblemaActualDTO enfermedadProblemaActualDTO);

    Optional<EnfermedadProblemaActualDTO> findById(Long id);

    List<EnfermedadProblemaActualDTO> findByHistoriaClinica(Long idHistoria);

    EnfermedadProblemaActualDTO toDTO(EnfermedadProblemaActual enfermedadProblemaActual);

    EnfermedadProblemaActual toEntity(EnfermedadProblemaActualDTO dto);

}
