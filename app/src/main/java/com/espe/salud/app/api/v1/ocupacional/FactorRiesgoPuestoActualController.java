package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.FactorRiesgoPuestoActualDTO;
import com.espe.salud.dto.ocupacional.FactorRiesgoPuestoActualDTO;
import com.espe.salud.service.ocupacional.FactorRiesgoPuestoActualService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_ACC_TRA;
import static com.espe.salud.app.common.Constants.URI_API_V1_FAC_RIE_PUE_ACT;

@RestController
@Tag(description = "Gestiona los factores de riesgos del puesto actual", name = "Factores de Riesgos del Puesto Actual")
@RequestMapping(value = URI_API_V1_FAC_RIE_PUE_ACT)
public class FactorRiesgoPuestoActualController {
    private final FactorRiesgoPuestoActualService serviceFactor;

    @Autowired
    public FactorRiesgoPuestoActualController(
            @Qualifier("factorRiesgoPuestoActualServiceImpl") FactorRiesgoPuestoActualService serviceFactor
    ) {
        this.serviceFactor = serviceFactor;
    }

    @Operation(summary = "Retorna las factores de riesgos del puesto actual de un antecedente laboral")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<List<FactorRiesgoPuestoActualDTO>> retrieveByAntecedenteLaboral(
            @Parameter(description = "El ID de un Antecedente Laboral", required = true, example = "1")
            @RequestParam Long idAntecedente
    ) {
        return new ResponseEntity<>(serviceFactor.findByAntecedenteLaboral(idAntecedente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un factor por su id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<FactorRiesgoPuestoActualDTO> retrieve(
            @Parameter(description = "El ID del factor de riesgo", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(serviceFactor.findByCodigo(id), HttpStatus.OK);
    }

    @Operation(summary = "Guarda un nuevo factor de riesgo")
    @PostMapping("")
    public ResponseEntity<FactorRiesgoPuestoActualDTO> save(@RequestBody FactorRiesgoPuestoActualDTO antecedente) {
        return new ResponseEntity<>(serviceFactor.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un factor de riesgo por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "El ID del factor de riesgo del puesto actual", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(serviceFactor.delete(id), HttpStatus.OK);
    }

    @Operation(summary = "Edita un factor de riesgo por su id")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FactorRiesgoPuestoActualDTO> update(
            @RequestBody FactorRiesgoPuestoActualDTO antecedenteDTO,
            @Parameter(description = "El ID del factor de riesgo", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        Optional<FactorRiesgoPuestoActualDTO> newFactorRiesgoPuestoActualDTOoptional = serviceFactor.findByCodigo(id);
        FactorRiesgoPuestoActualDTO newFactorRiesgoPuestoActualDTO = newFactorRiesgoPuestoActualDTOoptional.get();
        return new ResponseEntity<>(serviceFactor.update(newFactorRiesgoPuestoActualDTO), HttpStatus.CREATED);
    }

}
