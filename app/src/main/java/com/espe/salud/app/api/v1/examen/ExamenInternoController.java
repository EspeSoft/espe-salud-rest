package com.espe.salud.app.api.v1.examen;

import com.espe.salud.dto.examen.ExamenInternoDTO;
import com.espe.salud.service.examen.ExamenInternoService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_EXAMEN_INTERNO;

@RestController
@RequestMapping(value = {URI_API_V1_EXAMEN_INTERNO})
@Tag(description = "Gestiona los exámenes internos de un paciente", name = "Examenes internos")
public class ExamenInternoController {

    private final ExamenInternoService service;

    @Autowired
    public ExamenInternoController(ExamenInternoService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de los examenes internos de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ExamenInternoDTO>> findByPaciente(
            @Parameter(description = "El ID de un paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo examen interno")
    public ResponseEntity<ExamenInternoDTO> save(@Valid @RequestBody ExamenInternoDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un examen interno por su ID")
    public ResponseEntity<Boolean> delete(
            @Parameter(required = true, description = "El ID del examen interno", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un examen interno")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ExamenInternoDTO> update(
            @Valid @RequestBody ExamenInternoDTO dto,
            @Parameter(description = "El ID del examen interno", required = true, example = "1")
            @PathVariable("id") Long id) {
        Optional<ExamenInternoDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            ExamenInternoDTO nuevo = optional.get();
            nuevo.setDescripcion(dto.getDescripcion());
            nuevo.setIdOrganoSistema(dto.getIdOrganoSistema());
            return new ResponseEntity<>(service.update(nuevo), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un examen interno por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ExamenInternoDTO> retrieve(
            @Parameter(description = "El ID del examen interno", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(examen -> new ResponseEntity<>(examen, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
