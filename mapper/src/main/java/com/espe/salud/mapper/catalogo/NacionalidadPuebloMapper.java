package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.NacionalidadPueblo;
import com.espe.salud.dto.catalogo.NacionalidadPuebloDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NacionalidadPuebloMapper {

    @Mapping(source = "codigo", target = "id")
    NacionalidadPuebloDTO toNacionalidadPuebloDTO(NacionalidadPueblo nacionalidadPueblo);

    List<NacionalidadPuebloDTO> toNacionalidadesPueblosDTO(List<NacionalidadPueblo> nacionalidades);

    @InheritInverseConfiguration
    NacionalidadPueblo toNacionalidadPueblo(NacionalidadPuebloDTO dto);
}
