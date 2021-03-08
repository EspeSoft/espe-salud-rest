package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.MedicacionHabitual;
import com.espe.salud.dto.antecedente.MedicacionHabitualDTO;
import com.espe.salud.mapper.catalogo.FrecuenciaMedicacionHabitualMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FrecuenciaMedicacionHabitualMapper.class})
public interface MedicacionHabitualMapper {

    @Mapping(source = "codigo", target = "id")
    MedicacionHabitualDTO toMedicacionHabitualDTO(MedicacionHabitual medicacionHabitual);

    List<MedicacionHabitualDTO> toMedicacionesHabitualesDTO(List<MedicacionHabitual> medicacionHabitualList);

    @InheritInverseConfiguration
    MedicacionHabitual toMedicacionHabitual(MedicacionHabitualDTO dto);
}
