package com.espe.salud.service.catalogo;

import com.espe.salud.dto.catalogo.TipoExamenSexualDTO;

import java.util.List;
import java.util.Optional;

public interface TipoExamenSexualService {
    TipoExamenSexualDTO save(TipoExamenSexualDTO dto);

    List<TipoExamenSexualDTO> findAll();

    Optional<TipoExamenSexualDTO> findById(Long id);

    List<TipoExamenSexualDTO> findAllMujeres();

    List<TipoExamenSexualDTO> findAllHombres();
}
