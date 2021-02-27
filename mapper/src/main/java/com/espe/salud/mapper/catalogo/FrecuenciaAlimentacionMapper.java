package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.FrecuenciaAlimentacion;
import com.espe.salud.dto.catalogo.FrecuenciaAlimentacionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FrecuenciaAlimentacionMapper {
    @Mapping(source = "codigo", target = "id")
    FrecuenciaAlimentacionDTO toFrecuenciaAlimentacionDTO(FrecuenciaAlimentacion frecuenciaAlimentacion);

    @InheritInverseConfiguration
    FrecuenciaAlimentacion toFrecuenciaAlimentacion(FrecuenciaAlimentacionDTO dto);

    List<FrecuenciaAlimentacionDTO> toFrecuenciasAlimentacion(List<FrecuenciaAlimentacion> frecuencias);
}
