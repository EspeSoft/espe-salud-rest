package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.paciente.PacienteBannerDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.dto.paciente.PacienteExternoDTO;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    PacienteDTO saveExternal(PacienteExternoDTO paciente);
    PacienteDTO saveBanner(PacienteBannerDTO pacienteBannerDTO);
    PacienteDTO updatePacienteExterno(PacienteExternoDTO paciente);
    Optional<PacienteDTO> findById(Long codigo);
    void darBajaPaciente(Long codigo);
    Optional<PacienteDTO> findExistingByNumeroArchivo(String numeroArchivo);
    boolean existsByNumeroArchivo(String numeroArchivo);
    List<PacienteDTO> findByNumeroArchivo(String numeroArchivo);
    List<PacienteDTO> findByFullName(String query);
    PacienteDTO mapPacienteInfo(Paciente paciente);
}
