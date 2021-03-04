package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoExamenLaboratorio;
import com.espe.salud.dto.catalogo.TipoExamenLaboratorioDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIPEXALAB;

@RestController
@RequestMapping(value = {URI_API_V1_TIPEXALAB})
@Tag(description = "Gestiona el catálogo de tipo de examenes de laboratorio", name = "Tipo de examenes de laboratorio")
public class TipoExamenLaboratorioController {

    private final GenericCRUDService<TipoExamenLaboratorio, TipoExamenLaboratorioDTO> examenLaboratorioService;

    @Autowired
    public TipoExamenLaboratorioController(
            @Qualifier("examenLaboratorioServiceImpl") GenericCRUDService<TipoExamenLaboratorio, TipoExamenLaboratorioDTO> examenLaboratorioService) {
        this.examenLaboratorioService = examenLaboratorioService;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de exámenes de laboratorio")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoExamenLaboratorioDTO>> getAll() {
        return new ResponseEntity<>(examenLaboratorioService.findAllOrderByNameASC(), HttpStatus.OK);
    }
}
