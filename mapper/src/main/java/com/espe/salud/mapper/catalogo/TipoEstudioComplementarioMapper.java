package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import com.espe.salud.domain.entities.catalogo.TipoEstudioComplementario;
import com.espe.salud.dto.catalogo.TipoEstudioComplementarioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoEstudioComplementarioMapper {
    @Mapping(source = "codigo", target = "id")
    TipoEstudioComplementarioDTO toTipoEstudioComplementarioDTO(TipoEstudioComplementario tipoEstudioComplementario);

    List<TipoEstudioComplementarioDTO> toTiposEstudioComplementario(List<TipoEstudioComplementario> estudiosComplementarios);

    @InheritInverseConfiguration
    TipoEstudioComplementario toTipoEstudioComplementario(TipoEstudioComplementarioDTO dto);
}
