package com.espe.salud.app.api.v1.odontologia;

import com.espe.salud.dto.odontologia.IndicadorSaludBucalDTO;
import com.espe.salud.service.odontologia.IndicadorSaludBucalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_IND_SAL_BUC;

@RestController
@Tag(name = "Gestiona los indicadores de salud bucal de un paciente")
@RequestMapping(value = {URI_API_V1_IND_SAL_BUC})
public class IndicadorSaludBucalController {

    private final IndicadorSaludBucalService indicadorSaludBucalService;

    @Autowired
    public IndicadorSaludBucalController(IndicadorSaludBucalService IndicadorSaludBucalService) {
        this.indicadorSaludBucalService = IndicadorSaludBucalService;
    }

    @PostMapping("")
    @Operation(summary = "Guarda y retorna un indicador de salud bucal")
    public ResponseEntity<IndicadorSaludBucalDTO> save(@RequestBody IndicadorSaludBucalDTO indicadorSaludBucalDTO) {
        return new ResponseEntity<>(indicadorSaludBucalService.save(indicadorSaludBucalDTO), HttpStatus.CREATED);
    }


    @GetMapping(value = "/historiaClinica", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Retorna una lista de indicadores de salud bucal de un paciente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<List<IndicadorSaludBucalDTO>> getByHistoriaClinica(
            @Parameter(required = true, description = "El ID de la historia clinica", example = "1")
            @RequestParam Long historiaClinica) {
        return new ResponseEntity<>(indicadorSaludBucalService.findByHistoriaClinica(historiaClinica), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un indicador de salud bucal por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<IndicadorSaludBucalDTO> retrieve(
            @Parameter(description = "El ID del indicador de salud bucal", required = true, example = "1")
            @PathVariable("id") Long id) {
        return indicadorSaludBucalService.findById(id)
                .map(IndicadorSaludBucalDTO -> new ResponseEntity<>(IndicadorSaludBucalDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Elimina una historia clínica por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        indicadorSaludBucalService.delete(codigo);
    }

    @Operation(summary = "Actualiza un indicador de salud bucal por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<IndicadorSaludBucalDTO> update(
            @RequestBody IndicadorSaludBucalDTO dto,
            @PathVariable Long codigo) {
        Optional<IndicadorSaludBucalDTO> indicadorSaludBucalDTOOptional = indicadorSaludBucalService.findById(codigo);
        if (indicadorSaludBucalDTOOptional.isPresent()) {
            IndicadorSaludBucalDTO IndicadorSaludBucalDTO = indicadorSaludBucalDTOOptional.get();
            IndicadorSaludBucalDTO.setNivelEnfermedadPeriodontal(dto.getNivelEnfermedadPeriodontal());
            IndicadorSaludBucalDTO.setNivelFluorosis(dto.getNivelFluorosis());
            IndicadorSaludBucalDTO.setNivelMaloclusion(dto.getNivelMaloclusion());
            return new ResponseEntity<>(indicadorSaludBucalService.update(IndicadorSaludBucalDTO), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
