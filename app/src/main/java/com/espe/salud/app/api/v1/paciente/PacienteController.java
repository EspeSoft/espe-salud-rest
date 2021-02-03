package com.espe.salud.app.api.v1.paciente;


import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.catalogo.ParentescoDTO;
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
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_PAC;

@RestController
@Tag(name = "Gestiona los pacientes")
@RequestMapping(value = {URI_API_V1_PAC})
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(
            PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Retorna el listado de todos los pacientes")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PacienteDTO>> getAll() {
        return new ResponseEntity<>( pacienteService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un paciente por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PacienteDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity( pacienteService.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un paciente por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO, @RequestParam Long codigo) {
        Optional<PacienteDTO> newPacienteDTOoptional = pacienteService.findByCodigo(codigo);
        PacienteDTO newPacienteDTO = newPacienteDTOoptional.get();
        newPacienteDTO.setActivo(pacienteDTO.getActivo());
        newPacienteDTO.setNumeroArchivo(pacienteDTO.getNumeroArchivo());
        newPacienteDTO.setAccesoBanner(pacienteDTO.getAccesoBanner());
        newPacienteDTO.setEsEmpleado(pacienteDTO.getEsEmpleado());
        newPacienteDTO.setEsEstudiante(pacienteDTO.getEsEstudiante());
        return new ResponseEntity<>(pacienteService.update(newPacienteDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo paciente")
    @PostMapping("/")
    public ResponseEntity<PacienteDTO> save(@RequestBody PacienteDTO paciente){
        return new ResponseEntity<>(pacienteService.save(paciente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un paciente por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        pacienteService.delete(codigo);
    }


}
