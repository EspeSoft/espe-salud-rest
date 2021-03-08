package com.espe.salud.service.catalogo;


import com.espe.salud.domain.entities.catalogo.DescripcionActividadEnfermeria;
import com.espe.salud.dto.catalogo.DescripcionActividadEnfermeriaDTO;
import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;

import java.util.List;
import java.util.Optional;

public interface DescripcionActividadEnfermeriaService {
    Optional<DescripcionActividadEnfermeriaDTO> findById(Long id);

    List<DescripcionActividadEnfermeriaDTO> findAllOrderByNombreASC();

    List<DescripcionActividadEnfermeriaDTO> findByDescripcion(Long id);


    DescripcionActividadEnfermeriaDTO toDTO(DescripcionActividadEnfermeria descripcionActividadEnfermeria);

    DescripcionActividadEnfermeria toEntity(DescripcionActividadEnfermeriaDTO dto);
}
