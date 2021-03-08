package com.espe.salud.app.api.v1.evolucion;

import com.espe.salud.dto.evolucion.PrescripcionDTO;
import com.espe.salud.service.evolucion.PrescripcionService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_PRESC;

@RestController
@Tag(description = "Gestiona las prescripciones de una evolución", name = "Prescripciones")
@RequestMapping(value = URI_API_V1_PRESC)
public class PrescripcionController {
    private final PrescripcionService service;

    @Autowired
    public PrescripcionController(PrescripcionService service) {
        this.service = service;
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nueva prescripción")
    public ResponseEntity<PrescripcionDTO> save(@RequestBody PrescripcionDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una prescripción por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<PrescripcionDTO> getById(
            @Parameter(description = "El ID de la prescripción", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Elimina una prescripción por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(required = true, description = "El ID de la prescripción", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @Operation(summary = "Retorna las prescripciones de una evolución")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/evolucion", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PrescripcionDTO>> getByEvolucion(
            @Parameter(required = true, description = "El ID de evolución", example = "EV_0000001")
            @RequestParam String idEvolucion) {
        return new ResponseEntity<>( service.findByEvolucion(idEvolucion), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una prescripción ")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<PrescripcionDTO> update(
            @Valid @RequestBody PrescripcionDTO dto,
            @Parameter(description = "El ID de la prescripción ", required = true, example = "1")
            @PathVariable("id") Long id) {
        Optional<PrescripcionDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            PrescripcionDTO nuevo = optional.get();
            nuevo.setCantidad(dto.getCantidad());
            nuevo.setDosis(dto.getDosis());
            nuevo.setPresentacion(dto.getPresentacion());
            nuevo.setIndicacion(dto.getIndicacion());
            nuevo.setMedicamento(dto.getMedicamento());
            return new ResponseEntity<>( service.update(nuevo), HttpStatus.OK);
        }
    }


}
