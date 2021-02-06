package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoIngreso;
import com.espe.salud.dto.catalogo.TipoIngresoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoIngresoMapper {
    @Mapping(source = "codigo", target = "id")
    TipoIngresoDTO toTipoIngresoDTO(TipoIngreso tipoIngreso);

    List<TipoIngresoDTO> toTiposIngresoDTO(List<TipoIngreso> tiposIngreso);

    @InheritInverseConfiguration
    TipoIngreso toTipoIngreso(TipoIngresoDTO dto);
}
