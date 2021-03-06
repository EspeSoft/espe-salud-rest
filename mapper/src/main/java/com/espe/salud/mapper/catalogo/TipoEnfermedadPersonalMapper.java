package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEnfermedadPersonal;
import com.espe.salud.dto.catalogo.TipoEnfermedadPersonalDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoEnfermedadPersonalMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    TipoEnfermedadPersonalDTO toTipoEnfermedadPersonalDTO(TipoEnfermedadPersonal tipoenfermedadpersonal);

    List<TipoEnfermedadPersonalDTO> toTipoEnfermedadPersonalDTO(List<TipoEnfermedadPersonal> tipoenfermedadpersonal);

    @InheritInverseConfiguration
    TipoEnfermedadPersonal toTipoEnfermedadPersonal(TipoEnfermedadPersonalDTO dto);
}
