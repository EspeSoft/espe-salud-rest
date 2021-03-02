package com.espe.salud.service.catalogo;


import com.espe.salud.domain.entities.catalogo.DescripcionActividadEnfermeria;
import com.espe.salud.dto.catalogo.DescripcionActividadEnfermeriaDTO;

import java.util.List;
import java.util.Optional;

public interface DescripcionActividadEnfermeriaService {
    Optional<DescripcionActividadEnfermeriaDTO> findById(Long id);

    List<DescripcionActividadEnfermeriaDTO> findAllOrderByNombreASC();

    DescripcionActividadEnfermeriaDTO toDTO(DescripcionActividadEnfermeria descripcionActividadEnfermeria);

    DescripcionActividadEnfermeria toEntity(DescripcionActividadEnfermeriaDTO dto);
}
