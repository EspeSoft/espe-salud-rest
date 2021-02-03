package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoCultural;
import com.espe.salud.dto.catalogo.GrupoCulturalDTO;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface GrupoCulturalService {
    Optional<GrupoCulturalDTO> findById(Long codigo);
    List<GrupoCulturalDTO> findAll();
    GrupoCulturalDTO toDTO(GrupoCultural grupoCultural);
    GrupoCultural toEntity(GrupoCulturalDTO dto);
}
