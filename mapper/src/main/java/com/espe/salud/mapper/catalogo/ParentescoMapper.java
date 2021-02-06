package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Parentesco;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParentescoMapper {

    @Mapping(source = "codigo", target = "id")
    ParentescoDTO toParentescoDTO(Parentesco parentesco);

    List<ParentescoDTO> toParentescosDTO(List<Parentesco> parentescos);

    @InheritInverseConfiguration
    Parentesco toParentesco(ParentescoDTO dto);
}
