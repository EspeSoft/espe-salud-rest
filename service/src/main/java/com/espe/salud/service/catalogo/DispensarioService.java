package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.dto.catalogo.DispensarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DispensarioService {
    Optional<DispensarioDTO> findById(Long codigo);
    List<DispensarioDTO> findAll();
    DispensarioDTO toDTO(Dispensario dispensario);
    Dispensario toEntity(DispensarioDTO dto);
}
