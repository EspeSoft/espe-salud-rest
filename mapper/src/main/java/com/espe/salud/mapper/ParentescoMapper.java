package com.espe.salud.mapper;

import com.espe.salud.domain.Parentesco;
import com.espe.salud.dto.ParentescoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParentescoMapper {
    ParentescoDTO toParentescoDTO(Parentesco parentesco);

    List<ParentescoDTO> toParentescosDTO(List<Parentesco> parentescos);

    Parentesco toParentesco(ParentescoDTO dto);
}
