package com.espe.salud.app.api.v1.paciente;

import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.dto.paciente.ContactoEmergenciaDTO;
import com.espe.salud.service.paciente.ContactoEmergenciaService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_CONTACTOS_EMERGENCIA;

@RestController
@RequestMapping(value = {URI_API_V1_CONTACTOS_EMERGENCIA})
@Tag(description = "Gestiona los contactos de emergencia", name = "Contactos de emergencia de un paciente")
public class ContactoEmergenciaController {
    private final ContactoEmergenciaService service;

    @Autowired
    public ContactoEmergenciaController(ContactoEmergenciaService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna los contactos de emergencia de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ContactoEmergenciaDTO>> findBypaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente
    ) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo contacto de emergencia")
    public ResponseEntity<ContactoEmergenciaDTO> save(
            @RequestBody ContactoEmergenciaDTO contactoEmergenciaDTO,
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.save(contactoEmergenciaDTO, idPaciente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/paciente")
    @Operation(summary = "Actualiza un contacto de emergencia")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ContactoEmergenciaDTO> update(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente,
            @Valid @RequestBody ContactoEmergenciaDTO dto,
            @Parameter(description = "El ID del contacto de emergencia", required = true, example = "1")
            @PathVariable("id") Long id) {
        Optional<ContactoEmergenciaDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto, idPaciente), HttpStatus.OK);
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un contacto de emergencia por su ID")
    public ResponseEntity<Boolean> delete(
            @Parameter(required = true, description = "El ID del contacto de emergencia", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
