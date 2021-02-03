package com.espe.salud.service.evolucion;

import com.espe.salud.domain.entities.evolucion.Procedimiento;
import com.espe.salud.dto.evolucion.ProcedimientoDTO;

import java.util.Optional;

public interface ProcedimientoService {
    ProcedimientoDTO save  (ProcedimientoDTO procedimiento);
    Optional<Procedimiento> findExisting(ProcedimientoDTO procedimientoDTO);
    Optional<ProcedimientoDTO> findById(Long codigo);
    ProcedimientoDTO   toDTO (Procedimiento procedimiento);
    Procedimiento toEntity (ProcedimientoDTO dto);
}
