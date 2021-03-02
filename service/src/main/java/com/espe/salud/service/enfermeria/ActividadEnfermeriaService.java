package com.espe.salud.service.enfermeria;

import com.espe.salud.domain.entities.enfermeria.ActividadEnfermeria;
import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;

import java.util.List;
import java.util.Optional;

public interface ActividadEnfermeriaService {
    ActividadEnfermeriaDTO save(ActividadEnfermeriaDTO actividadEnfermeria);

    Optional<ActividadEnfermeriaDTO> findById(Long codigo);

    List<ActividadEnfermeriaDTO> findByUsuario(Long pidm);

    ActividadEnfermeriaDTO toDTO(ActividadEnfermeria notaEnfermeria);

    ActividadEnfermeria toEntity(ActividadEnfermeriaDTO dto);

    boolean delete(Long actividadEnfemeriaId);
}
