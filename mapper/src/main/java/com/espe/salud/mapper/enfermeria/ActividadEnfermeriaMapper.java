package com.espe.salud.mapper.enfermeria;

import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import com.espe.salud.dto.catalogo.DescripcionActividadEnfermeriaDTO;
import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;
import com.espe.salud.mapper.catalogo.TipoActividadEnfermeriaMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoActividadEnfermeriaMapper.class})
public interface ActividadEnfermeriaMapper{
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ActividadEnfermeriaDTO toActividadEnfermeriaDTO(ActividadEnfermeria actividadEnfermeria);

    List<ActividadEnfermeriaDTO> toActividadesEnfermeriasDTO(List<ActividadEnfermeria> actividadesEnfermerias);

    @InheritInverseConfiguration
    ActividadEnfermeria toActividadEnfermeria(ActividadEnfermeriaDTO dto);
}
