package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.ContactoEmergencia;
import com.espe.salud.dto.paciente.ContactoEmergenciaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactoEmergenciaMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ContactoEmergenciaDTO toContactoEmergenciaDTO(ContactoEmergencia contactoEmergencia);

    List<ContactoEmergenciaDTO> toContactosEmergenciaDTO(List<ContactoEmergencia> contactosEmergencia);

    @InheritInverseConfiguration
    ContactoEmergencia toContactoEmergencia(ContactoEmergenciaDTO dto);
}
