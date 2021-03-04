package com.espe.salud.mapper.evolucion;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.mapper.catalogo.DispensarioMapper;
import com.espe.salud.mapper.catalogo.MotivoAtencionMapper;
import com.espe.salud.mapper.enfermeria.NotaEnfermeriaMapper;
import com.espe.salud.mapper.usuario.AreaSaludMapper;
import com.espe.salud.mapper.usuario.UsuarioMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AreaSaludMapper.class, NotaEnfermeriaMapper.class, DispensarioMapper.class, UsuarioMapper.class, MotivoAtencionMapper.class })
public interface EvolucionMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    EvolucionDTO toEvolucionDTO(Evolucion evolucion);

    List<EvolucionDTO> toEvolucionesDTO(List<Evolucion> evoluciones);

    @InheritInverseConfiguration
    Evolucion toEvolucion(EvolucionDTO dto);
}
