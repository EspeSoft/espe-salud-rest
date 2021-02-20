package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.dto.catalogo.DispensarioDTO;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface DispensarioMapper {

    @Mapping(source = "codigo", target = "id")
    DispensarioDTO toDispensarioDTO(Dispensario dispensario);

    List<DispensarioDTO> toDispensarioDTO(List<Dispensario> dispensarios);

    @InheritInverseConfiguration
    Dispensario toDispensario(DispensarioDTO dto);
}