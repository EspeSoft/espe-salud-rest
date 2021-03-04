package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.FrecuenciaAlimentacion;
import com.espe.salud.dto.catalogo.FrecuenciaAlimentacionDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_FRECUENCIAS_ALIMENTACION;

@RestController
@RequestMapping(value = {URI_API_V1_FRECUENCIAS_ALIMENTACION})
@Tag(description = "Gestiona el catálogo de frecuencias de alimentación", name = "Frecuencias de alimentación")
public class FrecuenciaAlimentacionController {
    private final GenericCRUDServiceImpl<FrecuenciaAlimentacion, FrecuenciaAlimentacionDTO> service;

    @Autowired
    public FrecuenciaAlimentacionController(
            @Qualifier("frecuenciaAlimentacionServiceImpl") GenericCRUDServiceImpl<FrecuenciaAlimentacion, FrecuenciaAlimentacionDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas las frecuencias de alimentación")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FrecuenciaAlimentacionDTO>> getAll() {
        FrecuenciaAlimentacionDTO dto = new FrecuenciaAlimentacionDTO();
        return new ResponseEntity<>(service.findAll(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una frecuencia de alimentación por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<FrecuenciaAlimentacionDTO> retrieve(
            @Parameter(description = "El ID de la frecuencia de alimnetación", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nueva frecuencia de alimentación")
    public ResponseEntity<FrecuenciaAlimentacionDTO> save(@RequestBody FrecuenciaAlimentacionDTO frecuenciaAlimentacionDTO) {
        return new ResponseEntity<>(service.saveOrUpdate(frecuenciaAlimentacionDTO), HttpStatus.CREATED);
    }
}
