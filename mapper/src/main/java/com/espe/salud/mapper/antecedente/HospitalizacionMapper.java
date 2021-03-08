package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.Hospitalizacion;
import com.espe.salud.dto.antecedente.HospitalizacionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HospitalizacionMapper {
    @Mapping(source = "codigo", target = "id")
    HospitalizacionDTO toHospitalizacionDTO(Hospitalizacion hospitalizacion);

    @InheritInverseConfiguration
    Hospitalizacion toHospitalizacion(HospitalizacionDTO dto);

    List<HospitalizacionDTO> toHospitalizacionesDTO(List<Hospitalizacion> hospitalizaciones);
}
