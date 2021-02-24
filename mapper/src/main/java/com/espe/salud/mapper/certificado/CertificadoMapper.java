package com.espe.salud.mapper.certificado;

import com.espe.salud.domain.entities.certificado.Certificado;
import com.espe.salud.dto.certificado.CertificadoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CertificadoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    CertificadoDTO toCertificadoDTO(Certificado certificado);
    List<CertificadoDTO> toCertificadoDTO(List<Certificado> certificados);

    @InheritInverseConfiguration
    Certificado toCertificado (CertificadoDTO dto);
}
