package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoIngreso;
import com.espe.salud.dto.catalogo.TipoIngresoDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_ING;

@RestController
@RequestMapping(value = {URI_API_V1_TIP_ING})
@Tag(name = "Gestiona el catálogo de tipos de ingresos")
public class TipoIngresoController {
    private final GenericCRUDService<TipoIngreso, TipoIngresoDTO> service;

    @Autowired
    public TipoIngresoController(
            @Qualifier("tipoIngresoServiceImpl") GenericCRUDService<TipoIngreso, TipoIngresoDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de ingreso en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoIngresoDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un tipo de ingreso por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<TipoIngresoDTO> retrieve(
            @Parameter(description = "El ID del tipo de ingreso", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo tipo de ingreso")
    public ResponseEntity<TipoIngresoDTO> save(@RequestBody TipoIngresoDTO tipoIngresoDTO){
        return new ResponseEntity<>(service.saveOrUpdate(tipoIngresoDTO), HttpStatus.CREATED);
    }
}
