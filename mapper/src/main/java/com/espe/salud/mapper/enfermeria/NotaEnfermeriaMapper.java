package com.espe.salud.mapper.enfermeria;

import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import com.espe.salud.dto.enfermeria.NotaEnfermeriaDTO;
import com.espe.salud.mapper.usuario.AreaSaludMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AreaSaludMapper.class})
public interface NotaEnfermeriaMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    NotaEnfermeriaDTO toNotaEnfermeriaDTO(NotaEnfermeria notaEnfermeria);
    List<NotaEnfermeriaDTO> toNotasEnfermeriaDTO(List<NotaEnfermeria> notasEnfermeria);

    @InheritInverseConfiguration
    NotaEnfermeria toNotaEnfermeria(NotaEnfermeriaDTO dto);

}
