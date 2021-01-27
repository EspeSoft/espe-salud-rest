package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.RecordLaboral;
import com.espe.salud.dto.paciente.RecordLaboralDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordLaboralMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RecordLaboralDTO toRecordLaboralDTO(RecordLaboral recordLaboral);

    List<RecordLaboralDTO> toRecordLaboralesDTO(List<RecordLaboral> recordLaborales);

    @InheritInverseConfiguration
    RecordLaboral toRecordLaboral(RecordLaboralDTO dto);
}
