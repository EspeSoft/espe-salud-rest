package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.Discapacidad;
import com.espe.salud.dto.antecedente.DiscapacidadDTO;
import com.espe.salud.mapper.catalogo.EnfermedadCIE10Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EnfermedadCIE10Mapper.class})
public interface DiscapacidadMapper {

    @Mapping(source = "codigo", target = "id")
    DiscapacidadDTO toDiscapacidadDTO(Discapacidad discapacidad);

    List<DiscapacidadDTO> toDiscapacidadesDTO(List<Discapacidad> discapacidads);

    @InheritInverseConfiguration
    Discapacidad toDiscapacidad(DiscapacidadDTO dto);
}