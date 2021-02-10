package com.espe.salud.mapper.catalogo;


import com.espe.salud.domain.entities.catalogo.TipoEnfermedad;
import com.espe.salud.dto.catalogo.TipoEnfermedadDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoEnfermedadMapper {

    @Mapping(source = "codigo", target = "id")
    TipoEnfermedadDTO toTipoEnfermedadDTO(TipoEnfermedad tipoEnfermedad);

    List<TipoEnfermedadDTO> toTipoEnfermedadDTO(List<TipoEnfermedad> tipoEnfermedades);

    @InheritInverseConfiguration
    TipoEnfermedad toTipoEnfermedad(TipoEnfermedadDTO dto);
}
