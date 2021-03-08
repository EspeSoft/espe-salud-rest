package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.RelacionEspe;
import com.espe.salud.dto.catalogo.RelacionEspeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RelacionEspeMapper {
    @Mapping(source = "codigo", target = "id")
    RelacionEspeDTO toRelacionEspeDTO(RelacionEspe relacionEspe);

    @InheritInverseConfiguration
    RelacionEspe toRelacionEspe(RelacionEspeDTO dto);

    List<RelacionEspeDTO> toRelacionesEspe(List<RelacionEspe> relacionesEspe);
}
