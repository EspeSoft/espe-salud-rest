package com.espe.salud.app.api.v1.catalogo;

import static com.espe.salud.app.common.Constants.URI_API_V1_PAI;

import java.util.List;

import com.espe.salud.domain.entities.catalogo.Pais;
import com.espe.salud.dto.catalogo.PaisDTO;
import com.espe.salud.service.GenericCRUDService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = {URI_API_V1_PAI})
@Tag(description = "Gestiona el catálogo de país", name = "Paises")
public class PaisController {

    private final GenericCRUDService<Pais, PaisDTO> paisService;

    @Autowired
    public PaisController(
            @Qualifier("paisServiceImpl") GenericCRUDService<Pais, PaisDTO> paisService) {
        this.paisService = paisService;
    }


    @Operation(summary = "Retorna el listado de todos los paises en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PaisDTO>> getAll() {
        return new ResponseEntity<>( paisService.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un pais por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<PaisDTO> retrieve(
            @Parameter(description = "El ID del pais", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(paisService.findById(id), HttpStatus.OK);
    }

}