package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.MedicacionHabitualDTO;

import java.util.List;
import java.util.Optional;

public interface MedicacionHabitualService {

    MedicacionHabitualDTO save(MedicacionHabitualDTO medicacionHabitualDTO);

    MedicacionHabitualDTO update(MedicacionHabitualDTO medicacionHabitualDTO);

    Optional<MedicacionHabitualDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<MedicacionHabitualDTO> findByPaciente(Long idPaciente);
}
