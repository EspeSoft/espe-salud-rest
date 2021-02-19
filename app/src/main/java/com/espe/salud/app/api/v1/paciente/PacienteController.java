package com.espe.salud.app.api.v1.paciente;

import com.espe.salud.dto.paciente.PacienteBannerDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.dto.paciente.PacienteExternoDTO;
import com.espe.salud.service.paciente.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_PAC;

@RestController
@Tag(description = "Gestiona los pacientes", name = "Pacientes")
@RequestMapping(value = {URI_API_V1_PAC})
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(
            PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Guarda un nuevo paciente, registrado en el sistema banner ESPE")
    @PostMapping("/save/banner/")
    public ResponseEntity<PacienteDTO> saveBanner(@Valid @RequestBody PacienteBannerDTO paciente){
        return new ResponseEntity<>(pacienteService.saveBanner(paciente), HttpStatus.CREATED);
    }

    @Operation(summary = "Guarda un nuevo paciente, externo a la ESPE")
    @PostMapping("/save/external/")
    public ResponseEntity<PacienteDTO> saveExternal(@Valid @RequestBody PacienteExternoDTO paciente){
        return new ResponseEntity<>(pacienteService.saveExternal(paciente), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un paciente por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<PacienteDTO> retrieve(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @PathVariable("id") Long id) {
        return pacienteService.findById(id)
                .map(pacienteDTO -> new ResponseEntity<>(pacienteDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}/disable")
    @Operation(summary = "Cambia el estado de un paciente a INACTIVO")
    public void darBajaPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @PathVariable Long id) {
        pacienteService.darBajaPaciente(id);
    }

    @Operation(summary = "Retorna la lista de pacientes que inicien con el número de archivo")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/search/numero-archivo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PacienteDTO>> findByNumeroArchivo(
            @Parameter(required = true, description = "Número de archivo del paciente", example = "0301971495")
            @RequestParam String numeroArchivo) {
        return new ResponseEntity<>( pacienteService.findByNumeroArchivo(numeroArchivo), HttpStatus.OK);
    }

    @Operation(summary = "Retorna la lista de pacientes que inicien con el nombre")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/search/fullname", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PacienteDTO>> findByFullNombre(
            @Parameter(required = true, description = "Nombre del paciente", example = "LUIS")
            @RequestParam String nombre) {
        return new ResponseEntity<>( pacienteService.findByFullName(nombre), HttpStatus.OK);
    }

    @Operation(summary = "Verifica si existe un paciente con el número de archivo")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/verify-exist")
    public ResponseEntity<Boolean> checkIfExistPaciente(
            @Parameter(required = true, description = "Número de archivo del paciente", example = "0301971495")
            @RequestParam String numeroArchivo){
        return new ResponseEntity<>(pacienteService.existsByNumeroArchivo(numeroArchivo), HttpStatus.OK);
    }
}
