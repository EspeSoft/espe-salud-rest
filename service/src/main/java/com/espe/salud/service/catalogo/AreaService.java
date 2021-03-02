package com.espe.salud.service.catalogo;

import com.espe.salud.dto.catalogo.AreaDTO;

import java.util.List;

public interface AreaService {
    List<AreaDTO> findAll();

    List<AreaDTO> findAllByRegion(Long idRegion);

    AreaDTO findById(Long id);
}
