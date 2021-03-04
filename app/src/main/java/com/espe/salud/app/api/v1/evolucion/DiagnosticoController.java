package com.espe.salud.app.api.v1.evolucion;

import com.espe.salud.dto.evolucion.DiagnosticoDTO;
import com.espe.salud.service.evolucion.DiagnosticoService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_DIA;

@RestController
@Tag(description = "Gestiona los diagnostico de antecedentes", name = "Diagnósticos")
@RequestMapping(value = URI_API_V1_DIA)
public class DiagnosticoController {
    private final DiagnosticoService  diagnosticoService;

    @Autowired
    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @Operation(summary = "Retorna un diagnostico por su código")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiagnosticoDTO> getById(@PathVariable Long id) {
        return diagnosticoService.findById(id)
                .map(diag -> new ResponseEntity<>(diag, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Retorna los diagnósticos de una evolución")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/evolucion", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DiagnosticoDTO>> getByEvolucion(
            @Parameter(required = true, description = "El ID de evolución", example = "EV_0000001")
            @RequestParam String idEvolucion) {
        return new ResponseEntity<>( diagnosticoService.findByEvolucion(idEvolucion), HttpStatus.OK);
    }

    @Operation(summary = "Edita un diagnostico por su código")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiagnosticoDTO> update(@RequestBody DiagnosticoDTO diagnosticoDTO, @PathVariable Long id) {
        Optional<DiagnosticoDTO> newDiagnosticoDTOoptional = diagnosticoService.findById(id);
        if (newDiagnosticoDTOoptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(diagnosticoService.update(diagnosticoDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Guarda un nuevo diagnostico")
    @PostMapping("/")
    public ResponseEntity<DiagnosticoDTO> save(@Valid @RequestBody DiagnosticoDTO diagnostico){
        return new ResponseEntity<>(diagnosticoService.save(diagnostico), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un diagnostico por su código")
    @DeleteMapping("/{codigo}")
    public boolean delete(@PathVariable Long codigo) {
        return diagnosticoService.delete(codigo);
    }

}
