package com.espe.salud.service.catalogo;


import com.espe.salud.domain.entities.catalogo.TipoActividadEnfermeria;
import com.espe.salud.dto.catalogo.TipoActividadEnfermeriaDTO;

import java.util.List;
import java.util.Optional;

public interface TipoActividadEnfermeriaService {
    Optional<TipoActividadEnfermeriaDTO> findById(Long id);

    List<TipoActividadEnfermeriaDTO> findAllOrderByNombreASC();

    TipoActividadEnfermeriaDTO toDTO(TipoActividadEnfermeria tipoActividadEnfermeria);

    TipoActividadEnfermeria toEntity(TipoActividadEnfermeriaDTO dto);
}
