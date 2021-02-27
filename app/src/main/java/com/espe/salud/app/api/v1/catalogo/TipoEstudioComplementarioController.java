package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEstudioComplementario;
import com.espe.salud.dto.catalogo.TipoEstudioComplementarioDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_EST_COM;

@RestController
@RequestMapping(value = {URI_API_V1_TIP_EST_COM})
@Tag(description = "Gestiona el catálogo de tipos de estudios complementarios", name = "Tipos de estudios complementarios")
public class TipoEstudioComplementarioController {
    private final GenericCRUDService<TipoEstudioComplementario, TipoEstudioComplementarioDTO> service;

    @Autowired
    public TipoEstudioComplementarioController(
            @Qualifier("tipoEstudioComplementarioServiceImpl") GenericCRUDService<TipoEstudioComplementario, TipoEstudioComplementarioDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de estudio complementarios en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoEstudioComplementarioDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un tipo de estudio complementario por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<TipoEstudioComplementarioDTO> retrieve(
            @Parameter(description = "El ID del tipo de estudio complementario", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo tipo de estudio complementario")
    public ResponseEntity<TipoEstudioComplementarioDTO> save(@RequestBody TipoEstudioComplementarioDTO dto){
        return new ResponseEntity<>(service.saveOrUpdate(dto), HttpStatus.CREATED);
    }

}
