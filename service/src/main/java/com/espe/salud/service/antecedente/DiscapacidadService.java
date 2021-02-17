package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.Discapacidad;
import com.espe.salud.dto.antecedente.DiscapacidadDTO;

import java.util.List;
import java.util.Optional;

public interface DiscapacidadService {
    DiscapacidadDTO save(DiscapacidadDTO discapacidadDTO);
    DiscapacidadDTO update(DiscapacidadDTO discapacidadDTO);
    Optional<DiscapacidadDTO> findById(Long codigo);
    List<DiscapacidadDTO> findAll();
    boolean deleteById(Long id);
    DiscapacidadDTO toDTO(Discapacidad discapacidad);
    Discapacidad toEntity(DiscapacidadDTO dto);
}
