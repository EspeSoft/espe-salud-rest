package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Sede;
import com.espe.salud.dto.catalogo.SedeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SedeMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    SedeDTO toSedeDTO(Sede sede);

    List<SedeDTO> toSedeDTO(List<Sede> sedes);

    @InheritInverseConfiguration
    Sede toSede(SedeDTO dto);
}