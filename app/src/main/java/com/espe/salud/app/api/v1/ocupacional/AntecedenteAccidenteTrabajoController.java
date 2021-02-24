package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;
import com.espe.salud.service.ocupacional.AntecedenteAccidenteTrabajoService;
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

    @Operation(summary = "Retorna el listado de todos los antecedentes")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteAccidenteTrabajoDTO>> getAll() {
        return new ResponseEntity<>( serviceAntecedente.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteAccidenteTrabajoDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteAccidenteTrabajoDTO> update(@RequestBody AntecedenteAccidenteTrabajoDTO antecedenteDTO, @RequestParam Long codigo) {
        Optional<AntecedenteAccidenteTrabajoDTO> newAntecedenteAccidenteTrabajoDTOoptional = serviceAntecedente.findByCodigo(codigo);
        AntecedenteAccidenteTrabajoDTO newAntecedenteAccidenteTrabajoDTO = newAntecedenteAccidenteTrabajoDTOoptional.get();
        newAntecedenteAccidenteTrabajoDTO.setLugarAtencion(antecedenteDTO.getLugarAtencion());
        newAntecedenteAccidenteTrabajoDTO.setNaturaleza(antecedenteDTO.getNaturaleza());
        newAntecedenteAccidenteTrabajoDTO.setParteCuerpoAfectada(antecedenteDTO.getParteCuerpoAfectada());
        newAntecedenteAccidenteTrabajoDTO.setEmpresa(antecedenteDTO.getEmpresa());
        newAntecedenteAccidenteTrabajoDTO.setFecha(antecedenteDTO.getFecha());
        newAntecedenteAccidenteTrabajoDTO.setHorasReposo(antecedenteDTO.getHorasReposo());
        newAntecedenteAccidenteTrabajoDTO.setObservaciones(antecedenteDTO.getObservaciones());
        newAntecedenteAccidenteTrabajoDTO.setRecibioAtencion(antecedenteDTO.getRecibioAtencion()                );
        newAntecedenteAccidenteTrabajoDTO.setRiesgoImplicado(antecedenteDTO.getRiesgoImplicado());
        newAntecedenteAccidenteTrabajoDTO.setSecuelas(antecedenteDTO.getSecuelas());
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteAccidenteTrabajoDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("/")
    public ResponseEntity<AntecedenteAccidenteTrabajoDTO> save(@RequestBody AntecedenteAccidenteTrabajoDTO antecedente){
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        serviceAntecedente.delete(codigo);
    }
}
