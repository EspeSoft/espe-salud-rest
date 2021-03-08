package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.HospitalizacionDTO;

import java.util.List;
import java.util.Optional;

public interface HospitalizacionService {
    HospitalizacionDTO save(HospitalizacionDTO hospitalizacionDTO);

    HospitalizacionDTO update(HospitalizacionDTO hospitalizacionDTO);

    Optional<HospitalizacionDTO> findById(Long codigo);

    boolean delete(Long codigo);

    List<HospitalizacionDTO> findByPaciente(Long idPaciente);
}
