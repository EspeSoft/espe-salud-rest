package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.DiscapacidadDTO;
import com.espe.salud.service.antecedente.DiscapacidadService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_DISCAPACIDAD;

@RestController
@Tag(description = "Gestiona las discapacidad de un paciente", name = "Discapacidades")
@RequestMapping(value = {URI_API_V1_DISCAPACIDAD})
public class DiscapacidadController {

    private final DiscapacidadService service;

    @Autowired
    public DiscapacidadController(DiscapacidadService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas las discapacidades de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DiscapacidadDTO>> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna una discapacidad por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiscapacidadDTO> getById(
            @Parameter(description = "ID de la discapacidad", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(discapacidadDTO -> new ResponseEntity<>(discapacidadDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita una discapacidad por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiscapacidadDTO> update(
            @Valid @RequestBody DiscapacidadDTO dto, @PathVariable("id") Long id) {
        Optional<DiscapacidadDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }

    @Operation(summary = "Guardar una nueva discapacidad de un paciente")
    @PostMapping("/")
    public ResponseEntity<DiscapacidadDTO> save(@Valid @RequestBody DiscapacidadDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina una discapacidad por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID de la discapacidad", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
