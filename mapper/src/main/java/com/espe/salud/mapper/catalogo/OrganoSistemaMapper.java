package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.OrganoSistema;
import com.espe.salud.dto.catalogo.OrganoSistemaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganoSistemaMapper {

    @Mapping(source = "codigo", target = "id")
    OrganoSistemaDTO toOrganoSistemaDTO(OrganoSistema organoSistema);

    List<OrganoSistemaDTO> toOrganoSistemaDTO(List<OrganoSistema> organoSistemas);

    @InheritInverseConfiguration
    OrganoSistema toOrganoSistema(OrganoSistemaDTO dto);
}
