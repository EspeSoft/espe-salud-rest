package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.NivelInstruccion;
import com.espe.salud.dto.catalogo.NivelInstruccionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NivelInstruccionMapper {
    @Mapping(source = "codigo", target = "id")
    NivelInstruccionDTO toNivelInstruccionDTO(NivelInstruccion nivelInstruccion);

    List<NivelInstruccionDTO> toNivelesInstruccion(List<NivelInstruccion> niveles);

    @InheritInverseConfiguration
    NivelInstruccion toNivelInstruccion(NivelInstruccionDTO dto);
}
