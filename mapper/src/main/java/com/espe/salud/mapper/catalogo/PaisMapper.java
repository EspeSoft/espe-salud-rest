package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Pais;
import com.espe.salud.dto.catalogo.PaisDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
   
@Mapper(componentModel = "spring")
public interface PaisMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    PaisDTO toPaisDTO(Pais pais);

    List<PaisDTO> toPaissDTO(List<Pais> paises);

    @InheritInverseConfiguration
    Pais toPais(PaisDTO dto);
}
