package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
import com.espe.salud.service.ocupacional.AntecedenteEmpleoAnteriorService;
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
import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_EMP_ANT;

@RestController
@Tag(description = "Gestiona los antecedentes de empleos anteriores", name = "Antecedentes de Empleos Anteriores")
@RequestMapping(value = URI_API_V1_ANT_EMP_ANT)
public class AntecedenteEmpleoAnteriorController {
    private final AntecedenteEmpleoAnteriorService serviceAntecedente;

    @Autowired
    public AntecedenteEmpleoAnteriorController(
            @Qualifier("antecedenteEmpleoAnteriorServiceImpl") AntecedenteEmpleoAnteriorService serviceAntecedente
    ) {
        this.serviceAntecedente = serviceAntecedente;
    }

    @Operation(summary = "Retorna las antecedentes de empleos anteriores de un antecedente laboral")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<List<AntecedenteEmpleoAnteriorDTO>> retrieveByAntecedenteLaboral(
            @Parameter(description = "El ID de un Antecedente Laboral", required = true, example = "1")
            @RequestParam Long idAntecedente
    ) {
        return new ResponseEntity<>(serviceAntecedente.findByAntecedenteLaboral(idAntecedente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> retrieve(
            @Parameter(description = "El ID de la actividad extralaboral", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(id), HttpStatus.OK);
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("")
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> save(@RequestBody AntecedenteEmpleoAnteriorDTO antecedente) {
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{id}")
    public void delete(
            @Parameter(description = "El ID del antecedente de empleo anterior", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        serviceAntecedente.delete(id);
    }

    @Operation(summary = "Edita un antecedente por su id")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> update(
            @RequestBody AntecedenteEmpleoAnteriorDTO antecedenteDTO,
            @Parameter(description = "El ID del antecedente de empleo anterior", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        Optional<AntecedenteEmpleoAnteriorDTO> newAntecedenteEmpleoAnteriorDTOoptional = serviceAntecedente.findByCodigo(id);
        AntecedenteEmpleoAnteriorDTO newAntecedenteEmpleoAnteriorDTO = newAntecedenteEmpleoAnteriorDTOoptional.get();
        newAntecedenteEmpleoAnteriorDTO.setActividad(antecedenteDTO.getActividad());
        newAntecedenteEmpleoAnteriorDTO.setEmpresa(antecedenteDTO.getEmpresa());
        newAntecedenteEmpleoAnteriorDTO.setMeses(antecedenteDTO.getMeses());
        newAntecedenteEmpleoAnteriorDTO.setObservacion(antecedenteDTO.getObservacion());
        newAntecedenteEmpleoAnteriorDTO.setPuestoTrabajo(antecedenteDTO.getPuestoTrabajo());
        newAntecedenteEmpleoAnteriorDTO.setUsabanSeguridad(antecedenteDTO.getUsabanSeguridad());
        newAntecedenteEmpleoAnteriorDTO.setVigilanciaSalud(antecedenteDTO.getVigilanciaSalud());
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteEmpleoAnteriorDTO), HttpStatus.CREATED);
    }
}
