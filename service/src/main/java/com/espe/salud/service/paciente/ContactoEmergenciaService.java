package com.espe.salud.service.paciente;

import com.espe.salud.dto.paciente.ContactoEmergenciaDTO;

import java.util.List;
import java.util.Optional;

public interface ContactoEmergenciaService {
    Optional<ContactoEmergenciaDTO> findById(Long id);
    List<ContactoEmergenciaDTO> findByPaciente(Long idPaciente);
    ContactoEmergenciaDTO save(ContactoEmergenciaDTO dto, Long idPaciente);
    ContactoEmergenciaDTO update(ContactoEmergenciaDTO dto, Long idPaciente);
    boolean delete(Long id);
}
