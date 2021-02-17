package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.ConsumoNocivo;
import com.espe.salud.dto.antecedente.ConsumoNocivoDTO;
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
