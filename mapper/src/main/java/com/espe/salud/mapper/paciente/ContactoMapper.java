package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.catalogo.Parentesco;
import com.espe.salud.domain.entities.paciente.Contacto;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.dto.paciente.ContactoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ContactoDTO toContactoDTO(Contacto contacto);

    List<ContactoDTO> toContactosDTO(List<Contacto> contactos);

    @InheritInverseConfiguration
    Contacto toContacto(ContactoDTO dto);
}
