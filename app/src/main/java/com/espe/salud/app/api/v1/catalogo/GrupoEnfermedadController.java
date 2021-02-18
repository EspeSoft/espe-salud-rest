package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.GrupoEnfermedadDTO;
import com.espe.salud.service.catalogo.GrupoEnfermedadService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_GRUPO_ENFERMEDAD;

@RestController
@RequestMapping(value = {URI_API_V1_GRUPO_ENFERMEDAD})
@Tag(description = "Gestiona el catálogo de los grupos de enfermedades CIE10", name = "Grupos de enfermedad CIE10")
public class GrupoEnfermedadController {
    private final GrupoEnfermedadService grupoEnfermedadService;

    @Autowired
    public GrupoEnfermedadController(GrupoEnfermedadService grupoEnfermedadService) {
        this.grupoEnfermedadService = grupoEnfermedadService;
    }

    @Operation(summary = "Retorna el listado de todos los grupos de enfermedades CIE10")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<GrupoEnfermedadDTO>> getAll() {
        return new ResponseEntity<>( grupoEnfermedadService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un grupo de enfermedad por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<GrupoEnfermedadDTO> retrieve(
            @Parameter(description = "El ID del grupo de enfermedad", required = true, example = "A00")
            @PathVariable("id") String id) {
        return grupoEnfermedadService.findById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo grupo de enfermedad CIE10")
    public ResponseEntity<GrupoEnfermedadDTO> save(@Valid @RequestBody GrupoEnfermedadDTO grupoEnfermedadDTO){
        return new ResponseEntity<>(grupoEnfermedadService.save(grupoEnfermedadDTO), HttpStatus.CREATED);
    }
}
