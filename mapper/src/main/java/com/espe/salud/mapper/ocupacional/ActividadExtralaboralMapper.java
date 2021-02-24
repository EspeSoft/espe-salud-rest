package com.espe.salud.mapper.ocupacional;

import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import com.espe.salud.dto.ocupacional.ActividadExtralaboralDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActividadExtralaboralMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ActividadExtralaboralDTO toActividadExtralaboralDto(ActividadExtralaboral actividad);

    List<ActividadExtralaboralDTO> toActividadesExtralaboralesDto(List<ActividadExtralaboral> actividades);

    @InheritInverseConfiguration
    ActividadExtralaboral toActividadExtralaboral(ActividadExtralaboralDTO dto);
}
