package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoPlanificacionFamiliar;
import com.espe.salud.dto.catalogo.TipoPlanificacionFamiliarDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoPlanificacionFamiliarMapper {

    @Mapping(source = "codigo", target = "id")
    TipoPlanificacionFamiliarDTO toTipoPlanificacionFamiliarDTO(TipoPlanificacionFamiliar planificacionFamiliar);

    List<TipoPlanificacionFamiliarDTO> toTiposPlanificacionFamiliarDTO(List<TipoPlanificacionFamiliar> tipos);

    @InheritInverseConfiguration
    TipoPlanificacionFamiliar toTipoPlanificacionFamiliar(TipoPlanificacionFamiliarDTO dto);
}
