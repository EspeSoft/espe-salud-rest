package com.espe.salud.app.api.v1.odontologia;

import com.espe.salud.dto.odontologia.ExamenSistemaEstomatognaticoDTO;
import com.espe.salud.service.odontologia.ExamenSistemaEstomatognaticoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_EXA_SIS_EST;

@RestController
@Tag(name = "Gestiona los exámenes de sistema estomatognático de un paciente")
@RequestMapping(value = {URI_API_V1_EXA_SIS_EST})
public class ExamenSistemaEstomatognaticoController {

    private final ExamenSistemaEstomatognaticoService examenSistemaEstomatognaticoService;

    public ExamenSistemaEstomatognaticoController(ExamenSistemaEstomatognaticoService examenSistemaEstomatognaticoService) {
        this.examenSistemaEstomatognaticoService = examenSistemaEstomatognaticoService;
    }

    @PostMapping("")
    @Operation(summary = "Guarda y retorna una nueva exámen del sistema estomatognático")
    public ResponseEntity<ExamenSistemaEstomatognaticoDTO> save(@RequestBody ExamenSistemaEstomatognaticoDTO examenSistemaEstomatognaticoDTO) {
        return new ResponseEntity<>(examenSistemaEstomatognaticoService.save(examenSistemaEstomatognaticoDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/historiaClinica", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Retorna una lista de exámenes del sistema estomatognático de un paciente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<List<ExamenSistemaEstomatognaticoDTO>> getByHistoriaClinica(
            @Parameter(required = true, description = "El ID de la historia clinica", example = "1")
            @RequestParam Long historiaClinica) {
        return new ResponseEntity<>(examenSistemaEstomatognaticoService.findByHistoriaClinica(historiaClinica), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un exámen del sistema estomatognático por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<ExamenSistemaEstomatognaticoDTO> retrieve(
            @Parameter(description = "El ID del exámen", required = true, example = "1")
            @PathVariable("id") Long id) {
        return examenSistemaEstomatognaticoService.findById(id)
                .map(examenSistemaEstomatognaticoDTO -> new ResponseEntity<>(examenSistemaEstomatognaticoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Elimina una historia clínica por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        examenSistemaEstomatognaticoService.delete(codigo);
    }

    @Operation(summary = "Actualiza una historia clínica por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExamenSistemaEstomatognaticoDTO> update(
            @RequestBody ExamenSistemaEstomatognaticoDTO dto,
            @PathVariable Long codigo) {
        Optional<ExamenSistemaEstomatognaticoDTO> examenSistemaEstomatognaticoDTOOptional = examenSistemaEstomatognaticoService.findById(codigo);
        if (examenSistemaEstomatognaticoDTOOptional.isPresent()) {
            ExamenSistemaEstomatognaticoDTO ExamenSistemaEstomatognaticoDTO = examenSistemaEstomatognaticoDTOOptional.get();
            ExamenSistemaEstomatognaticoDTO.setCodigoCIEAsociado(dto.getCodigoCIEAsociado());
            ExamenSistemaEstomatognaticoDTO.setUnidadEstomatognatica(dto.getUnidadEstomatognatica());
            return new ResponseEntity<>(examenSistemaEstomatognaticoService.update(ExamenSistemaEstomatognaticoDTO), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
