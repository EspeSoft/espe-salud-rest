package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliarDTO;
import com.espe.salud.service.antecedente.AntecedentePatologicoFamiliarService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ANTE_PAT_FAM;

@RestController
@Tag(description = "Gestiona antecedentes patológicos familiares de un paciente", name = "Antecedentes patológicos familiares")
@RequestMapping(value = {URI_API_V1_ANTE_PAT_FAM})
public class AntecedentePatologicoFamiliarController {

    private final AntecedentePatologicoFamiliarService service;

    @Autowired
    public AntecedentePatologicoFamiliarController(AntecedentePatologicoFamiliarService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de los antecedentes patológicos familiares de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedentePatologicoFamiliarDTO>> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente patológico familiar por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePatologicoFamiliarDTO> getById(
            @Parameter(description = "ID del antecedente patológico familiar", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita un antecedente patológico familiar por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePatologicoFamiliarDTO> update(
            @Valid @RequestBody AntecedentePatologicoFamiliarDTO dto, @PathVariable("id") Long id) {
        Optional<AntecedentePatologicoFamiliarDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }


    @Operation(summary = "Guardar un nuevo antecedente patológico familiar")
    @PostMapping("/")
    public ResponseEntity<AntecedentePatologicoFamiliarDTO> save(@Valid @RequestBody AntecedentePatologicoFamiliarDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente patológico familiar por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del antecedente patológico familiar", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}