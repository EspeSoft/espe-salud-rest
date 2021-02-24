package com.espe.salud.app.api.v1.examen;

import com.espe.salud.dto.examen.ExamenExternoDTO;
import com.espe.salud.service.examen.ExamenExternoService;
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
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_EXAMEN_EXTERNO;

@RestController
@RequestMapping(value = {URI_API_V1_EXAMEN_EXTERNO})
@Tag(description = "Gestiona los exámenes externos de un paciente", name = "Examenes externos")
public class ExamenExternoController {

    private final ExamenExternoService service;

    @Autowired
    public ExamenExternoController(ExamenExternoService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de los examenes externos de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ExamenExternoDTO>> findByPaciente(
            @Parameter(description = "El ID de un paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>( service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo examen externo")
    public ResponseEntity<ExamenExternoDTO> save(@Valid @RequestBody ExamenExternoDTO dto){
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un examen externo por su ID")
    public ResponseEntity<Boolean> delete(
            @Parameter(required = true, description = "El ID del examen externo", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un examen externo")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ExamenExternoDTO> update(
            @Valid @RequestBody ExamenExternoDTO dto,
            @Parameter(description = "El ID del examen externo", required = true, example = "1")
            @PathVariable("id") Long id) {
        Optional<ExamenExternoDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            ExamenExternoDTO nuevo = optional.get();
            nuevo.setDescripcion(dto.getDescripcion());
            nuevo.setIdArea(dto.getIdArea());
            nuevo.setIdRegion(dto.getIdRegion());
            return new ResponseEntity<>( service.update(nuevo), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un examen externo por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ExamenExternoDTO> retrieve(
            @Parameter(description = "El ID del examen externo", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(examen -> new ResponseEntity<>(examen, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
