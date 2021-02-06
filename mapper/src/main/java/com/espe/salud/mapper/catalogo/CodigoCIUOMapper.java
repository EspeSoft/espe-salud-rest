package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.CodigoCIUO;
import com.espe.salud.dto.catalogo.CodigoCIUODTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CodigoCIUOMapper {

    CodigoCIUODTO toCodigoCIUODTO(CodigoCIUO codigoCIUO);

    List<CodigoCIUODTO> toCodigosCIUODTO(List<CodigoCIUO> codigosCIUO);

    CodigoCIUO toCodigoCIUO(CodigoCIUODTO codigoCIUODTO);
}
