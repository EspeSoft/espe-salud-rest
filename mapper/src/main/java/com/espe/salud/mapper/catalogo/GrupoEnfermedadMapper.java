package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoEnfermedad;
import com.espe.salud.dto.catalogo.GrupoEnfermedadDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrupoEnfermedadMapper {

    GrupoEnfermedadDTO toGrupoEnfermedadDTO(GrupoEnfermedad grupoEnfermedad);

    List<GrupoEnfermedadDTO> toGrupoEnfermedadesDTO(List<GrupoEnfermedad> grupoEnfermedades);

    GrupoEnfermedad toGrupoEnfermedad(GrupoEnfermedadDTO dto);
}
