package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Sede;
import com.espe.salud.dto.catalogo.SedeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SedeService {
    Optional<SedeDTO> findById(Long codigo);
    List<SedeDTO> findAll();
    SedeDTO toDTO(Sede sede);
    Sede toEntity(SedeDTO dto);
}
