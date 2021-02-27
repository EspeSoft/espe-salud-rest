package com.espe.salud.mapper.catalogo;


import com.espe.salud.domain.entities.catalogo.DescripcionActividadEnfermeria;
import com.espe.salud.dto.catalogo.DescripcionActividadEnfermeriaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DescripcionActividadEnfermeriaMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    DescripcionActividadEnfermeriaDTO toDescripcionActividadEnfermeriaDTO(DescripcionActividadEnfermeria descripcionActividadEnfermeria);

    List<DescripcionActividadEnfermeriaDTO> toDescripcionesActividadEnfermeriaDTO(List<DescripcionActividadEnfermeria> descripcionActividadEnfermerias);

    @InheritInverseConfiguration
    DescripcionActividadEnfermeria toDescripcionActividadEnfermeria(DescripcionActividadEnfermeriaDTO dto);
}
