package com.espe.salud.mapper.odontologia;

import com.espe.salud.domain.entities.odontologia.HistoriaClinicaOdontologica;
import com.espe.salud.dto.odontologia.HistoriaClinicaOdontologicaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoriaClinicaOdontologicaMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    HistoriaClinicaOdontologicaDTO toHistoriaClinicaOdontologicaDTO(HistoriaClinicaOdontologica historiaClinicaOdontologica);

    List<HistoriaClinicaOdontologicaDTO> toHistoriasClinicasOdontologicasDTO(List<HistoriaClinicaOdontologica> historiasClinicasOdontologicas);

    @InheritInverseConfiguration
    HistoriaClinicaOdontologica toHistoriaClinicaOdontologica(HistoriaClinicaOdontologicaDTO dto);

}
