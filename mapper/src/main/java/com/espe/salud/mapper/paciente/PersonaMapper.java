package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.Persona;
import com.espe.salud.dto.paciente.PersonaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    PersonaDTO toPersonaDTO(Persona persona);

    List<PersonaDTO> toPersonasDTO(List<Persona> personas);

    @InheritInverseConfiguration
    Persona toPersona(PersonaDTO dto);
}
