package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.AntecedenteEnfermedadProfesionalDTO;
import com.espe.salud.dto.ocupacional.AntecedenteEnfermedadProfesionalDTO;
import com.espe.salud.service.ocupacional.AntecedenteEnfermedadProfesionalService;
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
import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_ENF_PRO;

@RestController
@Tag(description = "Gestiona los antecedentes de enfermedades profesionales", name = "Antecedentes de Enfermedades Profesionales")
@RequestMapping(value = URI_API_V1_ANT_ENF_PRO)
public class AntecedenteEnfermedadProfesionalController {
    private final AntecedenteEnfermedadProfesionalService serviceAntecedente;

    @Autowired
    public AntecedenteEnfermedadProfesionalController(
            @Qualifier("antecedenteEnfermedadProfesionalServiceImpl") AntecedenteEnfermedadProfesionalService serviceAntecedente
    ) {
        this.serviceAntecedente = serviceAntecedente;
    }
    
    @Operation(summary = "Retorna los antecedentes de enfermedades profesionales de un antecedente laboral")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<List<AntecedenteEnfermedadProfesionalDTO>> retrieveByAntecedenteLaboral(
            @Parameter(description = "El ID de un Antecedente Laboral", required = true, example = "1")
            @RequestParam Long idAntecedente
    ) {
        return new ResponseEntity<>(serviceAntecedente.findByAntecedenteLaboral(idAntecedente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<AntecedenteEnfermedadProfesionalDTO> retrieve(
            @Parameter(description = "El ID de la actividad extralaboral", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(id), HttpStatus.OK);
    }
    
    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("")
    public ResponseEntity<AntecedenteEnfermedadProfesionalDTO> save(@RequestBody AntecedenteEnfermedadProfesionalDTO antecedente){
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{id}")
    public void delete(
            @Parameter(description = "El ID del antecedente de enfermedades profesionales", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        serviceAntecedente.delete(id);
    }
    
    @Operation(summary = "Edita un antecedente por su id")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteEnfermedadProfesionalDTO> update(
            @RequestBody AntecedenteEnfermedadProfesionalDTO antecedenteDTO,
            @Parameter(description = "El ID del antecedente de enfermedades profesionales", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        Optional<AntecedenteEnfermedadProfesionalDTO> newAntecedenteEnfermedadProfesionalDTOoptional = serviceAntecedente.findByCodigo(id);
        AntecedenteEnfermedadProfesionalDTO newAntecedenteEnfermedadProfesionalDTO = newAntecedenteEnfermedadProfesionalDTOoptional.get();
        newAntecedenteEnfermedadProfesionalDTO.setLugarAtencion(antecedenteDTO.getLugarAtencion());
        newAntecedenteEnfermedadProfesionalDTO.setEmpresa(antecedenteDTO.getEmpresa());
        newAntecedenteEnfermedadProfesionalDTO.setFecha(antecedenteDTO.getFecha());
        newAntecedenteEnfermedadProfesionalDTO.setHorasReposo(antecedenteDTO.getHorasReposo());
        newAntecedenteEnfermedadProfesionalDTO.setObservaciones(antecedenteDTO.getObservaciones());
        newAntecedenteEnfermedadProfesionalDTO.setRecibioAtencion(antecedenteDTO.getRecibioAtencion()                );
        newAntecedenteEnfermedadProfesionalDTO.setRiesgoImplicado(antecedenteDTO.getRiesgoImplicado());
        newAntecedenteEnfermedadProfesionalDTO.setSecuelas(antecedenteDTO.getSecuelas());
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteEnfermedadProfesionalDTO), HttpStatus.CREATED) ;
    }

}
