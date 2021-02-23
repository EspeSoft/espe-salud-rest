package com.espe.salud.mapper.enfermeria;

import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActividadEnfermeriaMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ActividadEnfermeriaDTO toActividadEnfermeriaDTO(ActividadEnfermeria actividadEnfermeria);
    List<ActividadEnfermeriaDTO> toActividadesEnfermeriasDTO(List<ActividadEnfermeria> actividadesEnfermerias);

    @InheritInverseConfiguration
    ActividadEnfermeria toActividadEnfermeria(ActividadEnfermeriaDTO dto);
}