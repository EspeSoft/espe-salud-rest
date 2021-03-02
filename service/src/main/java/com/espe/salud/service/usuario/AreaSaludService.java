package com.espe.salud.service.usuario;


import com.espe.salud.domain.entities.usuario.AreaSalud;
import com.espe.salud.dto.usuario.AreaSaludDTO;

import java.util.List;
import java.util.Optional;

public interface AreaSaludService {
    Optional<AreaSaludDTO> findById(Long id);
    AreaSaludDTO save(AreaSaludDTO areaSaludDTO);
    List<AreaSaludDTO> findAll();
    boolean delete(Long id);

    AreaSaludDTO toDTO(AreaSalud areaSalud);
    AreaSalud toEntity(AreaSaludDTO dto);
}
