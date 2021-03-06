package com.espe.salud.mapper.antecedente;


import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import com.espe.salud.dto.antecedente.EstudioComplementarioDTO;
import com.espe.salud.mapper.catalogo.TipoEstudioComplementarioMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoEstudioComplementarioMapper.class})
public interface EstudioComplementarioMapper {

    @Mapping(source = "codigo", target = "id")
    EstudioComplementarioDTO toEstudioComplementarioDTO(EstudioComplementario estudioComplementario);

    List<EstudioComplementarioDTO> toEstudiosComplementarioDTO(List<EstudioComplementario> estudiosComplementarios);

    @InheritInverseConfiguration
    EstudioComplementario toEstudioComplementario(EstudioComplementarioDTO dto);
}
