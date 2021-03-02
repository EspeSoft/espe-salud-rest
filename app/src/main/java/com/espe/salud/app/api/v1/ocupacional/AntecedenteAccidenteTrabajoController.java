package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.dto.ocupacional.ActividadExtralaboralDTO;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;
import com.espe.salud.service.ocupacional.AntecedenteAccidenteTrabajoService;
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

@RestController
@Tag(description = "Gestiona los antecedentes de accidente de trabajo", name = "Antecedentes de Accidente de Trabajo")
@RequestMapping(value = URI_API_V1_ANT_ACC_TRA)
public class AntecedenteAccidenteTrabajoController {
    private final AntecedenteAccidenteTrabajoService serviceAntecedente;

    @Autowired
    public AntecedenteAccidenteTrabajoController(
            @Qualifier("antecedenteAccidenteTrabajoServiceImpl") AntecedenteAccidenteTrabajoService serviceAntecedente
    ) {
        this.serviceAntecedente = serviceAntecedente;
    }

    @Operation(summary = "Retorna las antecedentes de accidentes de trabajo de un antecedente laboral")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<List<AntecedenteAccidenteTrabajoDTO>> retrieveByAntecedenteLaboral(
            @Parameter(description = "El ID de un Antecedente Laboral", required = true, example = "1")
            @RequestParam Long idAntecedente
    ) {
        return new ResponseEntity<>(serviceAntecedente.findByAntecedenteLaboral(idAntecedente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<AntecedenteAccidenteTrabajoDTO> retrieve(
            @Parameter(description = "El ID de la actividad extralaboral", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(id), HttpStatus.OK);
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("")
    public ResponseEntity<AntecedenteAccidenteTrabajoDTO> save(@RequestBody AntecedenteAccidenteTrabajoDTO antecedente) {
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{id}")
    public void delete(
            @Parameter(description = "El ID del antecedente por accidente de trabajo", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        serviceAntecedente.delete(id);
    }

    @Operation(summary = "Edita un antecedente por su id")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteAccidenteTrabajoDTO> update(
            @RequestBody AntecedenteAccidenteTrabajoDTO antecedenteDTO,
            @Parameter(description = "El ID del antecedente por accidente de trabajo", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        Optional<AntecedenteAccidenteTrabajoDTO> newAntecedenteAccidenteTrabajoDTOoptional = serviceAntecedente.findByCodigo(id);
        AntecedenteAccidenteTrabajoDTO newAntecedenteAccidenteTrabajoDTO = newAntecedenteAccidenteTrabajoDTOoptional.get();
        newAntecedenteAccidenteTrabajoDTO.setLugarAtencion(antecedenteDTO.getLugarAtencion());
        newAntecedenteAccidenteTrabajoDTO.setNaturaleza(antecedenteDTO.getNaturaleza());
        newAntecedenteAccidenteTrabajoDTO.setParteCuerpoAfectada(antecedenteDTO.getParteCuerpoAfectada());
        newAntecedenteAccidenteTrabajoDTO.setEmpresa(antecedenteDTO.getEmpresa());
        newAntecedenteAccidenteTrabajoDTO.setFecha(antecedenteDTO.getFecha());
        newAntecedenteAccidenteTrabajoDTO.setHorasReposo(antecedenteDTO.getHorasReposo());
        newAntecedenteAccidenteTrabajoDTO.setObservaciones(antecedenteDTO.getObservaciones());
        newAntecedenteAccidenteTrabajoDTO.setRecibioAtencion(antecedenteDTO.getRecibioAtencion());
        newAntecedenteAccidenteTrabajoDTO.setRiesgoImplicado(antecedenteDTO.getRiesgoImplicado());
        newAntecedenteAccidenteTrabajoDTO.setSecuelas(antecedenteDTO.getSecuelas());
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteAccidenteTrabajoDTO), HttpStatus.CREATED);
    }
}
