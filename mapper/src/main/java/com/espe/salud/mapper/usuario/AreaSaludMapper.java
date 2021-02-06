package com.espe.salud.mapper.usuario;

import com.espe.salud.domain.entities.usuario.AreaSalud;
import com.espe.salud.dto.usuario.AreaSaludDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaSaludMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AreaSaludDTO toAreaSaludDTO(AreaSalud areaSalud);
    List<AreaSaludDTO> toAreasSaludDTO(List<AreaSalud> areasSalud);

    @InheritInverseConfiguration
    AreaSalud toAreaSalud(AreaSaludDTO dto);
}
