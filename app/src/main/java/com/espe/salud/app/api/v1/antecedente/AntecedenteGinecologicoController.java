package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.AntecedenteGinecologicoDTO;
import com.espe.salud.service.antecedente.AntecedenteGinecologicoService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ANTGIN;

@RestController
@Tag(description = "Gestiona los antecedentes ginecológicos de un paciente", name = "Antecedentes ginecológicos")
@RequestMapping(value = {URI_API_V1_ANTGIN})
public class AntecedenteGinecologicoController {

    private final AntecedenteGinecologicoService service;

    @Autowired
    public AntecedenteGinecologicoController(AntecedenteGinecologicoService service) {
        this.service = service;
    }


    @Operation(summary = "Retorna el listado de los antecedentes ginecológicos de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteGinecologicoDTO>> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente ginecológico por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteGinecologicoDTO> getById(
            @Parameter(description = "ID del antecedente ginecológico", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita un antecedente ginecológico por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteGinecologicoDTO> update(
            @Valid @RequestBody AntecedenteGinecologicoDTO dto, @PathVariable("id") Long id) {
        Optional<AntecedenteGinecologicoDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }

    @Operation(summary = "Guardar un nuevo antecedente ginecológico")
    @PostMapping("/")
    public ResponseEntity<AntecedenteGinecologicoDTO> save(@Valid @RequestBody AntecedenteGinecologicoDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente ginecológico por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del antecedente ginecológico", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
