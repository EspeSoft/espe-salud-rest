package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Subdivision;
import com.espe.salud.dto.catalogo.SubdivisionDTO;

import java.util.List;
import java.util.Optional;

public interface SubdivisionService {
    Optional<SubdivisionDTO> findById(Long id);

    List<SubdivisionDTO> findAll();

    List<SubdivisionDTO> getProvincias(Long idPais);

    List<SubdivisionDTO> getCantones(Long idPais);

    List<SubdivisionDTO> getCantonesByProvincia(Long idPadre);

    SubdivisionDTO toDTO(Subdivision subdivision);

}
