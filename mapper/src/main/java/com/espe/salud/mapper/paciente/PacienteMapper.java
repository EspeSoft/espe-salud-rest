package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.catalogo.Parentesco;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.dto.paciente.ContactoDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    PacienteDTO toPacienteDTO(Paciente paciente);

    List<PacienteDTO> toPacientesDTO(List<Paciente> pacientes);

    @InheritInverseConfiguration
    Paciente toPaciente(PacienteDTO dto);
}
