package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEgreso;
import com.espe.salud.dto.catalogo.TipoEgresoDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_EGR;

@RestController
@RequestMapping(value = {URI_API_V1_TIP_EGR})
@Tag(description = "Gestiona el catálogo de tipos de egresos", name = "Tipos de egresos")
public class TipoEgresoController {

    private final GenericCRUDService<TipoEgreso, TipoEgresoDTO> service;

    @Autowired
    public TipoEgresoController(
            @Qualifier("tipoEgresoServiceImpl") GenericCRUDService<TipoEgreso, TipoEgresoDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de egreso en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoEgresoDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un tipo de egreso por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<TipoEgresoDTO> retrieve(
            @Parameter(description = "El ID del parentesco", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo tipo de egreso")
    public ResponseEntity<TipoEgresoDTO> save(@RequestBody TipoEgresoDTO egresoDTO){
        return new ResponseEntity<>(service.saveOrUpdate(egresoDTO), HttpStatus.CREATED);
    }
}
