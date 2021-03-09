package com.espe.salud.service.odontologia;

import com.espe.salud.domain.entities.odontologia.ExamenSistemaEstomatognatico;
import com.espe.salud.dto.odontologia.ExamenSistemaEstomatognaticoDTO;

import java.util.List;
import java.util.Optional;

public interface ExamenSistemaEstomatognaticoService {

    ExamenSistemaEstomatognaticoDTO save(ExamenSistemaEstomatognaticoDTO examenSistemaEstomatognaticoDTO, Long idPaciente);

    boolean delete(Long id);

    ExamenSistemaEstomatognaticoDTO update(ExamenSistemaEstomatognaticoDTO examenSistemaEstomatognaticoDTO);

    Optional<ExamenSistemaEstomatognaticoDTO> findById(Long id);

    List<ExamenSistemaEstomatognaticoDTO> findByHistoriaClinica(Long idHistoria);

    ExamenSistemaEstomatognaticoDTO toDTO(ExamenSistemaEstomatognatico examenSistemaEstomatognatico);

    ExamenSistemaEstomatognatico toEntity(ExamenSistemaEstomatognaticoDTO dto);

}
