package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import com.espe.salud.service.catalogo.EnfermedadCIE10Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_ENFERMEDAD_CIE10;

@RestController
@RequestMapping(value = {URI_API_V1_ENFERMEDAD_CIE10})
@Tag(description = "Gestiona el catálogo de enfermedades CIE10", name = "Enfermedades CIE10")
public class EnfermedadCIE10Controller {
    private final EnfermedadCIE10Service enfermedadCIE10Service;

    @Autowired
    public EnfermedadCIE10Controller(EnfermedadCIE10Service enfermedadCIE10Service) {
        this.enfermedadCIE10Service = enfermedadCIE10Service;
    }

    @Operation(summary = "Retorna el listado de todas las enfermedades CIE10")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EnfermedadCIE10DTO>> getAll() {
        return new ResponseEntity<>( enfermedadCIE10Service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una enfermedad CIE10 por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<EnfermedadCIE10DTO> retrieve(
            @Parameter(description = "El ID de la enfermedad CIE10", required = true, example = "Z000")
            @PathVariable("id") String id) {
        return enfermedadCIE10Service.findById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo grupo de enfermedad CIE10")
    public ResponseEntity<EnfermedadCIE10DTO> save(@Valid @RequestBody EnfermedadCIE10DTO enfermedadCIE10DTO){
        return new ResponseEntity<>(enfermedadCIE10Service.save(enfermedadCIE10DTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna el listado de todas las enfermedades CIE10 por el código o por el nombre")
    @GetMapping(value = "/findByCodigoOrNombre", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EnfermedadCIE10DTO>> findByCodigoOrNombre(
            @Parameter(description = "El nombre o código de la enfermedad CIE10", required = true, example = "Z00")
            @RequestParam String query) {
        return new ResponseEntity<>(enfermedadCIE10Service.findByCodigoOrNombre(query), HttpStatus.OK);
    }
}
