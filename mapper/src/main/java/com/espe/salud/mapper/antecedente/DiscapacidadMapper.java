package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.Discapacidad;
import com.espe.salud.dto.antecedente.DiscapacidadDTO;
import com.espe.salud.dto.catalogo.DispensarioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscapacidadMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    DiscapacidadDTO toDiscapacidadDTO(Discapacidad discapacidad);

    List<DiscapacidadDTO> toDiscapacidadDTO(List<Discapacidad> discapacidads);

    @InheritInverseConfiguration
    Discapacidad toDiscapacidad(DiscapacidadDTO dto);
}