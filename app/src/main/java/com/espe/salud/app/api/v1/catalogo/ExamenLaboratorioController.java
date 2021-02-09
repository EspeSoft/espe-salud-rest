package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.ExamenLaboratorio;
import com.espe.salud.dto.catalogo.ExamenLaboratorioDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_EXALAB;

@RestController
@RequestMapping(value = {URI_API_V1_EXALAB})
@Tag(name = "Gestiona el catálogo de examenes de laboratorio")
public class ExamenLaboratorioController {

    private final GenericCRUDService<ExamenLaboratorio, ExamenLaboratorioDTO> examenLaboratorioService;

    @Autowired
    public ExamenLaboratorioController(
            @Qualifier("examenLaboratorioServiceImpl") GenericCRUDService<ExamenLaboratorio, ExamenLaboratorioDTO> examenLaboratorioService) {
        this.examenLaboratorioService = examenLaboratorioService;
    }

    @Operation(summary = "Retorna el listado de todos los exámenes de laboratorio")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ExamenLaboratorioDTO>> getAll() {
        ExamenLaboratorioDTO examenLaboratorioDTO = new ExamenLaboratorioDTO();
        return new ResponseEntity<>( examenLaboratorioService.findAll(examenLaboratorioDTO), HttpStatus.OK);
    }
}
