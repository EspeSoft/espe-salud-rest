package com.espe.salud.mapper.enfermeria;

import com.espe.salud.domain.entities.enfermeria.Antropometria;
import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import com.espe.salud.domain.entities.enfermeria.SignoVital;
import com.espe.salud.dto.enfermeria.AntropometriaDTO;
import com.espe.salud.dto.enfermeria.NotaEnfermeriaDTO;
import com.espe.salud.dto.enfermeria.SignoVitalDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotaEnfermeriaMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    NotaEnfermeriaDTO toNotaEnfermeriaDTO(NotaEnfermeria notaEnfermeria);
    List<NotaEnfermeriaDTO> toNotasEnfermeriaDTO(List<NotaEnfermeria> notasEnfermeria);

    @InheritInverseConfiguration
    NotaEnfermeria toNotaEnfermeria(NotaEnfermeriaDTO dto);

//    SignoVital toSignoVital(SignoVitalDTO dto);
//    SignoVitalDTO toSignoVitalDTO(SignoVital signoVital);
//
//    Antropometria toAntropometria(AntropometriaDTO dto);
//    AntropometriaDTO toAntropometriaDTO(Antropometria antropometria);
}
