package com.espe.salud.app.api.v1.antecedente;


import com.espe.salud.dto.antecedente.AntecedentePatologicoPersonalDTO;
import com.espe.salud.service.antecedente.AntecedentePatologicoPersonalService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_PATOLOGICO_PERSONAL;

@RestController
@Tag(description = "Gestiona antecedentes patologicos personales", name = "Antecedentes patológicos personales")
@RequestMapping(value = {URI_API_V1_ANT_PATOLOGICO_PERSONAL})
public class AntecedentePatologicoPersonalController {

    private final AntecedentePatologicoPersonalService service;

    @Autowired
    public AntecedentePatologicoPersonalController(AntecedentePatologicoPersonalService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de los antecedentes patologicos personales por antecedente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedentePatologicoPersonalDTO>> findByAntecedente(
            @Parameter(description = "El ID del antecedente", required = true, example = "1")
            @RequestParam Long idAntecedente) {
        return new ResponseEntity<>(service.findByAntecedente(idAntecedente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente patologico personal por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePatologicoPersonalDTO> getById(
            @Parameter(description = "ID del antecedente patológico personal", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita un antecedente patologico personal por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePatologicoPersonalDTO> update(
            @Valid @RequestBody AntecedentePatologicoPersonalDTO dto, @PathVariable("id") Long id) {
        Optional<AntecedentePatologicoPersonalDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.ACCEPTED);
        }
    }

    @Operation(summary = "Guardar un nuevo antecedente patologico personal")
    @PostMapping("/")
    public ResponseEntity<AntecedentePatologicoPersonalDTO> save(@Valid @RequestBody AntecedentePatologicoPersonalDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente patologico personal por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del antecedente patológico personal", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
