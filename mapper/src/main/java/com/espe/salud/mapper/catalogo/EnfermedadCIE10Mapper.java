package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {GrupoEnfermedadMapper.class})
public interface EnfermedadCIE10Mapper {

    EnfermedadCIE10DTO toEnfermedadCIE10DTO(EnfermedadCIE10 enfermedadCIE10);

    List<EnfermedadCIE10DTO> toEnfermedadesCIE10DTO(List<EnfermedadCIE10> enfermedadesCIE10);

    EnfermedadCIE10 toEnfermedadCIE10(EnfermedadCIE10DTO dto);
}
