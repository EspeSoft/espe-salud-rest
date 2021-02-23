package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoActividadEnfermeria;
import com.espe.salud.dto.catalogo.TipoActividadEnfermeriaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoActividadEnfermeriaMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    TipoActividadEnfermeriaDTO toTipoActividadEnfermeriaDTO(TipoActividadEnfermeria tipoActividadEnfermeria);

    List<TipoActividadEnfermeriaDTO> toTipoActividadesEnfermeriasDTO(List<TipoActividadEnfermeria> tipoActividadEnfermerias);

    @InheritInverseConfiguration
    TipoActividadEnfermeria toTipoActividadEnfermeria(TipoActividadEnfermeriaDTO dto);
}
