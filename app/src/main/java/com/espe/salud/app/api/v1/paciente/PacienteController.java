package com.espe.salud.app.api.v1.paciente;


import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.service.paciente.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/")
    public ResponseEntity<PacienteDTO> save(@RequestBody PacienteDTO paciente){
        return new ResponseEntity<>(pacienteService.save(paciente), HttpStatus.CREATED);
    }


}
