package com.espe.salud.service.odontologia;


import com.espe.salud.domain.entities.odontologia.IndicadorSaludBucal;
import com.espe.salud.dto.odontologia.IndicadorSaludBucalDTO;

import java.util.List;
import java.util.Optional;

public interface IndicadorSaludBucalService {

    IndicadorSaludBucalDTO save(IndicadorSaludBucalDTO indicadorSaludBucalDTO);

    boolean delete(Long id);

    IndicadorSaludBucalDTO update(IndicadorSaludBucalDTO indicadorSaludBucalDTO);

    Optional<IndicadorSaludBucalDTO> findById(Long id);

    List<IndicadorSaludBucalDTO> findByHistoriaClinica(Long idHistoria);

    IndicadorSaludBucalDTO toDTO(IndicadorSaludBucal indicadorSaludBucal);

    IndicadorSaludBucal toEntity(IndicadorSaludBucalDTO dto);


}
