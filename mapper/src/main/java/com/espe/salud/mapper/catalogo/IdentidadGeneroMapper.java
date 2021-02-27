package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.IdentidadGenero;
import com.espe.salud.dto.catalogo.IdentidadGeneroDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IdentidadGeneroMapper {
    @Mapping(source = "codigo", target = "id")
    IdentidadGeneroDTO toIndentidadGeneroDTO(IdentidadGenero identidadGenero);

    @InheritInverseConfiguration
    IdentidadGenero toIdentidadGenero(IdentidadGeneroDTO dto);

    List<IdentidadGeneroDTO> toIdentidadesGeneroDTO(List<IdentidadGenero> identidades);
}
