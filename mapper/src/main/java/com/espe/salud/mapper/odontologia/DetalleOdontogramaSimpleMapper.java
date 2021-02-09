package com.espe.salud.mapper.odontologia;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaSimple;
import com.espe.salud.dto.odontologia.DetalleOdontogramaSimpleDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleOdontogramaSimpleMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    DetalleOdontogramaSimpleDTO toDetalleOdontogramaSimpleDTO(DetalleOdontogramaSimple detalleOdontogramaSimple);

    List<DetalleOdontogramaSimpleDTO> toDetalleOdontogramaSimpleDTO(List<DetalleOdontogramaSimple> detallesOdontogramaSimple);

    @InheritInverseConfiguration
    DetalleOdontogramaSimple toDetalleOdontogramaSimple(DetalleOdontogramaSimpleDTO dto);
}
