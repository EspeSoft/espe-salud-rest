package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.ActividadFisicaDTO;

import java.util.List;
import java.util.Optional;

public interface ActividadFisicaService {
    ActividadFisicaDTO save(ActividadFisicaDTO dto);

    ActividadFisicaDTO update(ActividadFisicaDTO dto);

    Optional<ActividadFisicaDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<ActividadFisicaDTO> findByPaciente(Long idPaciente);
}
