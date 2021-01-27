package com.espe.salud.service.enfermeria;

import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import com.espe.salud.dto.enfermeria.NotaEnfermeriaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface NotaEnfermeriaService {
    NotaEnfermeriaDTO save(NotaEnfermeriaDTO notaEnfermeria);
    Optional<NotaEnfermeriaDTO> findById(Long codigo);
    List<NotaEnfermeriaDTO> findByPaciente(Long pacienteCodigo);
    NotaEnfermeriaDTO toDTO(NotaEnfermeria notaEnfermeria);
    NotaEnfermeria toEntity(NotaEnfermeriaDTO dto);
}
