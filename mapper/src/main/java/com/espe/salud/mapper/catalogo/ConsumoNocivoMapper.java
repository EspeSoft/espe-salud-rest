package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.ConsumoNocivo;
import com.espe.salud.dto.catalogo.ConsumoNocivoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
   
@Mapper(componentModel = "spring")
public interface ConsumoNocivoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ConsumoNocivoDTO toConsumoNocivoDTO(ConsumoNocivo consumoNocivo);

    List<ConsumoNocivoDTO> toConsumosNocivosDTO(List<ConsumoNocivo> consumosNocivos);

    @InheritInverseConfiguration
    ConsumoNocivo toConsumoNocivo(ConsumoNocivoDTO dto);
}
