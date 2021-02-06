package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.NacionalidadPueblo;
import com.espe.salud.dto.catalogo.NacionalidadPuebloDTO;

import java.util.List;
import java.util.Optional;

public interface NacionalidadPuebloService {
    NacionalidadPuebloDTO save(NacionalidadPuebloDTO nacionalidadPuebloDTO);
    List<NacionalidadPuebloDTO> findAllOrderByNombreASC();
    Optional<NacionalidadPuebloDTO> findById(Long id);
    List<NacionalidadPuebloDTO> findByGrupoCulturalId(Long idGrupoCultural);
    NacionalidadPuebloDTO toDTO(NacionalidadPueblo nacionalidadPueblo);
    NacionalidadPueblo toEntity(NacionalidadPuebloDTO dto);
}
