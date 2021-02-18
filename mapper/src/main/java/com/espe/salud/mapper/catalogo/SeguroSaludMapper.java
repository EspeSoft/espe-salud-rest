package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.SeguroSalud;
import com.espe.salud.dto.catalogo.SeguroSaludDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeguroSaludMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    SeguroSaludDTO toSeguroSaludDTO(SeguroSalud segurosalud);

    List<SeguroSaludDTO> toSeguroSaludDTO(List<SeguroSalud> segurosSalud);

    @InheritInverseConfiguration
    SeguroSalud toSeguroSalud(SeguroSaludDTO dto);
}
