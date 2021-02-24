package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEnfermedadProfesional;
import com.espe.salud.dto.ocupacional.AntecedenteEnfermedadProfesionalDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteEnfermedadProfesionalService {
    AntecedenteEnfermedadProfesionalDTO save  (AntecedenteEnfermedadProfesionalDTO antecedente);
    AntecedenteEnfermedadProfesionalDTO update(AntecedenteEnfermedadProfesionalDTO antecedente);
    Optional<AntecedenteEnfermedadProfesional> findExisting(AntecedenteEnfermedadProfesionalDTO antecedenteDTO);
    Boolean delete(Long id);
    Optional<AntecedenteEnfermedadProfesionalDTO > findByCodigo(Long codigo);
    AntecedenteEnfermedadProfesionalDTO  toDTO (AntecedenteEnfermedadProfesional antecedente);
    AntecedenteEnfermedadProfesional toEntity (AntecedenteEnfermedadProfesionalDTO dto);
    List<AntecedenteEnfermedadProfesionalDTO> findAll();
}
