package com.espe.salud.mapper.catalogo;


import com.espe.salud.domain.entities.catalogo.EstudioComplementario;
import com.espe.salud.dto.catalogo.EstudioComplementarioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudioComplementarioMapper {

    @Mapping(source = "codigo", target = "id")
    EstudioComplementarioDTO toEstudioComplementarioDTO(EstudioComplementario estudioComplementario);

    List<EstudioComplementarioDTO> toEstudioComplementarioDTO(List<EstudioComplementario> estudiosComplementarios);

    @InheritInverseConfiguration
    EstudioComplementario toEstudioComplementario(EstudioComplementarioDTO dto);
}
