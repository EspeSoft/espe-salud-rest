package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.ConsumoNocivoDTO;
import com.espe.salud.service.antecedente.ConsumoNocivoService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_CON_NOC;

@RestController
@Tag(description = "Gestiona los consumos nocivos de los pacientes", name = "Consumos nocivos")
@RequestMapping(value = {URI_API_V1_CON_NOC})
public class ConsumoNocivoController {

    private final ConsumoNocivoService service;

    @Autowired
    public ConsumoNocivoController(ConsumoNocivoService consumoNocivoService) {
        this.service = consumoNocivoService;
    }

    @Operation(summary = "Retorna el listado de los consumos nocivos de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ConsumoNocivoDTO>> findByPaciente (
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un consumo nocivo por por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConsumoNocivoDTO> getById(
            @Parameter(description = "ID del consumo nocivo", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita un consumo nocivo por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConsumoNocivoDTO> update(
            @Valid @RequestBody ConsumoNocivoDTO dto, @PathVariable("id") Long id) {
        Optional<ConsumoNocivoDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }


    @Operation(summary = "Guardar un nuevo consumo nocivo")
    @PostMapping("/")
    public ResponseEntity<ConsumoNocivoDTO> save(@Valid @RequestBody ConsumoNocivoDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un consumo nocivo por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del consumo nocivo", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
