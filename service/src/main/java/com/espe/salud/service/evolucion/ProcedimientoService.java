package com.espe.salud.service.evolucion;

import com.espe.salud.domain.entities.evolucion.Procedimiento;
import com.espe.salud.dto.evolucion.ProcedimientoDTO;
import com.espe.salud.dto.paciente.PacienteDTO;

import java.util.List;
import java.util.Optional;

public interface ProcedimientoService {
    ProcedimientoDTO save  (ProcedimientoDTO procedimiento);
    ProcedimientoDTO update(ProcedimientoDTO procedimiento);
    Optional<Procedimiento> findExisting(ProcedimientoDTO procedimientoDTO);
    Boolean delete(Long id);
    Optional<ProcedimientoDTO> findByCodigo(Long codigo);
    ProcedimientoDTO   toDTO (Procedimiento procedimiento);
    Procedimiento toEntity (ProcedimientoDTO dto);
    List<ProcedimientoDTO> findAll();
}
