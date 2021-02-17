package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.ExamenSexual;
import com.espe.salud.dto.antecedente.ExamenSexualDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ExamenSexualService {

    ExamenSexualDTO save(ExamenSexualDTO examenSexualDTO);
    ExamenSexualDTO update(ExamenSexualDTO examenSexualDTO);
    Optional<ExamenSexualDTO> findById(Long codigo);
    List<ExamenSexualDTO> findAll();
    boolean deleteById(Long id);
    ExamenSexualDTO toDTO(ExamenSexual examenSexual);
    ExamenSexual toEntity(ExamenSexualDTO dto);
    
}
