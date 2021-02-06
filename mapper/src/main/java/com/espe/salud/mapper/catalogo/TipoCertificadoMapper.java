package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoCertificado;
import com.espe.salud.dto.catalogo.TipoCertificadoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoCertificadoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    TipoCertificadoDTO toTipoCertificadoDTO(TipoCertificado tipocertificado);

    List<TipoCertificadoDTO> toTiposCertificadoDTO(List<TipoCertificado> tipocertificado);

    @InheritInverseConfiguration
    TipoCertificado toTipoCertificadoDTO(TipoCertificadoDTO dto);
}
