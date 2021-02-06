package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEgreso;
import com.espe.salud.dto.catalogo.TipoEgresoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoEgresoMapper {
    @Mapping(source = "codigo", target = "id")
    TipoEgresoDTO toTipoEgresoDTO(TipoEgreso tipoEgreso);

    List<TipoEgresoDTO> toTiposEgresoDTO(List<TipoEgreso> tiposEgreso);

    @InheritInverseConfiguration
    TipoEgreso toTipoEngreso(TipoEgresoDTO dto);
}
