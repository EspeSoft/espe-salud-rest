package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.ActividadFisica;
import com.espe.salud.dto.antecedente.ActividadFisicaDTO;

import java.util.List;
import java.util.Optional;

public interface ActividadFisicaService {
    ActividadFisicaDTO save(ActividadFisicaDTO actividadFisica);
    ActividadFisicaDTO update(ActividadFisicaDTO actividadFisica);
    Optional<ActividadFisica> findExisting(ActividadFisicaDTO actividadFisicaDTO);
    Boolean delete(Long id);
    Optional<ActividadFisicaDTO> findByCodigo(Long codigo);
    ActividadFisicaDTO toDTO(ActividadFisica actividadFisica);
    ActividadFisica toEntity(ActividadFisicaDTO dto);
    List<ActividadFisicaDTO> findAll();
}
