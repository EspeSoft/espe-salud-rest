package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.Region;
import com.espe.salud.domain.entities.catalogo.RelacionEspe;
import com.espe.salud.dto.catalogo.RegionDTO;
import com.espe.salud.dto.catalogo.RelacionEspeDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_RELACIONES_ESPE;

@RestController
@RequestMapping(value = {URI_API_V1_RELACIONES_ESPE})
@Tag(description = "Gestiona el catalogo de relaciones de la ESPE", name = "Relaciones con la ESPE")
public class RelacionEspeController {
    private final GenericCRUDService<RelacionEspe, RelacionEspeDTO> service;

    @Autowired
    public RelacionEspeController(
            @Qualifier("relacionEspeServiceImpl") GenericCRUDService<RelacionEspe, RelacionEspeDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas las relaciones con la ESPE en orden alabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RelacionEspeDTO>> getAll() {
        return new ResponseEntity<>(service.findAllOrderByNameASC(), HttpStatus.OK);
    }
}
