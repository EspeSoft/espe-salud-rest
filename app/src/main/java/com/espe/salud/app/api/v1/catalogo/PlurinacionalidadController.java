package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.Plurinacionalidad;
import com.espe.salud.dto.catalogo.PlurinacionalidadDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_PLURINACIONALIDAD;

@RestController
@RequestMapping(value = {URI_API_V1_PLURINACIONALIDAD})
@Tag(description = "Gestiona el catálogo de plurinacionalidades", name = "Plurinacionalidades")
public class PlurinacionalidadController {
    private final GenericCRUDService<Plurinacionalidad, PlurinacionalidadDTO> service;

    @Autowired
    public PlurinacionalidadController(
            @Qualifier("plurinacionalidadServiceImpl") GenericCRUDService<Plurinacionalidad, PlurinacionalidadDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas las plurinacionalidades")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PlurinacionalidadDTO>> getAll() {
        PlurinacionalidadDTO plurinacionalidad = new PlurinacionalidadDTO();
        return new ResponseEntity<>(service.findAll(plurinacionalidad), HttpStatus.OK);
    }
}
