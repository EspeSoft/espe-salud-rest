package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.ActividadFisicaDTO;
import com.espe.salud.service.antecedente.ActividadFisicaService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ACT_FIS;

@RestController
@Tag(description = "Gestiona las actividades fisicas de un paciente", name = "Actividades fisicas")
@RequestMapping(value = {URI_API_V1_ACT_FIS})
public class ActividadFisicaController {
    private final ActividadFisicaService service;

    @Autowired
    public ActividadFisicaController(ActividadFisicaService actividadFisicaService) {
        this.service = actividadFisicaService;
    }

    @Operation(summary = "Retorna el listado de los antecedentes físicos de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ActividadFisicaDTO>> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente fisico por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActividadFisicaDTO> getById(
            @Parameter(description = "ID del antecedente fisico", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita un antecedente fisico por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActividadFisicaDTO> update(
            @Valid @RequestBody ActividadFisicaDTO dto, @PathVariable("id") Long id) {
        Optional<ActividadFisicaDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }

    @Operation(summary = "Guardar un nuevo antecedente fisico")
    @PostMapping("/")
    public ResponseEntity<ActividadFisicaDTO> save(@Valid @RequestBody ActividadFisicaDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente fisico por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del antecedente fisico", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
