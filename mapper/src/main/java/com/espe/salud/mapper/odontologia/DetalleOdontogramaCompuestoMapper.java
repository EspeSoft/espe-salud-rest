package com.espe.salud.mapper.odontologia;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaCompuesto;
import com.espe.salud.dto.odontologia.DetalleOdontogramaCompuestoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleOdontogramaCompuestoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    DetalleOdontogramaCompuestoDTO toDetalleOdontogramaCompuestoDTO(DetalleOdontogramaCompuesto detalleOdontogramaCompuesto);

    List<DetalleOdontogramaCompuestoDTO> toDetalleOdontogramaCompuestoDTO(List<DetalleOdontogramaCompuesto> detallesOdontogramaCompuesto);

    @InheritInverseConfiguration
    DetalleOdontogramaCompuesto toDetalleOdontogramaCompuesto(DetalleOdontogramaCompuestoDTO dto);
}
