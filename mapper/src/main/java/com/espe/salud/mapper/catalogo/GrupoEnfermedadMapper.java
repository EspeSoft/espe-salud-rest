package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoEnfermedad;
import com.espe.salud.dto.catalogo.GrupoEnfermedadDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrupoEnfermedadMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    GrupoEnfermedadDTO toGrupoEnfermedadDTO(GrupoEnfermedad grupoEnfermedad);

    List<GrupoEnfermedadDTO> toGrupoEnfermedadDTO(List<GrupoEnfermedad> grupoEnfermedades);

    @InheritInverseConfiguration
    GrupoEnfermedad toGrupoEnfermedad(GrupoEnfermedadDTO dto);
}
