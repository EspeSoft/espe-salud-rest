package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.MotivoAtencion;
import com.espe.salud.dto.catalogo.MotivoAtencionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MotivoAtencionMapper {

    @Mapping(source = "codigo", target = "id")
    MotivoAtencionDTO toMotivoAtencionDTO(MotivoAtencion motivoAtencion);

    List<MotivoAtencionDTO> toMotivosAtencionDTO(List<MotivoAtencion> motivosAtencion);

    @InheritInverseConfiguration
    MotivoAtencion toMotivoAtencion(MotivoAtencionDTO dto);
}
