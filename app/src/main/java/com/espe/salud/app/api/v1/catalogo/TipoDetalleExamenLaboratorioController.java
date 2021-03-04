package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoDetalleExamenLaboratorio;
import com.espe.salud.dto.catalogo.TipoDetalleExamenLaboratorioDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_TIPDETEXALAB;

@RestController
@RequestMapping(value = {URI_API_V1_TIPDETEXALAB})
@Tag(description = "Gestiona el catálogo de tipos de detalles de examenes de laboratorio", name = "Tipos de detalles de examen de laboratorio")
public class TipoDetalleExamenLaboratorioController {

    private final GenericCRUDService<TipoDetalleExamenLaboratorio, TipoDetalleExamenLaboratorioDTO> detalleExamenLaboratorioService;

    @Autowired
    public TipoDetalleExamenLaboratorioController(
            @Qualifier("detalleExamenLaboratorioServiceImpl") GenericCRUDService<TipoDetalleExamenLaboratorio, TipoDetalleExamenLaboratorioDTO> detalleExamenLaboratorioService) {
        this.detalleExamenLaboratorioService = detalleExamenLaboratorioService;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de detalles de los exámenes de laboratorio")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoDetalleExamenLaboratorioDTO>> getAll() {
        return new ResponseEntity<>(detalleExamenLaboratorioService.findAllOrderByNameASC(), HttpStatus.OK);
    }
}
