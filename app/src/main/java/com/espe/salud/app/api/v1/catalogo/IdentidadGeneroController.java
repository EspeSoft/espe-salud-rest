package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.IdentidadGenero;
import com.espe.salud.dto.catalogo.IdentidadGeneroDTO;
import com.espe.salud.service.GenericCRUDServiceImpl;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_IDENTIDADES_GENERO;

@RestController
@RequestMapping(value = {URI_API_V1_IDENTIDADES_GENERO})
@Tag(description = "Gestiona el catálogo de identidades de género", name = "Identidades de género")
public class IdentidadGeneroController {
    private final GenericCRUDServiceImpl<IdentidadGenero, IdentidadGeneroDTO> service;

    @Autowired
    public IdentidadGeneroController(
            @Qualifier("identidadGeneroServiceImpl") GenericCRUDServiceImpl<IdentidadGenero, IdentidadGeneroDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas las identidades de género en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<IdentidadGeneroDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una identidad de género por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<IdentidadGeneroDTO> retrieve(
            @Parameter(description = "El ID de la identidad de género", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nueva identidad de género")
    public ResponseEntity<IdentidadGeneroDTO> save(@RequestBody IdentidadGeneroDTO identidadGeneroDTO){
        return new ResponseEntity<>(service.saveOrUpdate(identidadGeneroDTO), HttpStatus.CREATED);
    }

}
