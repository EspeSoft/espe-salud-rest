package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.AntecedenteIncidenteTrabajoDTO;
import com.espe.salud.service.ocupacional.AntecedenteIncidenteTrabajoService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Retorna el listado de todos los antecedentes")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteIncidenteTrabajoDTO>> getAll() {
        return new ResponseEntity<>( serviceAntecedente.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteIncidenteTrabajoDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteIncidenteTrabajoDTO> update(@RequestBody AntecedenteIncidenteTrabajoDTO antecedenteDTO, @RequestParam Long codigo) {
        Optional<AntecedenteIncidenteTrabajoDTO> newAntecedenteIncidenteTrabajoDTOoptional = serviceAntecedente.findByCodigo(codigo);
        AntecedenteIncidenteTrabajoDTO newAntecedenteIncidenteTrabajoDTO = newAntecedenteIncidenteTrabajoDTOoptional.get();
        newAntecedenteIncidenteTrabajoDTO.setLugarAtencion(antecedenteDTO.getLugarAtencion());
        newAntecedenteIncidenteTrabajoDTO.setNaturaleza(antecedenteDTO.getNaturaleza());
        newAntecedenteIncidenteTrabajoDTO.setParteCuerpoAfectada(antecedenteDTO.getParteCuerpoAfectada());
        newAntecedenteIncidenteTrabajoDTO.setEmpresa(antecedenteDTO.getEmpresa());
        newAntecedenteIncidenteTrabajoDTO.setFecha(antecedenteDTO.getFecha());
        newAntecedenteIncidenteTrabajoDTO.setHorasReposo(antecedenteDTO.getHorasReposo());
        newAntecedenteIncidenteTrabajoDTO.setObservaciones(antecedenteDTO.getObservaciones());
        newAntecedenteIncidenteTrabajoDTO.setRecibioAtencion(antecedenteDTO.getRecibioAtencion()                );
        newAntecedenteIncidenteTrabajoDTO.setRiesgoImplicado(antecedenteDTO.getRiesgoImplicado());
        newAntecedenteIncidenteTrabajoDTO.setSecuelas(antecedenteDTO.getSecuelas());
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteIncidenteTrabajoDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("/")
    public ResponseEntity<AntecedenteIncidenteTrabajoDTO> save(@RequestBody AntecedenteIncidenteTrabajoDTO antecedente){
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        serviceAntecedente.delete(codigo);
    }
}
