package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import com.espe.salud.dto.catalogo.RepertorioMedicamentoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepertorioMedicamentoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RepertorioMedicamentoDTO toRepertorioMedicamentoDTO(RepertorioMedicamento medicamento);
    List<RepertorioMedicamentoDTO> toRepertoriosMedicamentosDTO(List<RepertorioMedicamento> medicamentos);
    @InheritInverseConfiguration
    RepertorioMedicamento toRepertorioMedicamento(RepertorioMedicamentoDTO dto);
}
