package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.ConsumoNocivo;
import com.espe.salud.dto.antecedente.ConsumoNocivoDTO;
import com.espe.salud.mapper.catalogo.TipoConsumoNocivoMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoConsumoNocivoMapper.class})
public interface ConsumoNocivoMapper {

    @Mapping(source = "codigo", target = "id")
    ConsumoNocivoDTO toConsumoNocivoDTO(ConsumoNocivo consumoNocivo);

    List<ConsumoNocivoDTO> toConsumosNocivosDTO(List<ConsumoNocivo> consumosNocivos);

    @InheritInverseConfiguration
    ConsumoNocivo toConsumoNocivo(ConsumoNocivoDTO dto);
}
