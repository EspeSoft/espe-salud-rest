package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.HospitalizacionDTO;
import com.espe.salud.service.antecedente.HospitalizacionService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_HOS;

@RestController
@RequestMapping(value = {URI_API_V1_HOS})
@Tag(description = "Gestiona el catálogo de hospitalizaciones", name = "Hospitalizaciones")
public class HospitalizacionController {

    private final HospitalizacionService service;

    @Autowired
    public HospitalizacionController(HospitalizacionService service) {
        this.service = service;
    }


    @Operation(summary = "Retorna el listado de todas las hospitalizaciones de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<HospitalizacionDTO>> findByPaciente(
            @Parameter(description = "El ID de un paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nueva hospitalización")
    public ResponseEntity<HospitalizacionDTO> save(@RequestBody HospitalizacionDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una hospitalización por su ID")
    public ResponseEntity<Boolean> delete(
            @Parameter(required = true, description = "El ID de una hospitalización", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una hospitalización")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<HospitalizacionDTO> update(@Valid @RequestBody HospitalizacionDTO dto,
                                                           @Parameter(description = "El ID de una hospitalización", required = true, example = "1")
                                                           @PathVariable("id") Long id) {
        Optional<HospitalizacionDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una hospitalización por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<HospitalizacionDTO> retrieve(
            @Parameter(description = "El ID de la hospitalización", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(hos -> new ResponseEntity<>(hos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
