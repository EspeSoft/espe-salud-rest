package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoExamenSexual;
import com.espe.salud.dto.catalogo.TipoExamenSexualDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoExamenSexualMapper {
    @Mapping(source = "codigo", target = "id")
    TipoExamenSexualDTO toTipoExamenSexualDTO(TipoExamenSexual examenSexual);

    @InheritInverseConfiguration
    TipoExamenSexual toTipoExamenSexual(TipoExamenSexualDTO dto);

    List<TipoExamenSexualDTO> toTiposExamenesDTO(List<TipoExamenSexual> examenes);
}
