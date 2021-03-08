package com.espe.salud.mapper.evolucion;

import com.espe.salud.domain.entities.evolucion.Reposo;
import com.espe.salud.dto.evolucion.ReposoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReposoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ReposoDTO toReposoDTO(Reposo reposo);
    List<ReposoDTO> toRepososDTO(List<Reposo> reposos);
    @InheritInverseConfiguration
    Reposo toReposo(ReposoDTO dto);
}
