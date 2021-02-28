package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoExamenLaboratorio;
import com.espe.salud.dto.catalogo.TipoExamenLaboratorioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoExamenLaboratorioMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    TipoExamenLaboratorioDTO toExamenLaboratorioDTO(TipoExamenLaboratorio tipoExamenLaboratorio);

    List<TipoExamenLaboratorioDTO> toExamenLaboratorioDTO(List<TipoExamenLaboratorio> examenlaboratorios);

    @InheritInverseConfiguration
    TipoExamenLaboratorio toExamenLaboratorio(TipoExamenLaboratorioDTO dto);
}
