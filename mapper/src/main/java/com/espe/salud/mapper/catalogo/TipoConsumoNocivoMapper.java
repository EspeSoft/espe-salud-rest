package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoConsumoNocivo;
import com.espe.salud.dto.catalogo.TipoConsumoNocivoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
   
@Mapper(componentModel = "spring")
public interface TipoConsumoNocivoMapper {

    @Mapping(source = "codigo", target = "id")
    TipoConsumoNocivoDTO toConsumoNocivoDTO(TipoConsumoNocivo tipoConsumoNocivo);

    List<TipoConsumoNocivoDTO> toConsumosNocivosDTO(List<TipoConsumoNocivo> consumosNocivos);

    @InheritInverseConfiguration
    TipoConsumoNocivo toConsumoNocivo(TipoConsumoNocivoDTO dto);
}
