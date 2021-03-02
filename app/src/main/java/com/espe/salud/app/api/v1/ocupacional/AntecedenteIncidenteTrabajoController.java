package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.AntecedenteIncidenteTrabajoDTO;
import com.espe.salud.dto.ocupacional.AntecedenteIncidenteTrabajoDTO;
import com.espe.salud.service.ocupacional.AntecedenteIncidenteTrabajoService;
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
import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_INC_TRA;

@RestController
@Tag(description = "Gestiona los antecedentes de incidentes de trabajo", name = "Antecedentes de Incidentes de Trabajo")
@RequestMapping(value = URI_API_V1_ANT_INC_TRA)
public class AntecedenteIncidenteTrabajoController {
    private final AntecedenteIncidenteTrabajoService serviceAntecedente;

    @Autowired
    public AntecedenteIncidenteTrabajoController(
            @Qualifier("antecedenteIncidenteTrabajoServiceImpl") AntecedenteIncidenteTrabajoService serviceAntecedente
    ) {
        this.serviceAntecedente = serviceAntecedente;
    }

    @Operation(summary = "Retorna las antecedentes de incidentes de trabajo de un antecedente laboral")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<List<AntecedenteIncidenteTrabajoDTO>> retrieveByAntecedenteLaboral(
            @Parameter(description = "El ID de un Antecedente Laboral", required = true, example = "1")
            @RequestParam Long idAntecedente
    ) {
        return new ResponseEntity<>(serviceAntecedente.findByAntecedenteLaboral(idAntecedente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<AntecedenteIncidenteTrabajoDTO> retrieve(
            @Parameter(description = "El ID de la actividad extralaboral", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(id), HttpStatus.OK);
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("")
    public ResponseEntity<AntecedenteIncidenteTrabajoDTO> save(@RequestBody AntecedenteIncidenteTrabajoDTO antecedente) {
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{id}")
    public void delete(
            @Parameter(description = "El ID del antecedente por incidente de trabajo", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        serviceAntecedente.delete(id);
    }

    @Operation(summary = "Edita un antecedente por su id")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteIncidenteTrabajoDTO> update(
            @RequestBody AntecedenteIncidenteTrabajoDTO antecedenteDTO,
            @Parameter(description = "El ID del antecedente por incidente de trabajo", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        Optional<AntecedenteIncidenteTrabajoDTO> newAntecedenteIncidenteTrabajoDTOoptional = serviceAntecedente.findByCodigo(id);
        AntecedenteIncidenteTrabajoDTO newAntecedenteIncidenteTrabajoDTO = newAntecedenteIncidenteTrabajoDTOoptional.get();
        newAntecedenteIncidenteTrabajoDTO.setLugarAtencion(antecedenteDTO.getLugarAtencion());
        newAntecedenteIncidenteTrabajoDTO.setNaturaleza(antecedenteDTO.getNaturaleza());
        newAntecedenteIncidenteTrabajoDTO.setParteCuerpoAfectada(antecedenteDTO.getParteCuerpoAfectada());
        newAntecedenteIncidenteTrabajoDTO.setEmpresa(antecedenteDTO.getEmpresa());
        newAntecedenteIncidenteTrabajoDTO.setFecha(antecedenteDTO.getFecha());
        newAntecedenteIncidenteTrabajoDTO.setHorasReposo(antecedenteDTO.getHorasReposo());
        newAntecedenteIncidenteTrabajoDTO.setObservaciones(antecedenteDTO.getObservaciones());
        newAntecedenteIncidenteTrabajoDTO.setRecibioAtencion(antecedenteDTO.getRecibioAtencion());
        newAntecedenteIncidenteTrabajoDTO.setRiesgoImplicado(antecedenteDTO.getRiesgoImplicado());
        newAntecedenteIncidenteTrabajoDTO.setSecuelas(antecedenteDTO.getSecuelas());
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteIncidenteTrabajoDTO), HttpStatus.CREATED);
    }
}
