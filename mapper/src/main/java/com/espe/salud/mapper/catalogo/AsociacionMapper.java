package com.espe.salud.mapper.catalogo;


import com.espe.salud.domain.entities.catalogo.Asociacion;
import com.espe.salud.dto.catalogo.AsociacionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsociacionMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AsociacionDTO toAsociacionDTO(Asociacion asociacion);

    List<AsociacionDTO> toAsociacionesDTO(List<Asociacion> asociaciones);

    @InheritInverseConfiguration
    Asociacion toAsociacion(AsociacionDTO dto);
}
