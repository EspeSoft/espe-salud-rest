package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.paciente.PacienteBannerDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.dto.paciente.PacienteExternoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ContactoMapper.class, ContactoEmergenciaMapper.class})
public interface PacienteMapper {

    @Mapping(source = "codigo", target = "id")
    @Mapping(source = "persona.apellidoPaterno", target = "apellidoPaterno")
    @Mapping(source = "persona.contacto", target = "contacto")
    @Mapping(source = "persona.contactosEmergencia", target = "contactosEmergencia")
    PacienteDTO toPacienteDTO(Paciente paciente);

    List<PacienteDTO> toPacientesDTO(List<Paciente> pacientes);

    Paciente fromPacienteBannerDTOToPaciente(PacienteBannerDTO pacienteBannerDTO);

    @Mapping(source = "apellidoPaterno", target = "persona.apellidoPaterno")
    @Mapping(source = "contacto", target = "persona.contacto")
    @Mapping(source = "contactosEmergencia", target = "persona.contactosEmergencia")
    Paciente fromPacienteExternoDTOToPaciente(PacienteExternoDTO pacienteExternoDTO);
}
