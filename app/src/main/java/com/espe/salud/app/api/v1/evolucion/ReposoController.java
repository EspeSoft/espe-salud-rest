package com.espe.salud.app.api.v1.evolucion;

import com.espe.salud.dto.evolucion.ReposoDTO;
import com.espe.salud.service.evolucion.ReposoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.espe.salud.app.common.Constants.URI_API_V1_CERT_REPO;

@RestController
@Tag(description = "Gestiona la clase reposo para el certificado de una evolución", name = "Reposos")
@RequestMapping(value = {URI_API_V1_CERT_REPO})
public class ReposoController {
    private final ReposoService service;

    @Autowired
    public ReposoController(ReposoService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna los reposos de una evolucion")
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping("/")
    public ResponseEntity<ReposoDTO> save(@Valid @RequestBody ReposoDTO evolucion) {
        return new ResponseEntity<>(service.save(evolucion), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un reposo por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ReposoDTO> getById(
            @Parameter(description = "El ID del reposo", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
