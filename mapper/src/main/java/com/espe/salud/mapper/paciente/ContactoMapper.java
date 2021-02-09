package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.Contacto;
import com.espe.salud.dto.paciente.ContactoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactoMapper {

    ContactoDTO toContactoDTO(Contacto contacto);

    @InheritInverseConfiguration
    Contacto toContacto(ContactoDTO dto);
}
