package com.espe.salud.app.api.v1.paciente;


import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.service.paciente.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_PAC;

@RestController
@Tag(name = "Gestiona los pacientes de un paciente")
@RequestMapping(value = {URI_API_V1_PAC})
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(
            PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Retorna el listado de todos los pacientes")
    @GetMapping(value = "/pacientes", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PacienteDTO>> getAll(@RequestParam Long codigo) {
        return new ResponseEntity<>( pacienteService.findAll(codigo), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<PacienteDTO> save(@RequestBody PacienteDTO paciente){
        return new ResponseEntity<>(pacienteService.save(paciente), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pacienteService.delete(id);
    }


}
