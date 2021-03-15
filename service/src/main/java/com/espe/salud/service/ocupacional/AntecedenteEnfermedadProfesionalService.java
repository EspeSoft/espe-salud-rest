package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.domain.entities.ocupacional.AntecedenteEnfermedadProfesional;
import com.espe.salud.dto.ocupacional.AntecedenteEnfermedadProfesionalDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteEnfermedadProfesionalService {
    AntecedenteEnfermedadProfesionalDTO save(AntecedenteEnfermedadProfesionalDTO antecedente);

    AntecedenteEnfermedadProfesionalDTO update(AntecedenteEnfermedadProfesionalDTO antecedente);

    Boolean delete(Long id);

    Optional<AntecedenteEnfermedadProfesionalDTO> findByCodigo(Long codigo);

    List<AntecedenteEnfermedadProfesionalDTO> findByPaciente(Long idPaciente);

    AntecedenteEnfermedadProfesionalDTO toDTO(AntecedenteEnfermedadProfesional antecedente);

    AntecedenteEnfermedadProfesional toEntity(AntecedenteEnfermedadProfesionalDTO dto);
}
