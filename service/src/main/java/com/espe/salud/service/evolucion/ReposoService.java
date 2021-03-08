package com.espe.salud.service.evolucion;


import com.espe.salud.domain.entities.evolucion.Reposo;
import com.espe.salud.dto.evolucion.ReposoDTO;

import java.util.List;
import java.util.Optional;

public interface ReposoService {
    ReposoDTO save(ReposoDTO dto);

    ReposoDTO update(ReposoDTO dto);

    Optional<Reposo> findExisting(ReposoDTO dto);

    Boolean delete(Long id);

    Optional<ReposoDTO> findById(Long id);

    ReposoDTO toDTO(Reposo reposo);

    Reposo toEntity(ReposoDTO dto);

    List<ReposoDTO> findAll();
}
