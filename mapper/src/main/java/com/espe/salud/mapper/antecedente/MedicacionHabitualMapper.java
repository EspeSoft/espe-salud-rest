package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.MedicacionHabitual;
import com.espe.salud.dto.antecedente.MedicacionHabitalDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicacionHabitualMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    MedicacionHabitalDTO toMedicacionHabitualDTO(MedicacionHabitual medicacionHabitual);
    List<MedicacionHabitalDTO> toMedicacionHabitualDTO(List<MedicacionHabitual> medicacionHabitualList);

    @InheritInverseConfiguration
    MedicacionHabitual toMedicacionHabitual(MedicacionHabitalDTO dto);
}
