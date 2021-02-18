package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.DetalleExamenLaboratorio;
import com.espe.salud.dto.catalogo.DetalleExamenLaboratorioDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_DETEXALAB;

@RestController
@RequestMapping(value = {URI_API_V1_DETEXALAB})
@Tag(description = "Gestiona el catálogo de detalles de examenes de laboratorio", name = "Detalles de examen de laboratorio")
public class DetalleExamenLaboratorioController {

    private final GenericCRUDService<DetalleExamenLaboratorio, DetalleExamenLaboratorioDTO> detalleExamenLaboratorioService;

    @Autowired
    public DetalleExamenLaboratorioController(
            @Qualifier("detalleExamenLaboratorioServiceImpl") GenericCRUDService<DetalleExamenLaboratorio, DetalleExamenLaboratorioDTO> detalleExamenLaboratorioService) {
        this.detalleExamenLaboratorioService = detalleExamenLaboratorioService;
    }

    @Operation(summary = "Retorna el listado de todos los detalles de los exámenes de laboratorio")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DetalleExamenLaboratorioDTO>> getAll() {
        DetalleExamenLaboratorioDTO detalleExamenLaboratorioDTO = new DetalleExamenLaboratorioDTO();
        return new ResponseEntity<>( detalleExamenLaboratorioService.findAll(detalleExamenLaboratorioDTO), HttpStatus.OK);
    }
}
