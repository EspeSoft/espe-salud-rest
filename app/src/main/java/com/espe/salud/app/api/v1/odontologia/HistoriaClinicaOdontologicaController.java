package com.espe.salud.app.api.v1.odontologia;

import com.espe.salud.dto.odontologia.HistoriaClinicaOdontologicaDTO;
import com.espe.salud.service.odontologia.HistoriaClinicaOdontologicaService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_HIS_CLI_ODO;

@RestController
@Tag(description = "Gestiona las historias clínicas de un paciente", name = "Historía clínica odontológica")
@RequestMapping(value = {URI_API_V1_HIS_CLI_ODO})
public class HistoriaClinicaOdontologicaController {

    private final HistoriaClinicaOdontologicaService historiaClinicaOdontologicaService;

    @Autowired
    public HistoriaClinicaOdontologicaController(HistoriaClinicaOdontologicaService historiaClinicaOdontologicaService) {
        this.historiaClinicaOdontologicaService = historiaClinicaOdontologicaService;
    }

    @PostMapping("")
    @Operation(summary = "Guarda y retorna una nueva historia clínica")
    public ResponseEntity<HistoriaClinicaOdontologicaDTO> save(
            @RequestBody HistoriaClinicaOdontologicaDTO historiaClinicaOdontologicaDTO){
        return new ResponseEntity<>(historiaClinicaOdontologicaService.save(historiaClinicaOdontologicaDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Retorna el listado de todas las historias clínicas")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<HistoriaClinicaOdontologicaDTO>> getAll() {
        return new ResponseEntity<>(historiaClinicaOdontologicaService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/paciente", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Retorna la historia clínica de un paciente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<HistoriaClinicaOdontologicaDTO> getByPaciente(
            @Parameter(required = true, description = "El ID del paciente", example = "1")
            @RequestParam Long paciente) {
        return historiaClinicaOdontologicaService.findByPaciente(paciente)
                .map(historiaClinicaOdontologicaDTO -> new ResponseEntity<>(historiaClinicaOdontologicaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una historia clínica por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<HistoriaClinicaOdontologicaDTO> retrieve(
            @Parameter(description = "El ID de la historia clínica", required = true, example = "1")
            @PathVariable("id") Long id) {
        return historiaClinicaOdontologicaService.findById(id)
                .map(historiaClinicaOdontologicaDTO -> new ResponseEntity<>(historiaClinicaOdontologicaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Elimina una historia clínica por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo){
        historiaClinicaOdontologicaService.delete(codigo);
    }
    
    @Operation(summary = "Actualiza una historia clínica por su código")
    @PutMapping(value = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HistoriaClinicaOdontologicaDTO> update(
            @RequestBody HistoriaClinicaOdontologicaDTO dto,
            @PathVariable Long codigo) {
        Optional<HistoriaClinicaOdontologicaDTO> historiaClinicaOdontologicaOptional =  historiaClinicaOdontologicaService.findById(codigo);
        if(historiaClinicaOdontologicaOptional.isPresent()) {
            HistoriaClinicaOdontologicaDTO historiaClinicaOdontologicaDTO = historiaClinicaOdontologicaOptional.get();
            historiaClinicaOdontologicaDTO.setCodigoProfesional(dto.getCodigoProfesional());
            historiaClinicaOdontologicaDTO.setFechaApertura(dto.getFechaApertura());
            historiaClinicaOdontologicaDTO.setFechaControl(dto.getFechaControl());
            historiaClinicaOdontologicaDTO.setPacienteId(dto.getPacienteId());
            historiaClinicaOdontologicaDTO.setProfesional(dto.getProfesional());
            return new ResponseEntity<>(historiaClinicaOdontologicaService.update(historiaClinicaOdontologicaDTO), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
