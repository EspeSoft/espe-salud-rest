package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.TipoPlanificacionFamiliarDTO;
import com.espe.salud.service.catalogo.TipoPlanificacionFamiliarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_PLA_FAM;

@RestController
@RequestMapping(value = {URI_API_V1_TIP_PLA_FAM})
@Tag(description = "Gestiona el catálogo de tipos de planificación familiar", name = "Tipos de planificaciones familiares")
public class TipoPlanificacionFamiliarController {
    private final TipoPlanificacionFamiliarService service;

    @Autowired
    public TipoPlanificacionFamiliarController(TipoPlanificacionFamiliarService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de los tipos de planificacion familiar de MUJERES")
    @GetMapping(value = "/findAllMujeres", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoPlanificacionFamiliarDTO>> findAllMujeres() {
        return new ResponseEntity<>( service.findAllMujeres(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna el listado los tipos de planificacion familiar de HOMBRES")
    @GetMapping(value = "/findAllHombres", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoPlanificacionFamiliarDTO>> findAllHombres() {
        return new ResponseEntity<>( service.findAllHombres(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna el listado de todos los tipos de planificacion familiar en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoPlanificacionFamiliarDTO>> getAll() {
        return new ResponseEntity<>( service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un tipo de planificación familiar por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<TipoPlanificacionFamiliarDTO> retrieve(
            @Parameter(description = "El ID del tipo planificación familiar", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un tipo de planificación familiar")
    public ResponseEntity<TipoPlanificacionFamiliarDTO> save(@RequestBody TipoPlanificacionFamiliarDTO dto){
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }
}
