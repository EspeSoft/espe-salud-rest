package com.espe.salud.mapper.odontologia;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaCuantitativo;
import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaSimple;
import com.espe.salud.dto.odontologia.DetalleOdontogramaCuantitativoDTO;
import com.espe.salud.dto.odontologia.DetalleOdontogramaSimpleDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleOdontogramaCuantitativoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    DetalleOdontogramaCuantitativoDTO toDetalleOdontogramaCuantitativoDTO(DetalleOdontogramaCuantitativo detalleOdontogramaCuantitativo);

    List<DetalleOdontogramaCuantitativoDTO> toDetalleOdontogramaCuantitativoDTO(List<DetalleOdontogramaCuantitativo> detallesOdontogramaCuantitativo);

    @InheritInverseConfiguration
    DetalleOdontogramaCuantitativo toDetalleOdontogramaCuantitativo(DetalleOdontogramaCuantitativoDTO dto);
}