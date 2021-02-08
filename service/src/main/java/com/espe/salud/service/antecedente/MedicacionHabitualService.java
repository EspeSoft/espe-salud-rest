package com.espe.salud.service.antecedente;


import com.espe.salud.domain.entities.antecedente.MedicacionHabitual;
import com.espe.salud.dto.antecedente.MedicacionHabitalDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MedicacionHabitualService {

    MedicacionHabitalDTO save(MedicacionHabitalDTO medicacionHabitalDTO);
    MedicacionHabitalDTO update(MedicacionHabitalDTO medicacionHabitalDTO);
    Optional<MedicacionHabitalDTO> findById(Long codigo);
    List<MedicacionHabitalDTO> findAll();
    boolean deleteById(Long id);
    MedicacionHabitalDTO toDTO(MedicacionHabitual medicacionHabitual);
    MedicacionHabitual toEntity(MedicacionHabitalDTO dto);
}
