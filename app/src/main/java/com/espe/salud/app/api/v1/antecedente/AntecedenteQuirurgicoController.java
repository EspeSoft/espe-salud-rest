package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;
import com.espe.salud.service.antecedente.AntecedenteQuirurgicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANTE_QUIRURGICO;

@RestController
@Tag(description = "Gestiona los antecedente quirúrgicos de un paciente", name = "Antecedentes quirúrgicos")
@RequestMapping(value = {URI_API_V1_ANTE_QUIRURGICO})
public class AntecedenteQuirurgicoController {

    private final AntecedenteQuirurgicoService service;

    @Autowired
    public AntecedenteQuirurgicoController(AntecedenteQuirurgicoService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de los antecedentes quirúrgicos de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteQuirurgicoDTO>> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente quirúrgico por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteQuirurgicoDTO> getById(
            @Parameter(description = "ID del antecedente quirúrgicos", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita un antecedente quirúrgico por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteQuirurgicoDTO> update(
            @Valid @RequestBody AntecedenteQuirurgicoDTO dto, @PathVariable("id") Long id) {
        Optional<AntecedenteQuirurgicoDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }

    @Operation(summary = "Guardar un nuevo antecedente quirúrgico")
    @PostMapping("/")
    public ResponseEntity<AntecedenteQuirurgicoDTO> save(@Valid @RequestBody AntecedenteQuirurgicoDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente quirúrgico por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del antecedente quirúrgico", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}