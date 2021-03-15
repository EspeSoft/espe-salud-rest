package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.PlanificacionFamiliarDTO;
import com.espe.salud.service.antecedente.PlanificacionFamiliarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_PLAFAM;

@RestController
@Tag(description = "Gestiona las planificaciones familiares de un paciente", name = "Planificaciones familiares")
@RequestMapping(value = {URI_API_V1_PLAFAM})
public class PlanificacionFamiliarController {

    private final PlanificacionFamiliarService service;

    @Autowired
    public PlanificacionFamiliarController(PlanificacionFamiliarService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de las planificaciones familiares de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PlanificacionFamiliarDTO>> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un planificación familiar por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PlanificacionFamiliarDTO> getById(
            @Parameter(description = "ID de la planificación familiar", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita una planificación familiar por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PlanificacionFamiliarDTO> update(
            @Valid @RequestBody PlanificacionFamiliarDTO dto,
            @PathVariable("id") Long id) {
        Optional<PlanificacionFamiliarDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }

    @Operation(summary = "Guarda una nueva planificación familiar")
    @PostMapping("/")
    public ResponseEntity<PlanificacionFamiliarDTO> save(@Valid @RequestBody PlanificacionFamiliarDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina una planificación familiar por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID de la planificación familiar", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}


