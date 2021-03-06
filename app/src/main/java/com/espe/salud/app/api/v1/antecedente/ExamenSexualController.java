package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.ExamenSexualDTO;
import com.espe.salud.service.antecedente.ExamenSexualService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_EXASEX;

@RestController
@Tag(description = "Gestiona los examenes sexuales de un paciente", name = "Examenes sexuales")
@RequestMapping(value = {URI_API_V1_EXASEX})
public class ExamenSexualController {

    private final ExamenSexualService service;

    @Autowired
    public ExamenSexualController(ExamenSexualService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de los examenes sexuales de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ExamenSexualDTO>> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un examen sexual por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExamenSexualDTO> getById(
            @Parameter(description = "ID del examen sexual", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita un examen sexual por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExamenSexualDTO> update(
            @Valid @RequestBody ExamenSexualDTO dto, @PathVariable("id") Long id) {
        Optional<ExamenSexualDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }

    @Operation(summary = "Guardar un nuevo examen sexual")
    @PostMapping("/")
    public ResponseEntity<ExamenSexualDTO> save(@Valid @RequestBody ExamenSexualDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un examen sexual por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del examen sexual", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}

